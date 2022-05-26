
package com.porfolio.BackEnd.Service;

import com.porfolio.BackEnd.Entity.Formacion;
import com.porfolio.BackEnd.Interface.IFormacionService;
import com.porfolio.BackEnd.Repository.IFormacionRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpFormacionService implements IFormacionService {
    
    @Autowired
    public IFormacionRepository formRep;

    @Override
    public List<Formacion> verFormaciones() {
        return formRep.findAll();
    }

    @Override
    public void nuevaFormacion(Formacion form) {
        formRep.save(form);
    }

    @Override
    public void borrarFormacion(Long id) {
        formRep.deleteById(id);
    }
    
    @Override
    public Formacion editarFormacion(Formacion form){
        return formRep.save(form);
    }

    @Override
    public Formacion buscarFormacion(Long id) {
        return formRep.findById(id).orElse(null);
    }
    
}
