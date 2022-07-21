
package com.porfolio.BackEnd.Service;

import com.porfolio.BackEnd.Entity.Trabajo;
import com.porfolio.BackEnd.Repository.RTrabajo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class STrabajo {
    @Autowired
    RTrabajo rTrabajo;
    
    public List<Trabajo> list() {
        return rTrabajo.findAll();
    }
    
    public Optional<Trabajo> getOne(int id){
        return rTrabajo.findById(id);
    }
    
    public Optional<Trabajo> getByNombreT(String nombreT) {
        return rTrabajo.findByNombreT(nombreT);
    }
    
    public void save(Trabajo tra) {
        rTrabajo.save(tra);
    }
    
    public void delete(int id){
        rTrabajo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rTrabajo.existsById(id);
    }
    
    public boolean existsByNombreT(String nombreT){
        return rTrabajo.existsByNombreT(nombreT);
    }
    
}
