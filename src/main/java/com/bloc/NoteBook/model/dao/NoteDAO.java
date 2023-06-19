package com.bloc.NoteBook.model.dao;

import com.bloc.NoteBook.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

/**
 * DAO class of the Note entity
 */

public interface NoteDAO extends JpaRepository<Note, Integer> {

    Note findByTitle(String title);

    void deleteByTitle(String title);

    @Modifying
    @Query("UPDATE Note SET description = :description, date = :date WHERE title = :title")
    void updateByTitle(String title, String description, LocalDateTime date);
}
