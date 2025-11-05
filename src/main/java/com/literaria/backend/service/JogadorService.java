package com.literaria.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.literaria.backend.model.Jogador;
import com.literaria.backend.repository.JogadorRepository;

@Service
public class JogadorService {
    
    @Autowired
    private JogadorRepository jogadorRepository;

    public Jogador salvar(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }
    
    public Jogador buscarPorId(Long id) {
        return jogadorRepository.findById(id).orElse(null);
    }

}
