package br.ETS.Feedback.instrutor;

import br.ETS.Feedback.informacoes.Informacoes;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity (name = "Instrutor")
@Table (name = "tbinstrutores")
public class Instrutor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String edv;
    @Enumerated(EnumType.STRING)
    private Curso curso;

    @Embedded
    private Informacoes informacoes;

    private Boolean ferias;

    public Instrutor (DadosInstrutor dadosInstrutor) {
        this.nome = dadosInstrutor.nome();
        this.email = dadosInstrutor.email();
        this.edv = dadosInstrutor.edv();
        this.curso = dadosInstrutor.curso();
        this.informacoes = new Informacoes(dadosInstrutor.informacoes());
        this.ferias = dadosInstrutor.ferias();
    }
}
