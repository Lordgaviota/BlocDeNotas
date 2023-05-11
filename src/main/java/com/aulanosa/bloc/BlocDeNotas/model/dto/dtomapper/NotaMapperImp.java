package com.aulanosa.bloc.BlocDeNotas.model.dto.dtomapper;

import com.aulanosa.bloc.BlocDeNotas.model.Nota;
import com.aulanosa.bloc.BlocDeNotas.model.dto.NotaDTO;

import java.util.ArrayList;
import java.util.List;

public class NotaMapperImp implements NotaMapper {

    @Override
    public NotaDTO toDto(Nota nota) {
        if (nota == null) {
            return null;
        }
        NotaDTO notaDto = new NotaDTO();

        notaDto.setId(nota.getId());
        notaDto.setTitulo(nota.getTitulo());
        notaDto.setDescripcion(nota.getDescripcion());
        notaDto.setFecha(nota.getFecha());

        return notaDto;
    }

    @Override
    public Nota toEntity(NotaDTO notaDto) {
        if (notaDto == null) {
            return null;
        }
        Nota nota = new Nota();

        nota.setId(notaDto.getId());
        nota.setTitulo(notaDto.getTitulo());
        nota.setDescripcion(notaDto.getDescripcion());
        nota.setFecha(notaDto.getFecha());

        return nota;
    }

    @Override
    public List<NotaDTO> toDtoList(List<Nota> notas) {
        if (notas == null) {
            return null;
        }
        List<NotaDTO> list = new ArrayList<>(notas.size());
        for (Nota nota : notas) {
            list.add(toDto(nota));
        }
        return list;
    }
}
