package application.controller;

import application.record.QuestaoDTO;
import application.service.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questoes")
public class QuestaoController {
    @Autowired
    private QuestaoService questaoService;

    @GetMapping
    public Iterable<QuestaoDTO> getAllQuestoes() {
        return questaoService.getAll();
    }

    @PostMapping
    public QuestaoDTO insertQuestao(@RequestBody QuestaoDTO questaoDTO) {
        return questaoService.insert(questaoDTO);
    }
}