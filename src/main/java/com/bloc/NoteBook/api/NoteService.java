package com.bloc.NoteBook.api;

import com.bloc.NoteBook.model.Note;
import com.bloc.NoteBook.model.dao.NoteDAO;
import com.bloc.NoteBook.model.dto.NoteDTO;
import com.bloc.NoteBook.model.dto.dtomapper.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Interface of the service layer that defines the methods to be implemented
 */

@Service("NotaService")
@Lazy
public class NoteService implements INoteService {

    @Autowired
    private NoteDAO noteDAO;

    @Override
    public NoteDTO queryNote(NoteDTO noteDTO) {
        Note note = NoteMapper.INSTANCE.toEntity(noteDTO);
        return NoteMapper.INSTANCE.toDto(noteDAO.findByTitle(note.getTitle()));
    }

    @Override
    public List<NoteDTO> queryAllNotes() {
        return NoteMapper.INSTANCE.toDtoList(noteDAO.findAll());
    }

    @Override
    public int insertNote(NoteDTO noteDTO) {
        Note note = NoteMapper.INSTANCE.toEntity(noteDTO);
        noteDAO.saveAndFlush(note);
        return note.getId();
    }

    @Override
    @Transactional
    public int updateNote(NoteDTO noteDTO) {
        Note note = NoteMapper.INSTANCE.toEntity(noteDTO);
        noteDAO.updateByTitle(note.getTitle(), note.getDescription(), note.getDate());
        return note.getId();
    }


    @Override
    @Transactional
    public int deleteNote(NoteDTO noteDTO) {
        noteDAO.deleteByTitle(noteDTO.getTitle());
        return 1;

    }

}
