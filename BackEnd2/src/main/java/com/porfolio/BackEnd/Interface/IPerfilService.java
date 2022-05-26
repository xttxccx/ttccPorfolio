package com.porfolio.BackEnd.Interface;

import com.porfolio.BackEnd.Entity.Perfil;
import java.util.List;


public interface IPerfilService {
    
    //Traer lista de perfiles
    public List<Perfil> getPerfil();
    
    //Guardar obj perfil
    public void savePerfil(Perfil perfil);
    
    //Eliminar obj perfil x ID
    public void deletePerfil(Long id);
    
    //Buscar obj perfil x ID
    public Perfil findPerfil(Long id);
    
}
