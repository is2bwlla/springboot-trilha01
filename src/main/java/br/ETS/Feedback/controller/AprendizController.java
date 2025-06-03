package br.ETS.Feedback.controller;

import br.ETS.Feedback.model.aprendiz.*;
import br.ETS.Feedback.model.informacoes.DadosInformacoesCompletasDoAprendiz;
import br.ETS.Feedback.model.instrutor.DadosAtualizacaoInstrutor;
import br.ETS.Feedback.model.instrutor.DadosListagemInstrutor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping ("/aprendiz")
public class AprendizController {

    @Autowired
    private AprendizRepository repository;

    @PostMapping
    public ResponseEntity<DadosListagemAprendiz> cadastrar(@RequestBody @Valid DadosCadastroAprendiz dadosCadastroAprendiz, UriComponentsBuilder uriComponentsBuilder) {
        var aprendiz = new Aprendiz(dadosCadastroAprendiz);
        repository.save(aprendiz);
        var uri = uriComponentsBuilder.path("/aprendiz/{id}").buildAndExpand(aprendiz.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemAprendiz(aprendiz));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemAprendiz>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var aprendiz = repository.findAll(paginacao).map(DadosListagemAprendiz::new);
        return ResponseEntity.ok(aprendiz.getContent());
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosInformacoesCompletasDoAprendiz> detalharAprendiz(@PathVariable int id) {
        var aprendiz = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosInformacoesCompletasDoAprendiz(aprendiz));
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<DadosListagemAprendiz> atualizar(@RequestBody @Valid DadosAtualizacaoAprendiz dadosAtualizacaoAprendiz) {
        var aprendiz = repository.getReferenceById(dadosAtualizacaoAprendiz.id());
        aprendiz.atualizar(dadosAtualizacaoAprendiz);
        return ResponseEntity.ok(new DadosListagemAprendiz(aprendiz));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
