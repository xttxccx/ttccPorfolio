package com.porfolio.BackEnd.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Docencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDoc;
    
    @NotNull @Size(min=1, max=225, message="error de longitud")
    private String tituloDoc;
    
    @NotNull 
    private int fechaIDoc;
    
    private int fechaFDoc;
    
    @NotNull @Size(min=1, max=500, message="error de longitud")
    private String descDoc;
    
    @Size(min=1, max=300, message="error de longitud")
    private String imgDoc;
    
        
    /*@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull @Size(min=1, max=30, message="error de longitud")
    private String anio;
    
    @NotNull @Size(min=1, max=200, message="error de longitud")
    private String empleo;
     
    @Size(min=1, max=500, message="error de longitud")
    private String descripcion;
    
    @Size(min=1, max=100, message="error de longitud")
    private String img;*/

    public Docencia() {
    }

    public Docencia(Long idDoc, String tituloDoc, int fechaIDoc, int fechaFDoc, String descDoc, String imgDoc) {
        this.idDoc = idDoc;
        this.tituloDoc = tituloDoc;
        this.fechaIDoc = fechaIDoc;
        this.fechaFDoc = fechaFDoc;
        this.descDoc = descDoc;
        this.imgDoc = imgDoc;
    }
    
    

}
