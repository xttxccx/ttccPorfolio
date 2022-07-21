
package com.porfolio.BackEnd.Service;

import com.porfolio.BackEnd.Entity.Perfil;
import com.porfolio.BackEnd.Repository.RPerfil;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SPerfil {
    @Autowired
    RPerfil rPerfil;
    
    public List<Perfil> list() {
        return rPerfil.findAll();
    }
    
    public Optional<Perfil> getOne(int id){
        return rPerfil.findById(id);
    }
    
    public Optional<Perfil> getByNombre(String nombre) {
        return rPerfil.findByNombre(nombre);
    }
    
    public void save(Perfil per) {
        rPerfil.save(per);
    }
    
    public boolean existsById(int id){
        return rPerfil.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rPerfil.existsByNombre(nombre);
    } 
    
}
