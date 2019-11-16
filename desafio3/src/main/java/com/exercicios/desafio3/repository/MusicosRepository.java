package com.exercicios.desafio3.repository;

import com.exercicios.desafio3.model.Musicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

public interface MusicosRepository extends JpaRepository<Musicos, Long>{

}
