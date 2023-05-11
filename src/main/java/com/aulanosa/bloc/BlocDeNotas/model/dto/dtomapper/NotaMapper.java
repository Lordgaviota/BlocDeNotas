package com.aulanosa.bloc.BlocDeNotas.model.dto.dtomapper;

import com.aulanosa.bloc.BlocDeNotas.model.Nota;
import com.aulanosa.bloc.BlocDeNotas.model.dto.NotaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface NotaMapper {

    NotaMapper INSTANCE = Mappers.getMapper(NotaMapper.class);

    NotaDTO toDto(Nota nota);

    Nota toEntity(NotaDTO notaDto);

    List<NotaDTO> toDtoList(List<Nota> notas);

}
