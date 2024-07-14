package com.clase10.proyectofinal.Models;

import jakarta.persistence.*;

@Entity
@Table(name="libro")
public class LibroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;
    private String autor;
    private Integer anio;

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }
}
