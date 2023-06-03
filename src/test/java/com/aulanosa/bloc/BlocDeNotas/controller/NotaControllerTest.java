package com.aulanosa.bloc.BlocDeNotas.controller;

import com.aulanosa.bloc.BlocDeNotas.api.INotaService;
import com.aulanosa.bloc.BlocDeNotas.model.dto.NotaDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class NotaControllerTest {

    private MockMvc mockMvc;
    @Mock
    private INotaService iNotaService;
    @InjectMocks
    NotaController notaController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(notaController).build();
    }

    @Test
    public void testInsertNota() throws Exception {
        NotaDTO notaDTO = new NotaDTO();
        notaDTO.setId(1);
        notaDTO.setTitulo("Prueba");
        notaDTO.setDescripcion("Prueba");
        notaDTO.setFecha(LocalDateTime.now());
        mockMvc.perform(post("/nota/insertar").contentType(MediaType.APPLICATION_JSON).content("{\"idNota\":1,\"titulo\":\"Prueba\"," +
                        "\"descripcion\":\"" + "Prueba\"},\"fecha\":\"2021-05-12T12:00:00\""))
                .andExpect(status().isOk());
    }

    @Test
    public void testInsertNull() throws Exception {
        NotaDTO notaDTO = new NotaDTO();
        notaDTO.setTitulo(null);
        notaDTO.setDescripcion(null);
        notaDTO.setFecha(null);
        mockMvc.perform(post("/nota/insertar").contentType(MediaType.APPLICATION_JSON).content("{titulo\":null,\"descripcion\":null,\"fecha\":null}")).andExpect(status().is(400));
    }

    @Test
    public void testInsertNothing() throws Exception {
        mockMvc.perform(post("/nota/insertar")).andExpect(status().is(400));
    }

}
