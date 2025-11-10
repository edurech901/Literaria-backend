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

import com.literaria.backend.model.Jogador;
import com.literaria.backend.service.JogadorService;

@RestController
@RequestMapping("/Jogador")
public class JogadorController {

    private final JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @PostMapping
    public ResponseEntity<Jogador> criarJogador(@RequestBody Jogador jogador) {
        Jogador novoJogador = jogadorService.salvar(jogador);
        return ResponseEntity.ok(novoJogador);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> buscarJogadorPorId(@PathVariable Long id) {
        Jogador jogador = jogadorService.buscarPorId(id);
        if (jogador != null) {
            return ResponseEntity.ok(jogador);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogador> atualizarJogador(@PathVariable Long id, @RequestBody Jogador dadosAtualizados) {
        Jogador atualizado = jogadorService.atualizar(id, dadosAtualizados);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarJogador(@PathVariable Long id) {
        jogadorService.deletar(id);
        return ResponseEntity.git add .
        noContent().build();
    }

}
