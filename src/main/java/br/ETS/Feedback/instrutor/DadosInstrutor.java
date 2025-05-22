package br.ETS.Feedback.instrutor;

import br.ETS.Feedback.informacoes.DadosInformacoes;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosInstrutor(@NotBlank String nome,
                             @NotBlank @Email String  email,
                             @NotBlank @Pattern(regexp = "^\\d{8}$") String edv,
                             @NotNull Curso curso,
                             @NotNull @Valid DadosInformacoes informacoes,
                             @NotNull Boolean ferias                              ) {
}
