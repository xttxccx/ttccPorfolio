
package com.porfolio.BackEnd.Service;

import com.porfolio.BackEnd.Entity.Proyectos;
import com.porfolio.BackEnd.Interface.IProyectosService;
import com.porfolio.BackEnd.Repository.IProyectosRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpProyectosService implements IProyectosService {
    
    @Autowired IProyectosRepository iproyectosRepository;

    @Override
    public List<Proyectos> verProyectos() {
        List<Proyectos> proyectos = iproyectosRepository.findAll();
        return proyectos;
    }

    @Override
    public void nuevoProyecto(Proyectos proy) {
        iproyectosRepository.save(proy);
    }

    @Override
    public void borrarProyecto(Long id) {
        iproyectosRepository.deleteById(id);
    }

    @Override
    public Proyectos buscarProyecto(Long id) {
        Proyectos proyecto = iproyectosRepository.findById(id).orElse(null);
        return proyecto;
    }

    @Override
    public Proyectos editarProyecto(Proyectos proy) {
        return iproyectosRepository.save(proy);
    }
    
}
