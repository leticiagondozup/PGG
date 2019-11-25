package com.exercicios.desafio3.application;

import com.exercicios.desafio3.application.controller.MusicosController;
import com.exercicios.desafio3.application.model.Musicos;
import com.exercicios.desafio3.application.repository.MusicosRepository;
import com.exercicios.desafio3.application.service.MusicosService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.exercicios.desafio3.application.MusicosControllerTest.transformarEmJson;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(MusicosController.class)
public class MusicosServiceTest {


    @Autowired
    private MockMvc mockMvc;


    private MusicosService service;
    private MusicosRepository repository;
    private Musicos musicos;
    private List<Musicos> list;


    public MusicosServiceTest(){}

    @Before
    public void prepara(){
        this.service = new MusicosService();
        repository = Mockito.mock(MusicosRepository.class);
        service.setMusicosRepository(repository);

        musicos = new Musicos();

        musicos.setId((long) 1);
        musicos.setNome("Leticia");
        musicos.setCpf("46150771814");
    }

    @Test
    public void testUpdate(){
        when(repository.save(musicos)).thenReturn(musicos);
        Assert.assertEquals(musicos, service.update(musicos));
    }







}
