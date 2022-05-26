
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
public class Proyectos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProy;
    
    @NotNull @Size(min=1, max=225, message="error de longitud")
    private String tituloProy;
    
    @NotNull 
    private int fechaProy;
   
    @NotNull @Size(min=1, max=500, message="error de longitud")
    private String descProy;
   
    @NotNull @Size(min=1, max=300, message="error de longitud")
    private String imgProy;
    
    @Size(min=1, max=300, message="error de longitud")
    private String linkProy;

    public Proyectos() {
    }

    public Proyectos(Long idProy, String tituloProy, int fechaProy, String descProy, String imgProy, String linkProy) {
        this.idProy = idProy;
        this.tituloProy = tituloProy;
        this.fechaProy = fechaProy;
        this.descProy = descProy;
        this.imgProy = imgProy;
        this.linkProy = linkProy;
    }
    
    
}
