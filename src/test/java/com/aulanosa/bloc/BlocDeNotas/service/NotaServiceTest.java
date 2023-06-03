package com.aulanosa.bloc.BlocDeNotas.service;

import com.aulanosa.bloc.BlocDeNotas.api.NotaService;
import com.aulanosa.bloc.BlocDeNotas.model.Nota;
import com.aulanosa.bloc.BlocDeNotas.model.dao.NotaDAO;
import com.aulanosa.bloc.BlocDeNotas.model.dto.NotaDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.when;

@SpringBootTest
public class NotaServiceTest {
    private MockMvc mockMvc;
    @Mock
    NotaService notaService;
    @Mock
    private NotaDAO notaDao;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(notaService).build();
    }

    @Test
    public void testInsertNota() {
        NotaDTO notaDto = new NotaDTO();
        notaDto.setTitulo("Nota de prueba");
        notaDto.setDescripcion("Contenido de prueba");
        notaDto.setFecha(LocalDateTime.now());

        Nota nota = new Nota();
        nota.setTitulo("Nota de prueba");
        nota.setDescripcion("Contenido de prueba");

        when(notaDao.saveAndFlush(any(Nota.class))).thenReturn(nota);
        int result = notaService.insertNota(notaDto);
        assertEquals(0, result);
    }
}
