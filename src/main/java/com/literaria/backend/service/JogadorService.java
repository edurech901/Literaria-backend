package com.literaria.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.literaria.backend.model.Jogador;
import com.literaria.backend.repository.JogadorRepository;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    public Jogador salvarJogador(Jogador novoJogador) {
        return jogadorRepository.save(novoJogador);
    }

    public Jogador buscarPorId(Long id) {
        return jogadorRepository.findById(id).orElse(null);
    }

    public Jogador atualizar(Long id, Jogador dadosAtualizados) {
        Jogador jogador = jogadorRepository.findById(id).orElseThrow();
        if (jogador == null) {
            return null;
        }
        if (dadosAtualizados.getNome() != null) {
            jogador.setNome(dadosAtualizados.getNome());
        }
        if (dadosAtualizados.getPronome() != null) {
            jogador.setPronome(dadosAtualizados.getPronome());
        }
        jogador.setVida(dadosAtualizados.getVida());
        return jogadorRepository.save(jogador);
    }

    public void deletar(Long id) {
        jogadorRepository.deleteById(id);
    }

}
