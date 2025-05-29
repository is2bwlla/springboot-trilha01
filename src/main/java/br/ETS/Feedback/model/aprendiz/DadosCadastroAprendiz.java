package br.ETS.Feedback.model.aprendiz;

import br.ETS.Feedback.model.instrutor.Curso;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroAprendiz(@NotBlank String nome,
                                    @NotBlank @Email String email,
                                    @NotBlank @Pattern(regexp = "^\\d{8}$") String edv,
                                    @NotNull Curso curso,
                                    @NotNull Boolean ferias) {
}
