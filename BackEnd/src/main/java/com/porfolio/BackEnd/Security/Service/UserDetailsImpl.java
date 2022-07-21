
package com.porfolio.BackEnd.Security.Service;

import com.porfolio.BackEnd.Security.Entity.Usuarix;
import com.porfolio.BackEnd.Security.Entity.UsuarixPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service 
public class UserDetailsImpl implements UserDetailsService{
    @Autowired
    UsuarixService usuarixService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuarix) throws UsernameNotFoundException {
        Usuarix usuarix = usuarixService.getByNombreUsuarix(nombreUsuarix).get();
        return UsuarixPrincipal.build(usuarix);
    }    
}
