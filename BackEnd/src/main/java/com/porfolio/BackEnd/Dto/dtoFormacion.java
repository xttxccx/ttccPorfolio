
package com.porfolio.BackEnd.Dto;

import javax.validation.constraints.NotBlank;


public class dtoFormacion {
    
    @NotBlank
    private String nombreF;
    private int fechaIF;
    private int fechaFF;
    @NotBlank
    private String descripcionF;
    private String imgF;

    public dtoFormacion() {
    }

    public dtoFormacion(String nombreF, int fechaIF, int fechaFF, String descripcionF, String imgF) {
        this.nombreF = nombreF;
        this.fechaIF = fechaIF;
        this.fechaFF = fechaFF;
        this.descripcionF = descripcionF;
        this.imgF = imgF;
    }

    public String getNombreF() {
        return nombreF;
    }

    public void setNombreF(String nombreF) {
        this.nombreF = nombreF;
    }

    public int getFechaIF() {
        return fechaIF;
    }

    public void setFechaIF(int fechaIF) {
        this.fechaIF = fechaIF;
    }

    public int getFechaFF() {
        return fechaFF;
    }

    public void setFechaFF(int fechaFF) {
        this.fechaFF = fechaFF;
    }

    public String getDescripcionF() {
        return descripcionF;
    }

    public void setDescripcionF(String descripcionF) {
        this.descripcionF = descripcionF;
    }

    public String getImgF() {
        return imgF;
    }

    public void setImgF(String imgF) {
        this.imgF = imgF;
    }

    
}
