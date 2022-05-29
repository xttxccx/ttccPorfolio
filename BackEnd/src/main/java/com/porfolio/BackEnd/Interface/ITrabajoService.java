package com.porfolio.BackEnd.Interface;

import com.porfolio.BackEnd.Entity.Trabajo;
import java.util.List;

public interface ITrabajoService {  
        
    public List<Trabajo> verTrabajos ();
    public void nuevoTrabajo (Trabajo tra);
    public void borrarTrabajo (Long id);
    public Trabajo buscarTrabajo (Long id);
    public Trabajo editarTrabajo (Trabajo tra);
    
}
