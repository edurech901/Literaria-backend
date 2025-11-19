package com.literaria.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.literaria.backend.model.Batalha;
import com.literaria.backend.model.Npc;
import com.literaria.backend.model.Pergunta;
import com.literaria.backend.repository.BatalhaRepository;
import com.literaria.backend.repository.NpcRepository;
import com.literaria.backend.repository.PerguntaRepository;

@Service
public class BatalhaService {

    @Autowired
    private BatalhaRepository batalhaRepository;

    @Autowired
    private PerguntaRepository perguntaRepository;

    @Autowired
    private NpcRepository npcRepository;

    public Batalha salvarBatalha(Batalha novaBatalha) {
        List<Pergunta> perguntas = novaBatalha.getPerguntas().stream()
                .map(p -> perguntaRepository.findById(p.getId()).orElseThrow())
                .toList();
        for (Pergunta p : perguntas) {
            p.setBatalha(novaBatalha);
        }
        novaBatalha.setPerguntas(perguntas);

        List<Npc> npcs = novaBatalha.getNpcs().stream()
                .map(p -> npcRepository.findById(p.getId()).orElseThrow())
                .toList();
        for (Npc n : npcs) {
            n.setBatalha(novaBatalha);
        }
        novaBatalha.setNpcs(npcs);

        return batalhaRepository.save(novaBatalha);
    }

    public Batalha buscarBatalhaPorId(Long id) {
        return batalhaRepository.findById(id).orElse(null);
    }

    public void editarBatalhaPorId(Long id, Batalha dadosAtualizados) {
        Batalha batalha = batalhaRepository.findById(id).orElseThrow();
        batalha.setMundo(dadosAtualizados.getMundo());
        if (dadosAtualizados.getPerguntas() != null) {
            List<Pergunta> perguntasAtualizadas = dadosAtualizados.getPerguntas().stream()
                    .map(p -> perguntaRepository.findById(p.getId()).orElseThrow())
                    .toList();
            List<Pergunta> perguntasExistentes = batalha.getPerguntas();
            perguntasExistentes.stream()
                    .filter(p -> !perguntasAtualizadas.contains(p))
                    .forEach(p -> p.setBatalha(null));
            for (Pergunta p : perguntasAtualizadas) {
                p.setBatalha(batalha);
            }
            perguntasExistentes.clear();
            perguntasExistentes.addAll(perguntasAtualizadas);
        }
        if (dadosAtualizados.getNpcs() != null) {
            List<Npc> npcsAtualizados = dadosAtualizados.getNpcs().stream()
                    .map(n -> npcRepository.findById(n.getId()).orElseThrow())
                    .toList();
            List<Npc> npcsExistentes = batalha.getNpcs();
            npcsExistentes.stream()
                    .filter(n -> !npcsAtualizados.contains(n))
                    .forEach(n -> n.setBatalha(null));
            for (Npc n : npcsAtualizados) {
                n.setBatalha(batalha);
            }
            npcsExistentes.clear();
            npcsExistentes.addAll(npcsAtualizados);
        }
        batalhaRepository.save(batalha);
    }

    public void deletar(Long id) {
        batalhaRepository.deleteById(id);
    }

}
