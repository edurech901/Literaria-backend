package com.literaria.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.literaria.backend.model.Batalha;
import com.literaria.backend.repository.BatalhaRepository;

@Service
public class BatalhaService {
    
    @Autowired
    private BatalhaRepository batalhaRepository;

    public Batalha salvarBatalha(Batalha novaBatalha) {
        return batalhaRepository.save(novaBatalha);
    }
}
