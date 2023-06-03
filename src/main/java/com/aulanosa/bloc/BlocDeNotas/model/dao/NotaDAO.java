package com.aulanosa.bloc.BlocDeNotas.model.dao;

import com.aulanosa.bloc.BlocDeNotas.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface NotaDAO extends JpaRepository<Nota, Integer> {

    Nota findByTitulo(String titulo);

    void deleteByTitulo(String titulo);

    @Modifying
    @Query("UPDATE Nota SET descripcion = :descripcion, fecha = :fecha WHERE titulo = :titulo")
    void updateByTitulo(String titulo, String descripcion, LocalDateTime fecha);
}
