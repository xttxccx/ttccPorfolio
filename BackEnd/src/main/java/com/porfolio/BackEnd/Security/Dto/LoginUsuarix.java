
package com.porfolio.BackEnd.Security.Dto;

import javax.validation.constraints.NotBlank;

public class LoginUsuarix {
    
    @NotBlank
    private String nombreUsuarix;
    
    @NotBlank
    private String password;

    public String getNombreUsuarix() {
        return nombreUsuarix;
    }

    public void setNombreUsuarix(String nombreUsuarix) {
        this.nombreUsuarix = nombreUsuarix;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
