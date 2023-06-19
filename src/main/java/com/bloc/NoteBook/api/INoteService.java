package com.bloc.NoteBook.api;

import com.bloc.NoteBook.model.dto.NoteDTO;

import java.util.List;

/**
 * Interface of the service layer that defines the methods to be implemented
 */


public interface INoteService {

    NoteDTO queryNote(NoteDTO noteDTO);

    List<NoteDTO> queryAllNotes();

    int insertNote(NoteDTO noteDTO);

    int updateNote(NoteDTO noteDTO);

    int deleteNote(NoteDTO noteDTO);
}
