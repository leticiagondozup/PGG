package com.exercicios.desafio3.application.service;


import com.exercicios.desafio3.application.model.Musicos;
import com.exercicios.desafio3.application.repository.MusicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicosService {

    @Autowired
    private MusicosRepository musicosRepository;

    private Musicos musicos;

    public MusicosService() {
    }

    public Optional<Musicos> findById(Long id) {
        return musicosRepository.findById(id);
    }

    public List<Musicos> findAll() {
        return musicosRepository.findAll();
    }

    public Musicos save(Musicos musicos) {
        return musicosRepository.save(musicos);
    }

    public void deleteById(long id) {
        musicosRepository.deleteById(id);
    }

    public void deleteAll() {
        musicosRepository.deleteAll();
    }

    public Musicos update( Musicos musicos) {
        return musicosRepository.save(musicos);
    }

    public void setMusicosRepository(MusicosRepository musicosRepository) {
        this.musicosRepository = musicosRepository;
    }

    public void setMusicos(Musicos musicos){
        this.musicos = musicos;
    }


}
