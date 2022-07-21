package com.porfolio.BackEnd.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Perfil {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apodo;
    private String imgPerfil;
    private String banner;
    private String titulo;
    private String descripcion;

    public Perfil() {
    }

    public Perfil(String nombre, String apodo, String imgPerfil, String banner, String titulo, String descripcion) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.imgPerfil = imgPerfil;
        this.banner = banner;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
    
}

