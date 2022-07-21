
package com.porfolio.BackEnd.Service;

import com.porfolio.BackEnd.Entity.Docencia;
import com.porfolio.BackEnd.Repository.RDocencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SDocencia {
    @Autowired
    RDocencia rDocencia;
    
    public List<Docencia> list() {
        return rDocencia.findAll();
    }
    
    public Optional<Docencia> getOne(int id){
        return rDocencia.findById(id);
    }
    
    public Optional<Docencia> getByNombreD(String nombreD) {
        return rDocencia.findByNombreD(nombreD);
    }
    
    public void save(Docencia doc) {
        rDocencia.save(doc);
    }
    
    public void delete(int id){
        rDocencia.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rDocencia.existsById(id);
    }
    
    public boolean existsByNombreD(String nombreD){
        return rDocencia.existsByNombreD(nombreD);
    }
    
}
