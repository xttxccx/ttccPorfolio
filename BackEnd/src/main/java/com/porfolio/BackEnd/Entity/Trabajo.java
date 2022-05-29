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
public class Trabajo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTra;
    
    @NotNull @Size(min=1, max=225, message="error de longitud")
    private String tituloTra;
    
    @NotNull 
    private int fechaITra;
    
    private int fechaFTra;
   
    @NotNull @Size(min=1, max=500, message="error de longitud")
    private String descTra;
   
    @Size(min=1, max=300, message="error de longitud")
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
