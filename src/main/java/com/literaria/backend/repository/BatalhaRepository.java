package com.literaria.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.literaria.backend.model.Batalha;

public interface BatalhaRepository extends JpaRepository<Batalha, Long>{
    
}
