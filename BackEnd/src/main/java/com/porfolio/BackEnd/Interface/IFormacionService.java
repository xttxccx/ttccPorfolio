
package com.porfolio.BackEnd.Interface;

import com.porfolio.BackEnd.Entity.Formacion;
import java.util.List;


public interface IFormacionService {
    
    public List<Formacion> verFormaciones ();
    public void nuevaFormacion (Formacion form);
    public void borrarFormacion (Long id);
    public Formacion buscarFormacion (Long id);
    public Formacion editarFormacion (Formacion form);
}
