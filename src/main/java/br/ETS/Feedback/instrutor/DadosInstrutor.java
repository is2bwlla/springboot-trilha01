package br.ETS.Feedback.instrutor;

import br.ETS.Feedback.informacoes.DadosInformacoes;

public record DadosInstrutor(String nome,
                             String email,
                             String edv,
                             Curso curso,
                             DadosInformacoes dadosInformacoes) {
}
