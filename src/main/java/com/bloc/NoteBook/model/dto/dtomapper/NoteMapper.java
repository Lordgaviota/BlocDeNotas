package com.bloc.NoteBook.model.dto.dtomapper;

import com.bloc.NoteBook.model.Note;
import com.bloc.NoteBook.model.dto.NoteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Interface that defines the methods to be implemented
 */

@Mapper
public interface NoteMapper {

    NoteMapper INSTANCE = Mappers.getMapper(NoteMapper.class);

    NoteDTO toDto(Note note);

    Note toEntity(NoteDTO noteDto);

    List<NoteDTO> toDtoList(List<Note> notes);

}
