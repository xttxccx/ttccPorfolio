package com.porfolio.BackEnd.Controller;

import com.porfolio.BackEnd.Entity.Perfil;
import com.porfolio.BackEnd.Interface.IPerfilService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerfilController {
    @Autowired IPerfilService iperfilService;
    
    @GetMapping("perfil/traer")
    public List<Perfil> getPerfil() {
        return iperfilService.getPerfil();
    }
    
    @PostMapping("perfil/crear")
    public String createPerfil(@RequestBody Perfil perfil){
        iperfilService.savePerfil(perfil);
        return "Perfil creado correctamente";
    }
    
    @DeleteMapping("perfil/borrar/{id}")
    public String deletePerfil(@PathVariable Long id){
        iperfilService.deletePerfil(id);
        return "Perfil borrado correctamente";
    }
    
    @PutMapping("perfil/editar/{id}")
    public Perfil editPersona(@PathVariable Long id,
                              @RequestParam("nombre") String nuevoNombre,
                              @RequestParam("apodo") String nuevoApodo,
                              @RequestParam("img") String nuevaImg) {
        
        Perfil perfil = iperfilService.findPerfil(id);
        
        perfil.setNombre(nuevoNombre);
        perfil.setApodo(nuevoApodo);
        perfil.setImg(nuevaImg);
        
        iperfilService.savePerfil(perfil);
        return perfil;
    }
}
