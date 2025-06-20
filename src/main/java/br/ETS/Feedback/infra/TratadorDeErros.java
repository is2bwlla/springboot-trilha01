package br.ETS.Feedback.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class                          )
    public ResponseEntity Error404NotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity Error400BadRequest(MethodArgumentNotValidException e) {
        var erros = e.getFieldErrors();
        return  ResponseEntity.badRequest().body(erros.stream().map(Dadosvalidacao::new));
    }
}
