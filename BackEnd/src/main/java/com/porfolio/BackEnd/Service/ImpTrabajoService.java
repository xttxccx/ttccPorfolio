package com.porfolio.BackEnd.Service;

import com.porfolio.BackEnd.Entity.Trabajo;
import com.porfolio.BackEnd.Interface.ITrabajoService;
import com.porfolio.BackEnd.Repository.ITrabajoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpTrabajoService implements ITrabajoService {
    
    @Autowired
    public ITrabajoRepository traRep;

    @Override
    public List<Trabajo> verTrabajos() {
        return traRep.findAll();
    }

    @Override
    public void nuevoTrabajo(Trabajo tra) {
        traRep.save(tra);
    }

    @Override
    public void borrarTrabajo(Long id) {
        traRep.deleteById(id);
    }

    @Override
    public Trabajo buscarTrabajo(Long id) {
        return traRep.findById(id).orElse(null);        
    }
    

}
