package com.literaria.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
    
}
