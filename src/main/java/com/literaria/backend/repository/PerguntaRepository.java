package com.literaria.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.literaria.backend.model.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long>{
    
}
