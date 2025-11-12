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

    public Pergunta buscarPerguntaPorId(Long id) {
        return perguntaRepository.findById(id).orElse(null);
    }

    public Pergunta atualizarPerguntaPorId(Long id, Pergunta dadosAtualizados) {
        Pergunta pergunta = perguntaRepository.findById(id).orElseThrow();
        if (pergunta == null) {
            return null;
        }
        if (dadosAtualizados == null) {
            return null;
        }
        if (dadosAtualizados.getEnunciado() != null) {
            pergunta.setEnunciado(dadosAtualizados.getEnunciado());
        }
        if (dadosAtualizados.getAlternativa1() != null) {
            pergunta.setAlternativa1(dadosAtualizados.getAlternativa1());
        }
        if (dadosAtualizados.getAlternativa2() != null) {
            pergunta.setAlternativa2(dadosAtualizados.getAlternativa2());
        }
        if (dadosAtualizados.getAlternativa3() != null) {
            pergunta.setAlternativa3(dadosAtualizados.getAlternativa3());
        }
        if (dadosAtualizados.getAlternativa4() != null) {
            pergunta.setAlternativa4(dadosAtualizados.getAlternativa4());
        }
        if (dadosAtualizados.getResposta() != 0) {
            pergunta.setResposta(dadosAtualizados.getResposta());
        }
        return perguntaRepository.save(pergunta);
    }

    public void deletarPerguntaPorId(Long id) {
        perguntaRepository.deleteById(id);
    }

}
