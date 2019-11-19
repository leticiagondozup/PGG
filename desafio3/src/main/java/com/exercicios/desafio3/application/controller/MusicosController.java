package com.exercicios.desafio3.application.controller;

import com.exercicios.desafio3.application.model.Musicos;

import com.exercicios.desafio3.application.service.MusicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class MusicosController {

    @Autowired
    private MusicosService service;



    public MusicosController (MusicosService service) {
        this.service = service;
    }


   @PostMapping
   @RequestMapping("musico")
    public Musicos create(@Valid @RequestBody Musicos musicos){
        return service.save(musicos);
    }

    @GetMapping
    public List<Musicos> findAll(){
        return service.findAll();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Musicos musicos) {
        return service.findById(id)
                .map(musico -> {
                    musico.setNome(musicos.getNome());
                    musico.setCpf(musicos.getCpf());
                    Musicos updated = service.save(musico);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable long id) {
        return service.findById(id)
                .map(musico -> {
                    service.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }


    public void setService(MusicosService service) {
        this.service = service;
    }

    public void setMusicos(Musicos musicos){}
}
