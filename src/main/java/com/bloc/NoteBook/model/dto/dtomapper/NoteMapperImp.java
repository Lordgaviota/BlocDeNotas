package com.bloc.NoteBook.model.dto.dtomapper;

import com.bloc.NoteBook.model.Note;
import com.bloc.NoteBook.model.dto.NoteDTO;

import java.util.ArrayList;
import java.util.List;

public class NoteMapperImp implements NoteMapper {

    /**
     * Class that implements the methods of the interface
     */

    @Override
    public NoteDTO toDto(Note note) {
        if (note == null) {
            return null;
        }
        NoteDTO noteDto = new NoteDTO();

        noteDto.setId(note.getId());
        noteDto.setTitle(note.getTitle());
        noteDto.setDescription(note.getDescription());
        noteDto.setDate(note.getDate());

        return noteDto;
    }

    @Override
    public Note toEntity(NoteDTO noteDto) {
        if (noteDto == null) {
            return null;
        }
        Note note = new Note();

        note.setId(noteDto.getId());
        note.setTitle(noteDto.getTitle());
        note.setDescription(noteDto.getDescription());
        note.setDate(noteDto.getDate());

        return note;
    }

    @Override
    public List<NoteDTO> toDtoList(List<Note> notes) {
        if (notes == null) {
            return null;
        }
        List<NoteDTO> list = new ArrayList<>(notes.size());
        for (Note note : notes) {
            list.add(toDto(note));
        }
        return list;
    }
}
