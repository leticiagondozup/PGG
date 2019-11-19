package com.exercicios.desafio3.application.repository;

import com.exercicios.desafio3.application.model.Musicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicosRepository extends JpaRepository<Musicos, Long>{

}
