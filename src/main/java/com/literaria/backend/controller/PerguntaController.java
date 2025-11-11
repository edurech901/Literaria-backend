
package com.literaria.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.literaria.backend.model.Pergunta;
import com.literaria.backend.service.PerguntaService;


@RestController
@RequestMapping("/pergunta")
public class PerguntaController {
    
    final private PerguntaService perguntaService;

    public PerguntaController(PerguntaService perguntaService) {
        this.perguntaService = perguntaService;
    }

    @PostMapping
    public ResponseEntity<Pergunta> criarPergunta(@RequestBody Pergunta pergunta) {
        Pergunta novaPergunta = perguntaService.salvarPergunta(pergunta);
        return ResponseEntity.ok(novaPergunta);
    }
}
