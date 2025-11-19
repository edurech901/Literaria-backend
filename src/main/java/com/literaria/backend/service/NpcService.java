package com.literaria.backend.service;

import org.springframework.stereotype.Service;

import com.literaria.backend.model.Npc;
import com.literaria.backend.repository.NpcRepository;

@Service
public class NpcService {
    
    private final NpcRepository NpcRepository;

    public NpcService(NpcRepository NpcRepository) {
        this.NpcRepository = NpcRepository;
    }

    public Npc salvarNpc(Npc Npc) {
        return NpcRepository.save(Npc);
    }

    public Npc buscarNpcById(Long id) {
        return NpcRepository.findById(id).orElse(null);
    }

    public Npc atualizarNpcPorId(Long id, Npc NpcDetails) {
        Npc Npc = buscarNpcById(id);
        if (Npc != null) {
            Npc.setNome(NpcDetails.getNome());
            Npc.setDescricao(NpcDetails.getDescricao());
            Npc.setTipo(NpcDetails.getTipo());
            return NpcRepository.save(Npc);
        }
        return null;
    }

    public void deleteNpc(Long id) {
        NpcRepository.deleteById(id);
    }
}
