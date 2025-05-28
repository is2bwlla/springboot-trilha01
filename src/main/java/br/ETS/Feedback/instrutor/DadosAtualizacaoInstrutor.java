package br.ETS.Feedback.instrutor;

import br.ETS.Feedback.informacoes.DadosInformacoes;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoInstrutor(@NotNull int id,
                                        String nome,
                                        @Email String email,
                                        @Pattern(regexp = "^\\d{8}$") String edv,
                                        Curso curso,
                                        Boolean ferias,
                                        DadosInformacoes informacoes) {

}
