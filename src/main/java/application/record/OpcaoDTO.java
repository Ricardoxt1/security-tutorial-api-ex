package application.record;

public record OpcaoDTO(Long id, String descricao, boolean isCorreta, Long questaoId) {
    public OpcaoDTO(application.model.Opcao model) {
        this(model.getId(), model.getDescricao(), model.isCorreta(), model.getQuestao().getId());
    }
}