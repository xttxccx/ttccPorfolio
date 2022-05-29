
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
public class Formacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idForm;
    
    @NotNull @Size(min=1, max=225, message="error de longitud")
    private String tituloForm;
    
    @NotNull 
    private int fechaIForm;
    
    @NotNull
    private int fechaFForm;
    
    @NotNull @Size(min=1, max=500, message="error de longitud")
    private String descForm;
    
    @Size(min=1, max=300, message="error de longitud")
    private String imgForm;

    
    public Formacion() {
    }

    public Formacion(Long idForm, String tituloForm, int fechaIForm, int fechaFForm, String descForm, String imgForm) {
        this.idForm = idForm;
        this.tituloForm = tituloForm;
        this.fechaIForm = fechaIForm;
        this.fechaFForm = fechaFForm;
        this.descForm = descForm;
        this.imgForm = imgForm;
    }
    
      
    
}
