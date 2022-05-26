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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTra;
    private String tituloTra;
    private int fechaITra;
    private int fechaFTra;
    private String descTra;
    private String imgTra;

    public Trabajo() {
    }

    public Trabajo(Long idTra, String tituloTra, int fechaITra, int fechaFTra, String descTra, String imgTra) {
        this.idTra = idTra;
        this.tituloTra = tituloTra;
        this.fechaITra = fechaITra;
        this.fechaFTra = fechaFTra;
        this.descTra = descTra;
        this.imgTra = imgTra;
    }

  
    
    
}
