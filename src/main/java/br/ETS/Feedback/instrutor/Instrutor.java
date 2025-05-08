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
@Table (name = "tbInstrutores")
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

    public Instrutor (DadosInstrutor dadosInstrutor) {
        this.nome = dadosInstrutor.nome();
        this.email = dadosInstrutor.email();
        this.edv = dadosInstrutor.edv();
        this.curso = dadosInstrutor.curso();
    }

}
