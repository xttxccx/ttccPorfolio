
package com.porfolio.BackEnd.Service;

import com.porfolio.BackEnd.Entity.Formacion;
import com.porfolio.BackEnd.Repository.RFormacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SFormacion {
    @Autowired
    RFormacion rFormacion;
    
    public List<Formacion> list() {
        return rFormacion.findAll();
    }
    
    public Optional<Formacion> getOne(int id){
        return rFormacion.findById(id);
    }
    
    public Optional<Formacion> getByNombreF(String nombreF) {
        return rFormacion.findByNombreF(nombreF);
    }
    
    public void save(Formacion forma) {
        rFormacion.save(forma);
    }
    
    public void delete(int id){
        rFormacion.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rFormacion.existsById(id);
    }
    
    public boolean existsByNombreF(String nombreF){
        return rFormacion.existsByNombreF(nombreF);
    }
    
    
}
