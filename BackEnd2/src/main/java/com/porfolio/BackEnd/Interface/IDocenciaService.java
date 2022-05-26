package com.porfolio.BackEnd.Interface;


import com.porfolio.BackEnd.Entity.Docencia;
import java.util.List;

public interface IDocenciaService {
    //Traer lista de trabajos docentes
    public List<Docencia> getDocencia();
    
    //Guardar obj docencia
    public void saveDocencia(Docencia docencia);
    
    //Eliminar obj docencia x ID
    public void deleteDocencia(Long id);
    
    //Buscar obj docencia x ID
    public Docencia findDocencia(Long id);
    
}
