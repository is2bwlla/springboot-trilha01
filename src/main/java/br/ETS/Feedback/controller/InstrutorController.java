package br.ETS.Feedback.controller;

import br.ETS.Feedback.instrutor.DadosInstrutor;
import br.ETS.Feedback.instrutor.Instrutor;
import br.ETS.Feedback.instrutor.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/instrutor")
public class InstrutorController {

    @Autowired
    private InstrutorRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosInstrutor dadosInstrutor) {
        System.out.println(dadosInstrutor);
        repository.save(new Instrutor(dadosInstrutor));
    }
}
