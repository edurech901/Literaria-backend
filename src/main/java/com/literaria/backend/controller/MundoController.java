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

import com.literaria.backend.model.Mundo;
import com.literaria.backend.service.MundoService;

@RestController
@RequestMapping("/mundo")
public class MundoController {
    
    private final MundoService mundoService;

    public MundoController(MundoService mundoService) {
        this.mundoService = mundoService;
    }

    @PostMapping
    public ResponseEntity<Mundo> criarMundo(@RequestBody Mundo mundo) {
        Mundo novoMundo = mundoService.salvarMundo(mundo);
        return ResponseEntity.ok(novoMundo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mundo> buscarMundoPorId(@PathVariable Long id) {
        Mundo mundo = mundoService.buscarMundoPorId(id);
        if (mundo != null) {
            return ResponseEntity.ok(mundo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mundo> atualizarMundo(@PathVariable Long id, @RequestBody Mundo dadosAtualizados) {
        Mundo mundoAtualizado = mundoService.atualizarMundoPorId(id, dadosAtualizados);
        return ResponseEntity.ok(mundoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMundo(@PathVariable Long id) {
        mundoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
