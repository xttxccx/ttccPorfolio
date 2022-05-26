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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull @Size(min=1, max=30, message="error de longitud")
    private String anio;
    
    @NotNull @Size(min=1, max=200, message="error de longitud")
    private String empleo;
     
    @Size(min=1, max=500, message="error de longitud")
    private String descripcion;
    
    @Size(min=1, max=100, message="error de longitud")
    private String img;

}
