package com.porfolio.BackEnd.Security.Controller;

import com.porfolio.BackEnd.Security.Dto.JwtDto;
import com.porfolio.BackEnd.Security.Dto.LoginUsuarix;
import com.porfolio.BackEnd.Security.Dto.NuevxUsuarix;
import com.porfolio.BackEnd.Security.Entity.Rol;
import com.porfolio.BackEnd.Security.Entity.Usuarix;
import com.porfolio.BackEnd.Security.Enums.RolNombre;
import com.porfolio.BackEnd.Security.Service.RolService;
import com.porfolio.BackEnd.Security.Service.UsuarixService;
import com.porfolio.BackEnd.Security.jwt.JwtProvider;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarixService usuarixService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevx")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevxUsuarix nuevxUsuarix, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Mensaje("Campos equivocados o email inválido"), HttpStatus.BAD_REQUEST);
        }

        if (usuarixService.existsByNombreUsuarix(nuevxUsuarix.getNombreUsuarix())) {
            return new ResponseEntity(new Mensaje("Ese nombre de usuarix no está disponible"), HttpStatus.BAD_REQUEST);
        }

        if (usuarixService.existsByEmail(nuevxUsuarix.getEmail())) {
            return new ResponseEntity(new Mensaje("Este email ya está registrado"), HttpStatus.BAD_REQUEST);
        }

        Usuarix usuarix = new Usuarix(nuevxUsuarix.getNombre(), nuevxUsuarix.getNombreUsuarix(), nuevxUsuarix.getEmail(), passwordEncoder.encode(nuevxUsuarix.getPassword()));

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());

        if (nuevxUsuarix.getRoles().contains("admin")) {
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        }
        usuarix.setRoles(roles);
        usuarixService.save(usuarix);

        return new ResponseEntity(new Mensaje("Usuarix guardadx"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuarix loginUsuarix, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Mensaje("Campos incorrrectos"), HttpStatus.BAD_REQUEST);
        }

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginUsuarix.getNombreUsuarix(), loginUsuarix.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.genetareToken(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }

}
