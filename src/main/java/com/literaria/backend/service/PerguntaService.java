package com.literaria.backend.service;

import org.springframework.stereotype.Service;

import com.literaria.backend.model.Pergunta;
import com.literaria.backend.repository.PerguntaRepository;

@Service
public class PerguntaService {
    
    private final PerguntaRepository perguntaRepository;

    public PerguntaService(PerguntaRepository perguntaRepository) {
        this.perguntaRepository = perguntaRepository;
    }

    public Pergunta salvarPergunta(Pergunta novaPergunta) {
        return perguntaRepository.save(novaPergunta);
    }

}
