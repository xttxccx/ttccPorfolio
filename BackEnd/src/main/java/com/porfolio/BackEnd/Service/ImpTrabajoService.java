package com.porfolio.BackEnd.Service;

import com.porfolio.BackEnd.Entity.Trabajo;
import com.porfolio.BackEnd.Interface.ITrabajoService;
import com.porfolio.BackEnd.Repository.ITrabajoRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpTrabajoService implements ITrabajoService {
    
    @Autowired
    public ITrabajoRepository itrabajoRepository;
    
    @Override
    public List<Trabajo> verTrabajos() {
        List<Trabajo> trabajos = itrabajoRepository.findAll();
        return trabajos;
    }

    @Override
    public void nuevoTrabajo(Trabajo tra) {
        itrabajoRepository.save(tra);
    }

    @Override
    public void borrarTrabajo(Long id) {
        itrabajoRepository.deleteById(id);
    }

    @Override
    public Trabajo buscarTrabajo(Long id) {
        Trabajo trabajo = itrabajoRepository.findById(id).orElse(null);
        return trabajo;
    }

    @Override
    public Trabajo editarTrabajo(Trabajo tra) {
        return itrabajoRepository.save(tra);
    }
    

    /*@Override
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
    }*/

    

}
