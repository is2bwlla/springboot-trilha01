package br.ETS.Feedback.model.informacoes;

import br.ETS.Feedback.model.instrutor.Curso;
import br.ETS.Feedback.model.instrutor.Instrutor;

public record DadosInformacoesCompletasDoInstrutor(int id,
                                                   String nome,
                                                   String email,
                                                   String edv,
                                                   Curso curso,
                                                   Boolean ferias,
                                                   Boolean ativo,
                                                   Informacoes informacoes) {

    public DadosInformacoesCompletasDoInstrutor(Instrutor instrutor) {
        this(instrutor.getId(),
                instrutor.getNome(),
                instrutor.getEmail(),
                instrutor.getEdv(),
                instrutor.getCurso(),
                instrutor.getFerias(),
                instrutor.getAtivo(),
                instrutor.getInformacoes());
    }
}
