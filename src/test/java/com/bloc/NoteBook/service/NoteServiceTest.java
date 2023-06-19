package com.bloc.NoteBook.service;

import com.bloc.NoteBook.api.NoteService;
import com.bloc.NoteBook.model.Note;
import com.bloc.NoteBook.model.dao.NoteDAO;
import com.bloc.NoteBook.model.dto.NoteDTO;
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
public class NoteServiceTest {
    private MockMvc mockMvc;
    @Mock
    NoteService notaService;
    @Mock
    private NoteDAO notaDao;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(notaService).build();
    }

    @Test
    public void testInsertNota() {
        NoteDTO noteDto = new NoteDTO();
        noteDto.setTitle("Test note");
        noteDto.setDescription("Test content");
        noteDto.setDate(LocalDateTime.now());

        Note nota = new Note();
        nota.setTitle("Test note");
        nota.setDescription("Test content");

        when(notaDao.saveAndFlush(any(Note.class))).thenReturn(nota);
        int result = notaService.insertNote(noteDto);
        assertEquals(0, result);
    }
}
