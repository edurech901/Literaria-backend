package com.literaria.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.literaria.backend.model.Mundo;

public interface MundoRepository extends JpaRepository<Mundo, Long> {

}
