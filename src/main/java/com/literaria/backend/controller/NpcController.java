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

import com.literaria.backend.model.Npc;
import com.literaria.backend.service.NpcService;

@RestController
@RequestMapping("/npc")
public class NpcController {

    private final NpcService npcService;

    public NpcController(NpcService npcService) {
        this.npcService = npcService;
    }

    @PostMapping
    public ResponseEntity<Npc> criarNpc(@RequestBody Npc npc) {
        Npc novoNpc = npcService.salvarNpc(npc);
        return ResponseEntity.ok(novoNpc);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Npc> buscarNpcPorId(@PathVariable Long id) {
        return ResponseEntity.ok(npcService.buscarNpcById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Npc> atualizarNpc(@PathVariable Long id, @RequestBody Npc npcDetails) {
        Npc npcAtualizado = npcService.atualizarNpcPorId(id, npcDetails);
        if (npcAtualizado != null) {
            return ResponseEntity.ok(npcAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarNpc(@PathVariable Long id) {
        npcService.deleteNpc(id);
        return ResponseEntity.noContent().build();
    }

}
