
package com.porfolio.BackEnd.Dto;

import javax.validation.constraints.NotBlank;


public class dtoTrabajo {
    
    @NotBlank
    private String nombreT;
    private int fechaIT;
    private int fechaFT;
    @NotBlank
    private String descripcionT;
    private String imgT;

    public dtoTrabajo() {
    }

    public dtoTrabajo(String nombreT, int fechaIT, int fechaFT, String descripcionT, String imgT) {
        this.nombreT = nombreT;
        this.fechaIT = fechaIT;
        this.fechaFT = fechaFT;
        this.descripcionT = descripcionT;
        this.imgT = imgT;
    }

    public String getNombreT() {
        return nombreT;
    }

    public void setNombreT(String nombreT) {
        this.nombreT = nombreT;
    }

    public int getFechaIT() {
        return fechaIT;
    }

    public void setFechaIT(int fechaIT) {
        this.fechaIT = fechaIT;
    }

    public int getFechaFT() {
        return fechaFT;
    }

    public void setFechaFT(int fechaFT) {
        this.fechaFT = fechaFT;
    }

    public String getDescripcionT() {
        return descripcionT;
    }

    public void setDescripcionT(String descripcionT) {
        this.descripcionT = descripcionT;
    }

    public String getImgT() {
        return imgT;
    }

    public void setImgT(String imgT) {
        this.imgT = imgT;
    }
    
    
}
