package com.porfolio.BackEnd.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Formacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreF;
    private int fechaIF;
    private int fechaFF;
    private String descripcionF;
    private String imgF;   

    public Formacion() {
    }

    public Formacion(String nombreF, int fechaIF, int fechaFF, String descripcionF, String imgF) {
        this.nombreF = nombreF;
        this.fechaIF = fechaIF;
        this.fechaFF = fechaFF;
        this.descripcionF = descripcionF;
        this.imgF = imgF;
    }    
  
}
