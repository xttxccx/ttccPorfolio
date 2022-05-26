
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
public class Skills {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSkill;
    
    @NotNull @Size(min=1, max=50, message="error de longitud")
    private String nombreSkill;
    
    @NotNull 
    private int porcentajeSkill;
    
    @Size(min=1, max=300, message="error de longitud")
    private String imgSkill;

    public Skills() {
    }

    public Skills(Long idSkill, String nombreSkill, int porcentajeSkill, String imgSkill) {
        this.idSkill = idSkill;
        this.nombreSkill = nombreSkill;
        this.porcentajeSkill = porcentajeSkill;
        this.imgSkill = imgSkill;
    }
    
    
    
}
