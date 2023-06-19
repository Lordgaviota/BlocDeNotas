package com.bloc.NoteBook.controller;

import com.bloc.NoteBook.api.INoteService;
import com.bloc.NoteBook.model.dto.NoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Controller class that defines the methods to be implemented
 */

@RestController()
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private INoteService noteService;

    @GetMapping(value = "/consult")
    public NoteDTO queryNote(@RequestBody NoteDTO noteDTO) {
        if (noteDTO == null) {
            throw new IllegalArgumentException("NotaDTO can't be null");
        } else {
            return noteService.queryNote(noteDTO);
        }
    }

    @GetMapping(value = "/consultAll")
    public List<NoteDTO> queryAllNotes() {
        if (noteService.queryAllNotes().isEmpty()) {
            throw new IllegalArgumentException("Don't have notes");
        } else {
            return noteService.queryAllNotes();
        }
    }

    @PostMapping(value = "/insert")
    public int addNote(@RequestBody NoteDTO noteDTO) {
        if (noteDTO == null) {
            throw new IllegalArgumentException("NoteDTO can't be null");
        } else {
            LocalDateTime localDateTime = LocalDateTime.now();
            noteDTO.setDate(localDateTime);
            return noteService.insertNote(noteDTO);
        }
    }

    @PutMapping(value = "/update")
    public int updateNote(@RequestBody NoteDTO noteDTO) {
        if (noteDTO == null) {
            throw new IllegalArgumentException("NoteDTO can't be null");
        } else {
            LocalDateTime localDateTime = LocalDateTime.now();
            noteDTO.setDate(localDateTime);
            return noteService.updateNote(noteDTO);
        }
    }

    @DeleteMapping(value = "/delete")
    public int deleteNote(@RequestBody NoteDTO noteDTO) {
        if (noteDTO == null) {
            throw new IllegalArgumentException("NoteDTO can't be null");
        } else {
            return noteService.deleteNote(noteDTO);
        }
    }
}
