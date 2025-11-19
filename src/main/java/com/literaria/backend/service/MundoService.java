package com.literaria.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.literaria.backend.model.Batalha;
import com.literaria.backend.model.Mundo;
import com.literaria.backend.repository.BatalhaRepository;
import com.literaria.backend.repository.MundoRepository;

@Service
public class MundoService {

    @Autowired
    private MundoRepository mundoRepository;

    @Autowired
    private BatalhaRepository batalhaRepository;

    public Mundo salvarMundo(Mundo novoMundo) {
        List<Batalha> batalhas = novoMundo.getBatalhas() == null
                ? new java.util.ArrayList<>()
                : novoMundo.getBatalhas().stream()
                        .map(p -> batalhaRepository.findById(p.getId()).orElseThrow())
                        .toList();
        for (Batalha b : batalhas) {
            b.setMundo(novoMundo);
        }
        novoMundo.setBatalhas(batalhas);

        return mundoRepository.save(novoMundo);
    }

    public Mundo buscarMundoPorId(Long id) {
        return mundoRepository.findById(id).orElse(null);
    }

    public Mundo atualizarMundoPorId(Long id, Mundo dadosAtualizados) {
        Mundo mundo = mundoRepository.findById(id).orElseThrow();
        if (dadosAtualizados.getNome() != null) {
            mundo.setNome(dadosAtualizados.getNome());
        }
        if (dadosAtualizados.getDescricao() != null) {
            mundo.setDescricao(dadosAtualizados.getDescricao());
        }
        if (dadosAtualizados.getBatalhas() != null) {
            List<Batalha> batalhasAtualizadas = dadosAtualizados.getBatalhas().stream()
                    .map(p -> batalhaRepository.findById(p.getId()).orElseThrow())
                    .toList();
            
            for (Batalha b : batalhasAtualizadas) {
                b.setMundo(mundo);
            }
            List<Batalha> batalhasExistentes = mundo.getBatalhas();
            batalhasExistentes.stream()
                    .filter(b -> !batalhasAtualizadas.contains(b))
                    .forEach(b -> b.setMundo(null));
            batalhasExistentes.clear();
            batalhasExistentes.addAll(batalhasAtualizadas);
        }
        return mundoRepository.save(mundo);
    }

    public void deletar(Long id) {
        mundoRepository.deleteById(id);
    }

}
