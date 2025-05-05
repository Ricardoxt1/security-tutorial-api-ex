package application.service;

import application.model.Opcao;
import application.model.Questao;
import application.record.OpcaoDTO;
import application.repository.OpcaoRepository;
import application.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpcaoService {
    @Autowired
    private OpcaoRepository opcaoRepo;
    @Autowired
    private QuestaoRepository questaoRepo;

    public Iterable<OpcaoDTO> getAll() {
        return opcaoRepo.findAll().stream().map(OpcaoDTO::new).toList();
    }

    public OpcaoDTO insert(OpcaoDTO opcaoDTO) {
        Opcao opcao = new Opcao(opcaoDTO);
        if (opcaoDTO.questaoId() != null) {
            Questao questao = questaoRepo.findById(opcaoDTO.questaoId())
                    .orElseThrow(() -> new RuntimeException("Questão não encontrada com o ID: " + opcaoDTO.questaoId()));
            opcao.setQuestao(questao);
        }
        return new OpcaoDTO(opcaoRepo.save(opcao));
    }
}