package com.porfolio.BackEnd.Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Perfil implements Serializable {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    
    @NotNull @Size(min=1, max=50, message="error de longitud")
    private String nombre;
    
    @NotNull @Size(min=1, max=50, message="error de longitud")
    private String apodo;
    
    @NotNull @Size(min=1, max=100, message="error de longitud")
    private String imgPerfil;
    
    @NotNull @Size(min=1, max=100, message="error de longitud")
    private String banner;
    
    @NotNull @Size(min=1, max=225, message="error de longitud")
    private String titulo;
    
    @NotNull @Size(min=1, max=500, message="error de longitud")
    private String descripcion;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idForm")
    private List<Formacion> formacionList; 
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idDoc")
    private List<Docencia> docenciaList; 
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idTra")
    private List<Trabajo> trabajoList; 
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idSkill")
    private List<Skills> skillsList;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idProy")
    private List<Proyectos> proyectosList;

    public Perfil() {
    }

    public Perfil(Long id, String nombre, String apodo, String imgPerfil, String banner, String titulo, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.apodo = apodo;
        this.imgPerfil = imgPerfil;
        this.banner = banner;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

