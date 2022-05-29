package com.porfolio.BackEnd.Service;

import com.porfolio.BackEnd.Entity.Docencia;
import com.porfolio.BackEnd.Interface.IDocenciaService;
import com.porfolio.BackEnd.Repository.IDocenciaRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpDocenciaService implements IDocenciaService {
    @Autowired IDocenciaRepository idocenciaRepository;
    
    @Override
    public List<Docencia> verDocencia() {
        List<Docencia> docencia = idocenciaRepository.findAll();
        return docencia;
    }

    @Override
    public void nuevaDocencia(Docencia doc) {
        idocenciaRepository.save(doc);
    }

    @Override
    public void borrarDocencia(Long id) {
        idocenciaRepository.deleteById(id);        
    }

    @Override
    public Docencia buscarDocencia(Long id) {
        Docencia docencia = idocenciaRepository.findById(id).orElse(null);
        return docencia;
    }

    @Override
    public Docencia editarDocencia(Docencia doc) {
        return idocenciaRepository.save(doc);
    }

    
}
