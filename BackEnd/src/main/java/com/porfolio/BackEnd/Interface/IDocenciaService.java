package com.porfolio.BackEnd.Interface;


import com.porfolio.BackEnd.Entity.Docencia;
import java.util.List;

public interface IDocenciaService {
    
    public List<Docencia> verDocencia ();
    public void nuevaDocencia (Docencia doc);
    public void borrarDocencia (Long id);
    public Docencia buscarDocencia (Long id);
    public Docencia editarDocencia (Docencia doc);
    
}
    
    /*public List<Docencia> getDocencia();
    public void saveDocencia(Docencia docencia);    
    public void deleteDocencia(Long id);    
    public Docencia findDocencia(Long id);*/
    

