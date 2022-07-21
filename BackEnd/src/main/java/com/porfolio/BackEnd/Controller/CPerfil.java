
package com.porfolio.BackEnd.Controller;

import com.porfolio.BackEnd.Dto.dtoPerfil;
import com.porfolio.BackEnd.Entity.Perfil;
import com.porfolio.BackEnd.Security.Controller.Mensaje;
import com.porfolio.BackEnd.Service.SPerfil;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("perfil")
@CrossOrigin(origins = "http://localhost:4200")
public class CPerfil {
    @Autowired
    SPerfil sPerfil;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Perfil>> list(){
        List<Perfil> list = sPerfil.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Perfil> getById(@PathVariable("id") int id){
        if(!sPerfil.existsById(id))
            return new ResponseEntity(new Mensaje("Este perfil no existe"), HttpStatus.NOT_FOUND);
        Perfil perfil = sPerfil.getOne(id).get();
        return new ResponseEntity(perfil, HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPerfil dtoper){
        if(!sPerfil.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(sPerfil.existsByNombre(dtoper.getNombre()) && sPerfil.getByNombre(dtoper.getNombre()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("Ese perfil ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoper.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Perfil perfil = sPerfil.getOne(id).get();
        perfil.setNombre(dtoper.getNombre());
        perfil.setApodo(dtoper.getApodo());        
        perfil.setImgPerfil(dtoper.getImgPerfil());
        perfil.setBanner(dtoper.getBanner());
        perfil.setTitulo(dtoper.getTitulo());
        perfil.setDescripcion(dtoper.getDescripcion());
        
        sPerfil.save(perfil);
        return new ResponseEntity(new Mensaje("Perfil actualizado"), HttpStatus.OK);
    }
    
}
