
package com.porfolio.BackEnd.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreP;
    private int anioP;
    private String descripcionP;
    private String imgP;  
    private String linkP;  

    public Proyecto() {
    }

    public Proyecto(String nombreP, int anioP, String descripcionP, String imgP, String linkP) {
        this.nombreP = nombreP;
        this.anioP = anioP;
        this.descripcionP = descripcionP;
        this.imgP = imgP;
        this.linkP = linkP;
    }
    
    

}
