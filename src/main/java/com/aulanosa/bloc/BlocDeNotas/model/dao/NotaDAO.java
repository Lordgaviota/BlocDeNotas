package com.aulanosa.bloc.BlocDeNotas.model.dao;

import com.aulanosa.bloc.BlocDeNotas.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaDAO extends JpaRepository<Nota, Integer> {
}
