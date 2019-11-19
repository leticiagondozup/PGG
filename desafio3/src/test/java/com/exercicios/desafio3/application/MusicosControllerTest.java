package com.exercicios.desafio3.application;


import com.exercicios.desafio3.application.TerceiroDesafioApplication;
import com.exercicios.desafio3.application.controller.MusicosController;
import com.exercicios.desafio3.application.model.Musicos;
import com.exercicios.desafio3.application.service.MusicosService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MusicosController.class)
public class MusicosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MusicosService musicosService;

    private Musicos musicos;

    @Before
    public void prepara(){

        musicos = new Musicos();
        musicos.setId((long) 1);
        musicos.setNome("leticia");
        musicos.setCpf("46150771814");
    }

    @Test
    public void testarCriarMusicos() throws Exception {
        musicos.setId((long) 10);
        given(musicosService.save(musicos)).willReturn(musicos);

        this.mockMvc.perform(
                post("/api/musicos")
                        .content(transformarEmJson(musicos))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated());
    }

    @Test
    public void testarApagarMusicosSeIdExiste() throws Exception {
        musicos.setId((long) 1);
        this.mockMvc.perform(delete("/api/musicos/{id}", 1))
                .andExpect(status().isNotFound());
    }


    @Test
    public void testarApagarMusicosSeIdNaoExiste() throws Exception {
        this.mockMvc.perform(delete("/api/musicos/{id}", 3))
                .andExpect(status().isNotFound());
    }


        public static String transformarEmJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    
}
