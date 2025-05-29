package br.ETS.Feedback.model.aprendiz;

import br.ETS.Feedback.model.instrutor.Curso;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoAprendiz(@NotNull int id,
                                       String nome,
                                       @Email String email,
                                       @Pattern(regexp = "^\\d{8}$") String edv,
                                       Curso curso,
                                       Boolean ferias) {
}
