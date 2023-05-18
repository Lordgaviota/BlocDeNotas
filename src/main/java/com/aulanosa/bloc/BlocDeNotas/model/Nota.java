package com.aulanosa.bloc.BlocDeNotas.model;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "NOTAS")
public class Nota {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Column
    private String titulo;

    @Column
    private String descripcion;

    @Column
    private LocalDateTime fecha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
