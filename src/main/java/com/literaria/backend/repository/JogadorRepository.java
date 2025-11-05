package com.literaria.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.literaria.backend.model.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
    
}
