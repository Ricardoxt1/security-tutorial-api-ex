package application.model;

import application.record.OpcaoDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "opcoes")
@Getter
@Setter
@NoArgsConstructor
public class Opcao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private boolean isCorreta;
    @ManyToOne
    @JoinColumn(name = "questao_id", nullable = false)
    private Questao questao;

    public Opcao(OpcaoDTO dto) {
        this.id = dto.id();
        this.descricao = dto.descricao();
        this.isCorreta = dto.isCorreta();
        
    }
}