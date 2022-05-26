
package com.porfolio.BackEnd.Interface;

import com.porfolio.BackEnd.Entity.Proyectos;
import java.util.List;

public interface IProyectosService {
    
    public List<Proyectos> verProyectos ();
    public void nuevoProyecto (Proyectos proy);
    public void borrarProyecto (Long id);
    public Proyectos buscarProyecto (Long id);
    public Proyectos editarProyecto (Proyectos proy);
}
