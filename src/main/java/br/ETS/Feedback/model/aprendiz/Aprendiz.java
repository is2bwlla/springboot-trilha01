package br.ETS.Feedback.model.aprendiz;

import br.ETS.Feedback.model.instrutor.Curso;
import br.ETS.Feedback.model.instrutor.DadosAtualizacaoInstrutor;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity (name = "Aprendiz")
@Table (name = "tbaprendizes")
public class Aprendiz {
    // As annotations abaixo são para identificar que o int id é um ID e que ele é único e gerado automaticamente
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String email;
    private String edv;

    // A annotation abaixo é para definir o curso como um enum de opções pré-setadas.
    @Enumerated(EnumType.STRING)
    private Curso curso;

    private Boolean ferias;

    public Aprendiz (DadosCadastroAprendiz dadosCadastroAprendiz) {
        this.nome = dadosCadastroAprendiz.nome();
        this.email = dadosCadastroAprendiz.email();
        this.edv = dadosCadastroAprendiz.edv();
        this.curso = dadosCadastroAprendiz.curso();
        this.ferias = dadosCadastroAprendiz.ferias();
    }

    public void atualizar(DadosAtualizacaoAprendiz dadosAtualizacaoAprendiz) {
        if (dadosAtualizacaoAprendiz.nome() !=null) {
            this.nome = dadosAtualizacaoAprendiz.nome();
        }
        if (dadosAtualizacaoAprendiz.email() !=null) {
            this.email = dadosAtualizacaoAprendiz.email();
        }
        if (dadosAtualizacaoAprendiz.edv() !=null) {
            this.edv = dadosAtualizacaoAprendiz.edv();
        }
        if (dadosAtualizacaoAprendiz.curso() !=null) {
            this.curso = dadosAtualizacaoAprendiz.curso();
        }
        if (dadosAtualizacaoAprendiz.ferias() !=null) {
            this.ferias = dadosAtualizacaoAprendiz.ferias();
        }
    }
}
