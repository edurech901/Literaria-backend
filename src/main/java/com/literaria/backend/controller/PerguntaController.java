
package com.literaria.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/{id}")
    public ResponseEntity<Pergunta> getPerguntaById(@PathVariable Long id) {
        Pergunta pergunta = perguntaService.buscarPerguntaPorId(id);
        if (pergunta != null) {
            return ResponseEntity.ok(pergunta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pergunta> editarPergunta(@PathVariable Long id, @RequestBody Pergunta dadosAtualizados) {
        perguntaService.atualizarPerguntaPorId(id, dadosAtualizados);
        Pergunta perguntaAtualizada = perguntaService.buscarPerguntaPorId(id);
        return ResponseEntity.ok(perguntaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPergunta(@PathVariable Long id) {
        perguntaService.deletarPerguntaPorId(id);
        return ResponseEntity.noContent().build();
    }

}
