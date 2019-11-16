package com.exercicios.desafio3.controller;

import com.exercicios.desafio3.model.Musicos;
import com.exercicios.desafio3.repository.MusicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/musicos")
public class MusicosController {

    private MusicosRepository repository;

    MusicosController(MusicosRepository musicosRepository) {
        this.repository = musicosRepository;
    }


    @PostMapping
    public ResponseEntity<Musicos> create (@RequestBody Musicos musicos){
        Musicos create = repository.save(musicos);
        return ResponseEntity.ok().body(create);
    }

    @GetMapping
    public List findAll(){
        return repository.findAll();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Musicos musicos) {
        return repository.findById(id)
                .map(musico -> {
                    musico.setNome(musicos.getNome());
                    musico.setCpf(musicos.getCpf());
                    Musicos updated = repository.save(musico);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable long id) {
        return repository.findById(id)
                .map(musico -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
