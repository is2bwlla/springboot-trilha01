package br.ETS.Feedback.instrutor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Instrutor {
    private String nome;
    private String email;
    private String edv;
    private Curso curso;

}
