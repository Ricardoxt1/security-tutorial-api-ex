package application.record;

import java.util.List;

public record QuestaoDTO(Long id, String enunciado, Long categoriaId, List<OpcaoDTO> opcoes) {
    public QuestaoDTO(application.model.Questao model) {
        this(model.getId(), model.getEnunciado(), model.getCategoria().getId(),
                model.getOpcoes() != null ? model.getOpcoes().stream().map(OpcaoDTO::new).toList() : null);
    }
}