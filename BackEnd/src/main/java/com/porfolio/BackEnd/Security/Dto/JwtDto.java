
package com.porfolio.BackEnd.Security.Dto;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

public class JwtDto {
    private String token;
    private String bearer = "Bearer";
    private String nombreUsuarix;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDto(String token, String nombreUsuarix, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.nombreUsuarix = nombreUsuarix;
        this.authorities = authorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getNombreUsuarix() {
        return nombreUsuarix;
    }

    public void setNombreUsuarix(String nombreUsuarix) {
        this.nombreUsuarix = nombreUsuarix;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
    
    
}
