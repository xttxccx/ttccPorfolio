package com.porfolio.BackEnd.Security.Entity;

import java.util.List;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarixPrincipal implements UserDetails {

    private String nombre;
    private String nombreUsuarix;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UsuarixPrincipal(String nombre, String nombreUsuarix, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.nombreUsuarix = nombreUsuarix;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UsuarixPrincipal build(Usuarix usuarix) {
        List<GrantedAuthority> authorities = usuarix.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name()))
                .collect(Collectors.toList());
        return new UsuarixPrincipal(usuarix.getNombre(), usuarix.getNombreUsuarix(),
                 usuarix.getEmail(), usuarix.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return nombreUsuarix;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
