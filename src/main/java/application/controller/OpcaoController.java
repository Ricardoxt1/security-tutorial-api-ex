package application.controller;

import application.record.OpcaoDTO;
import application.service.OpcaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/opcoes")
public class OpcaoController {
    @Autowired
    private OpcaoService opcaoService;

    @GetMapping
    public Iterable<OpcaoDTO> getAllOpcoes() {
        return opcaoService.getAll();
    }

    @PostMapping
    public OpcaoDTO insertOpcao(@RequestBody OpcaoDTO opcaoDTO) {
        return opcaoService.insert(opcaoDTO);
    }
}