package br.ETS.Feedback.model.aprendiz;

import br.ETS.Feedback.model.instrutor.Curso;

public record DadosListagemAprendiz(String nome,
                                    String email,
                                    String edv,
                                    Boolean ferias,
                                    Curso curso) {

    public DadosListagemAprendiz(Aprendiz aprendiz) {
        this(aprendiz.getNome(),
                aprendiz.getEmail(),
                aprendiz.getEdv(),
                aprendiz.getFerias(),
                aprendiz.getCurso());
    }
}
