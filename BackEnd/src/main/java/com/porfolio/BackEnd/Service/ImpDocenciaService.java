package com.porfolio.BackEnd.Service;

import com.porfolio.BackEnd.Entity.Docencia;
import com.porfolio.BackEnd.Interface.IDocenciaService;
import com.porfolio.BackEnd.Repository.IDocenciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpDocenciaService implements IDocenciaService {
    @Autowired IDocenciaRepository idocenciaRepository;

    @Override
    public List<Docencia> getDocencia() {
        List<Docencia> docencia = idocenciaRepository.findAll();
        return docencia;
    }

    @Override
    public void saveDocencia(Docencia docencia) {
        idocenciaRepository.save(docencia);
    }

    @Override
    public void deleteDocencia(Long id) {
        idocenciaRepository.deleteById(id);
    }

    @Override
    public Docencia findDocencia(Long id) {
        Docencia docencia = idocenciaRepository.findById(id).orElse(null);
        return docencia;
    }
    
    
}
