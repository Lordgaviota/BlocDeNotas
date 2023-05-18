package com.aulanosa.bloc.BlocDeNotas.api;

import com.aulanosa.bloc.BlocDeNotas.model.Nota;
import com.aulanosa.bloc.BlocDeNotas.model.dao.NotaDAO;
import com.aulanosa.bloc.BlocDeNotas.model.dto.NotaDTO;
import com.aulanosa.bloc.BlocDeNotas.model.dto.dtomapper.NotaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("NotaService")
@Lazy
public class NotaService implements INotaService {

    @Autowired
    private NotaDAO notaDAO;

    @Override
    public NotaDTO queryNota(NotaDTO notaDTO) {
        Nota nota = NotaMapper.INSTANCE.toEntity(notaDTO);
        return NotaMapper.INSTANCE.toDto(notaDAO.findByTitulo(nota.getTitulo()));
    }

    @Override
    public List<NotaDTO> queryAllNotas() {
        return NotaMapper.INSTANCE.toDtoList(notaDAO.findAll());
    }

    @Override
    public int insertNota(NotaDTO notaDTO) {
        Nota nota = NotaMapper.INSTANCE.toEntity(notaDTO);
        notaDAO.saveAndFlush(nota);
        return nota.getId();
    }

    @Override
    public int updateNota(NotaDTO notaDTO) {
        return insertNota(notaDTO);
    }

    @Override
    @Transactional
    public int deleteNota(NotaDTO notaDTO) {
        notaDAO.deleteByTitulo(notaDTO.getTitulo());
        return 1;

    }

}
