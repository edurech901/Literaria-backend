package com.literaria.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.literaria.backend.model.Batalha;
import com.literaria.backend.model.Pergunta;
import com.literaria.backend.repository.BatalhaRepository;
import com.literaria.backend.repository.PerguntaRepository;

@Service
public class BatalhaService {

    @Autowired
    private BatalhaRepository batalhaRepository;

    @Autowired
    private PerguntaRepository perguntaRepository;

    public Batalha salvarBatalha(Batalha novaBatalha) {
        List<Pergunta> perguntas = novaBatalha.getPerguntas().stream()
                .map(p -> perguntaRepository.findById(p.getId()).orElseThrow())
                .toList();
        for (Pergunta p : perguntas) {
            p.setBatalha(novaBatalha);
        }
        novaBatalha.setPerguntas(perguntas);

        return batalhaRepository.save(novaBatalha);
    }

    public Batalha buscarBatalhaPorId(Long id) {
        return batalhaRepository.findById(id).orElse(null);
    }

    public void editarBatalhaPorId(Long id, Batalha dadosAtualizados) {
        Batalha batalha = batalhaRepository.findById(id).orElseThrow();
        batalha.setMundo(dadosAtualizados.getMundo());
        batalha.setNpcs(dadosAtualizados.getNpcs());
        if (dadosAtualizados.getPerguntas() != null) {
            List<Pergunta> perguntasAtualizadas = dadosAtualizados.getPerguntas().stream()
                    .map(p -> perguntaRepository.findById(p.getId()).orElseThrow())
                    .toList();
            for (Pergunta p : perguntasAtualizadas) {
                p.setBatalha(batalha);
            }
            List<Pergunta> perguntasExistentes = batalha.getPerguntas();
            perguntasExistentes.clear();
            perguntasExistentes.addAll(perguntasAtualizadas);
        }
        batalhaRepository.save(batalha);
    }

    public void deletar(Long id) {
        batalhaRepository.deleteById(id);
    }

}
