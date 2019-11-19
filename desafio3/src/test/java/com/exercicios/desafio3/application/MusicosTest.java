package com.exercicios.desafio3.application;

import com.exercicios.desafio3.application.model.Musicos;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.junit.Assert.assertEquals;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class MusicosTest {

    private Musicos musicos;

    @Before
    public void prepara(){

        musicos = new Musicos();
        musicos.setId((long) 1);
        musicos.setNome("leticia");
        musicos.setCpf("46150771814");
    }

    @Test
    public void testarCriacaoMusicosNome() {
        assertEquals("leticia", musicos.getNome());
    }

    @Test
    public void testarCriacaoMusicosCpf() {
        assertEquals("46150771814", musicos.getCpf());
    }


}
