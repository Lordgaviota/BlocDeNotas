package com.aulanosa.bloc.BlocDeNotas.controller;

import com.aulanosa.bloc.BlocDeNotas.api.INotaService;
import com.aulanosa.bloc.BlocDeNotas.model.dto.NotaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController()
@RequestMapping("/nota")
public class NotaController {

    @Autowired
    private INotaService notaService;

    @GetMapping(value = "/consultar")
    public NotaDTO queryNota(@RequestBody NotaDTO notaDTO) {
        if (notaDTO == null) {
            throw new IllegalArgumentException("NotaDTO no puede ser nulo");
        } else {
            return notaService.queryNota(notaDTO);
        }
    }

    @GetMapping(value = "/consultarTodos")
    public List<NotaDTO> queryAllNotas() {
        if (notaService.queryAllNotas().isEmpty()) {
            throw new IllegalArgumentException("No hay notas");
        } else {
            return notaService.queryAllNotas();
        }
    }

    @PostMapping(value = "/insertar")
    public int addNota(@RequestBody NotaDTO notaDTO) {
        if (notaDTO == null) {
            throw new IllegalArgumentException("NotaDTO no puede ser nulo");
        } else {
            LocalDateTime localDateTime = LocalDateTime.now();
            notaDTO.setFecha(localDateTime);
            return notaService.insertNota(notaDTO);
        }
    }

    @PutMapping(value = "/actualizar")
    public int updateNota(@RequestBody NotaDTO notaDTO) {
        if (notaDTO == null) {
            throw new IllegalArgumentException("NotaDTO no puede ser nulo");
        } else {
            LocalDateTime localDateTime = LocalDateTime.now();
            notaDTO.setFecha(localDateTime);
            return notaService.updateNota(notaDTO);
        }
    }

    @DeleteMapping(value = "/eliminar")
    public int deleteNota(@RequestBody NotaDTO notaDTO) {
        if (notaDTO == null) {
            throw new IllegalArgumentException("NotaDTO no puede ser nulo");
        } else {
            return notaService.deleteNota(notaDTO);
        }
    }
}
