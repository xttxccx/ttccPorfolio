
package com.porfolio.BackEnd.Dto;

import javax.validation.constraints.NotBlank;


public class dtoPerfil {
    
    @NotBlank
    private String nombre;
    private String apodo;
    @NotBlank
    private String imgPerfil;
    @NotBlank
    private String banner;
    private String titulo;
    private String descripcion;

    public dtoPerfil() {
    }

    public dtoPerfil(String nombre, String apodo, String imgPerfil, String banner, String titulo, String descripcion) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.imgPerfil = imgPerfil;
        this.banner = banner;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
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
    
    
}
