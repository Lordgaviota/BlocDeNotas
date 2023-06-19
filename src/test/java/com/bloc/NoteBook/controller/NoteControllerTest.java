package com.bloc.NoteBook.controller;

import com.bloc.NoteBook.api.INoteService;
import com.bloc.NoteBook.model.dto.NoteDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class NoteControllerTest {

    private MockMvc mockMvc;
    @Mock
    private INoteService iNotaService;
    @InjectMocks
    NoteController notaController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(notaController).build();
    }

    @Test
    public void testInsertNote() throws Exception {
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setId(1);
        noteDTO.setTitle("Test");
        noteDTO.setDescription("Test");
        noteDTO.setDate(LocalDateTime.now());
        mockMvc.perform(post("/note/insert").contentType(MediaType.APPLICATION_JSON).content("{\"idNote\":1,\"title\":\"Test\"," +
                        "\"description\":\"" + "Test description\"},\"date\":\"2021-05-12T12:00:00\""))
                .andExpect(status().isOk());
    }

    @Test
    public void testInsertNull() throws Exception {
        NoteDTO notaDTO = new NoteDTO();
        notaDTO.setTitle(null);
        notaDTO.setDescription(null);
        notaDTO.setDate(null);
        mockMvc.perform(post("/note/insert").contentType(MediaType.APPLICATION_JSON).content("{title\":null,\"description\":null,\"date\":null}")).andExpect(status().is(400));
    }

    @Test
    public void testInsertNothing() throws Exception {
        mockMvc.perform(post("/note/insert")).andExpect(status().is(400));
    }

}
