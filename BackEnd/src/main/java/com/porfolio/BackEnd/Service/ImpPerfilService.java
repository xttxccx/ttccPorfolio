package com.porfolio.BackEnd.Service;

import com.porfolio.BackEnd.Entity.Perfil;
import com.porfolio.BackEnd.Interface.IPerfilService;
import com.porfolio.BackEnd.Repository.IPerfilRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpPerfilService implements IPerfilService {
    @Autowired IPerfilRepository iperfilRepository;
    
    @Override
    public List<Perfil> verPerfiles() {
        List<Perfil> perfil = iperfilRepository.findAll();
        return perfil;
    }

    @Override
    public Perfil nuevoPerfil(Perfil perfil) {
        return iperfilRepository.save(perfil);
    }

    @Override
    public void borrarPerfil(Long id) {
        iperfilRepository.deleteById(id);
    }

    @Override
    public Perfil buscarPerfil(Long id) {
        Perfil perfil = iperfilRepository.findById(id).orElse(null);
        return perfil;
    }

    @Override
    public Perfil editarPerfil(Perfil perfil) {
        return iperfilRepository.save(perfil);
    }
    

   /* @Override
    public List<Perfil> getPerfil() {
        List<Perfil> perfil = iperfilRepository.findAll();
        return perfil;
    }

    @Override
    public void savePerfil(Perfil perfil) {
        iperfilRepository.save(perfil);
    }

    @Override
    public void deletePerfil(Long id) {
        iperfilRepository.deleteById(id);
    }

    @Override
    public Perfil findPerfil(Long id) {
        Perfil perfil = iperfilRepository.findById(id).orElse(null);
        return perfil;
    }*/

   
    
}
