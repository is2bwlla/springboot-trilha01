package br.ETS.Feedback.controller;

import br.ETS.Feedback.instrutor.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping ("/instrutor")
public class InstrutorController {

    @Autowired
    private InstrutorRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroInstrutor dadosCadastroInstrutor) {
        repository.save(new Instrutor(dadosCadastroInstrutor));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemInstrutor>> listar(Pageable pageable) {
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemInstrutor::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PutMapping
    public ResponseEntity<DadosListagemInstrutor> atualizar(@RequestBody @Valid DadosAtualizacaoInstrutor dadosAtualizacaoInstrutor) {
        var instrutor = repository.getReferenceById(dadosAtualizacaoInstrutor.id());
        instrutor.atualizar(dadosAtualizacaoInstrutor);
        return ResponseEntity.ok(new DadosListagemInstrutor(instrutor));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Instrutor> excluir(@PathVariable int id) {
        var instrutor = repository.getReferenceById(id);
        instrutor.excluir();
        return ResponseEntity.noContent().build();
    }
}
