
package com.porfolio.BackEnd.Dto;

import javax.validation.constraints.NotBlank;


public class dtoProyecto {
    
    @NotBlank    
    private String nombreP;
    private int anioP;
    @NotBlank
    private String descripcionP;
    private String imgP;  
    private String linkP;  

    public dtoProyecto() {
    }

    public dtoProyecto(String nombreP, int anioP, String descripcionP, String imgP, String linkP) {
        this.nombreP = nombreP;
        this.anioP = anioP;
        this.descripcionP = descripcionP;
        this.imgP = imgP;
        this.linkP = linkP;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public int getAnioP() {
        return anioP;
    }

    public void setAnioP(int anioP) {
        this.anioP = anioP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getImgP() {
        return imgP;
    }

    public void setImgP(String imgP) {
        this.imgP = imgP;
    }

    public String getLinkP() {
        return linkP;
    }

    public void setLinkP(String linkP) {
        this.linkP = linkP;
    }
    
    
    
    
}
