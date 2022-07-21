
package com.porfolio.BackEnd.Dto;

import javax.validation.constraints.NotBlank;


public class dtoSkill {
    
    @NotBlank  
    private String nombreS;
    @NotBlank
    private int porcentajeS;

    public dtoSkill() {
    }

    public dtoSkill(String nombreS, int porcentajeS) {
        this.nombreS = nombreS;
        this.porcentajeS = porcentajeS;
    }

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public int getPorcentajeS() {
        return porcentajeS;
    }

    public void setPorcentajeS(int porcentajeS) {
        this.porcentajeS = porcentajeS;
    }

    
    
        
}
