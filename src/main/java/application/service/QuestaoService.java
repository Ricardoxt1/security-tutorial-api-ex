package application.service;

import application.model.Categoria;
import application.model.Questao;
import application.record.QuestaoDTO;
import application.repository.CategoriaRepository;
import application.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestaoService {
    @Autowired
    private QuestaoRepository questaoRepo;
    @Autowired
    private CategoriaRepository categoriaRepo;

    public Iterable<QuestaoDTO> getAll() {
        return questaoRepo.findAll().stream().map(QuestaoDTO::new).toList();
    }

    @Transactional
    public QuestaoDTO insert(QuestaoDTO questaoDTO) {
        Questao questao = new Questao(questaoDTO);
        if (questaoDTO.categoriaId() != null) {
            Categoria categoria = categoriaRepo.findById(questaoDTO.categoriaId())
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada com o ID: " + questaoDTO.categoriaId()));
            questao.setCategoria(categoria);
        }
        return new QuestaoDTO(questaoRepo.save(questao));
    }
}