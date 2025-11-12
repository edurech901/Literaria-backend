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

import com.literaria.backend.model.Batalha;
import com.literaria.backend.service.BatalhaService;

@RestController()
@RequestMapping("/batalha")
public class BatalhaController {
    
    final private BatalhaService batalhaService;

    public BatalhaController(BatalhaService batalhaService) {
        this.batalhaService = batalhaService;
    }

    @PostMapping
    public ResponseEntity<Batalha> criarBatalha(@RequestBody Batalha batalha) {
        Batalha novaBatalha = batalhaService.salvarBatalha(batalha);
        return ResponseEntity.ok(novaBatalha);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Batalha> getBatalhaById(@PathVariable long id) {
        Batalha batalha = batalhaService.buscarBatalhaPorId(id);
        if (batalha != null) {
            return ResponseEntity.ok(batalha);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Batalha> editarBatalha(@PathVariable Long id, @RequestBody Batalha dadosAtualizados) {
        batalhaService.editarBatalhaPorId(id, dadosAtualizados);
        Batalha batalhaAtualizada = batalhaService.buscarBatalhaPorId(id);
        return ResponseEntity.ok(batalhaAtualizada);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarBatalha(@PathVariable Long id) {
        batalhaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
