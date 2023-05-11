package com.aulanosa.bloc.BlocDeNotas.api;

import com.aulanosa.bloc.BlocDeNotas.model.dto.NotaDTO;

import java.util.List;

public interface INotaService {

    NotaDTO queryNota(NotaDTO notaDTO);

    List<NotaDTO> queryAllNotas();

    int insertNota(NotaDTO notaDTO);

    int updateNota(NotaDTO notaDTO);

    int deleteNota(NotaDTO notaDTO);
}
