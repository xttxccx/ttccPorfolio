
package com.porfolio.BackEnd.Dto;

import javax.validation.constraints.NotBlank;


public class dtoDocencia {
   
    @NotBlank
    private String nombreD;
    private int fechaID;
    private int fechaFD;
    @NotBlank
    private String descripcionD;
    private String imgD;

    public dtoDocencia() {
    }

    public dtoDocencia(String nombreD, int fechaID, int fechaFD, String descripcionD, String imgD) {
        this.nombreD = nombreD;
        this.fechaID = fechaID;
        this.fechaFD = fechaFD;
        this.descripcionD = descripcionD;
        this.imgD = imgD;
    }

    public String getNombreD() {
        return nombreD;
    }

    public void setNombreD(String nombreD) {
        this.nombreD = nombreD;
    }

    public int getFechaID() {
        return fechaID;
    }

    public void setFechaID(int fechaID) {
        this.fechaID = fechaID;
    }

    public int getFechaFD() {
        return fechaFD;
    }

    public void setFechaFD(int fechaFD) {
        this.fechaFD = fechaFD;
    }

    public String getDescripcionD() {
        return descripcionD;
    }

    public void setDescripcionD(String descripcionD) {
        this.descripcionD = descripcionD;
    }

    public String getImgD() {
        return imgD;
    }

    public void setImgD(String imgD) {
        this.imgD = imgD;
    }
    
    
    
}
