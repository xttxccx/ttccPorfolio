package com.porfolio.BackEnd.Interface;

import com.porfolio.BackEnd.Entity.Perfil;
import java.util.List;


public interface IPerfilService {
    
    public List<Perfil> verPerfiles ();
    public Perfil nuevoPerfil (Perfil perfil);
    public void borrarPerfil (Long id);
    public Perfil buscarPerfil (Long id);
    public Perfil editarPerfil (Perfil perfil);
    
    /*public List<Perfil> getPerfil();    
    public void savePerfil(Perfil perfil);    
    public void deletePerfil(Long id);    
    public Perfil findPerfil(Long id);*/
    
}
