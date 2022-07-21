package com.porfolio.BackEnd.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Trabajo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreT;
    private int fechaIT;
    private int fechaFT;
    private String descripcionT;
    private String imgT;

    public Trabajo() {
    }

    public Trabajo(String nombreT, int fechaIT, int fechaFT, String descripcionT, String imgT) {
        this.nombreT = nombreT;
        this.fechaIT = fechaIT;
        this.fechaFT = fechaFT;
        this.descripcionT = descripcionT;
        this.imgT = imgT;
    }       
}

