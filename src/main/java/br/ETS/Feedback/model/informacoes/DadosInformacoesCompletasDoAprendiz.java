package br.ETS.Feedback.model.informacoes;

import br.ETS.Feedback.model.aprendiz.Aprendiz;
import br.ETS.Feedback.model.instrutor.Curso;

public record DadosInformacoesCompletasDoAprendiz(int id,
                                                   String nome,
                                                   String email,
                                                   String edv,
                                                   Curso curso,
                                                   Boolean ferias) {

    public DadosInformacoesCompletasDoAprendiz(Aprendiz aprendiz) {
        this(aprendiz.getId(),
                aprendiz.getNome(),
                aprendiz.getEmail(),
                aprendiz.getEdv(),
                aprendiz.getCurso(),
                aprendiz.getFerias());
    }
}
