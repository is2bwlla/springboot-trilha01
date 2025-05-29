package br.ETS.Feedback.infra;

import org.springframework.validation.FieldError;

public record Dadosvalidacao(String field,
                             String message) {

    public Dadosvalidacao(FieldError fieldError) {
        this(fieldError.getField(),
                fieldError.getDefaultMessage());
    }
}
