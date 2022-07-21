package com.porfolio.BackEnd.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Docencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreD;
    private int fechaID;
    private int fechaFD;
    private String descripcionD;
    private String imgD;   

    public Docencia() {
    }

    public Docencia(String nombreD, int fechaID, int fechaFD, String descripcionD, String imgD) {
        this.nombreD = nombreD;
        this.fechaID = fechaID;
        this.fechaFD = fechaFD;
        this.descripcionD = descripcionD;
        this.imgD = imgD;
    }

}
