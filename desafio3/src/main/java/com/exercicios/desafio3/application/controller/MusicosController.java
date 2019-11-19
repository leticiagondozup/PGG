package com.exercicios.desafio3.application.controller;

import com.exercicios.desafio3.application.model.Musicos;

import com.exercicios.desafio3.application.service.MusicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/musicos")
public class MusicosController {

    @Autowired
    private MusicosService service;

    public MusicosController (MusicosService service) {
        this.service = service;
    }


   @PostMapping
    public ResponseEntity<Musicos> create(@Valid @RequestBody Musicos musicos){
       Musicos create = service.save(musicos);
       return ResponseEntity.status(HttpStatus.CREATED).body(create);

    }

    @GetMapping
    public List<Musicos> findAll(){
        return service.findAll();
    }

    @PutMapping(path="/{id}")
    public ResponseEntity update(@PathVariable long id,
                                 @RequestBody Musicos musicos) {
        return service.findById(id)
                .map(musico -> {
                    musico.setNome(musicos.getNome());
                    musico.setCpf(musicos.getCpf());
                    Musicos update = service.update(musico);
                    return ResponseEntity.status(HttpStatus.OK).body(update);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable long id) {
        return service.findById(id)
                .map(musico -> {
                    service.deleteById(id);
                    return ResponseEntity.status(HttpStatus.ACCEPTED).build();
                }).orElse(ResponseEntity.notFound().build());
    }


    public void setService(MusicosService service) {
        this.service = service;
    }

    public void setMusicos(Musicos musicos){}
}
