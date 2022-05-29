package com.porfolio.BackEnd.Controller;

import com.porfolio.BackEnd.Entity.Perfil;
import com.porfolio.BackEnd.Interface.IPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/perfil")
public class PerfilController {
    @Autowired IPerfilService iperfilService;
    
    @GetMapping("/traer/{id}")
    public ResponseEntity<Perfil> buscarPerfil(@PathVariable("id") Long id){
        Perfil perfil=iperfilService.buscarPerfil(id);
        return new ResponseEntity<>(perfil, HttpStatus.OK);
    }
    
    @PutMapping("/editar")
    public ResponseEntity<Perfil> editarPerfil(@RequestBody Perfil perfil){
        Perfil editarPerfil=iperfilService.editarPerfil(perfil);
        return new ResponseEntity<>(editarPerfil, HttpStatus.OK);
    }
    
    @PostMapping("/nuevo")
    public ResponseEntity<Perfil> nuevoPerfil(@RequestBody Perfil perfil){
         Perfil nuevoPerfil=iperfilService.nuevoPerfil(perfil);
         return new ResponseEntity<>(nuevoPerfil, HttpStatus.OK);
                 }
    
    @DeleteMapping("/borrar/{id}")
    public String borrarPerfil(@PathVariable("id") Long id){
        iperfilService.borrarPerfil(id);
        return "El perfil fue eliminado con éxito";
        
    }
    
    
   /* @GetMapping("/perfil/traer")
    public List<Perfil> getPerfil() {
        return iperfilService.getPerfil();
    }
    
    @GetMapping("/perfil/traer/{id}")
    public Perfil findPerfil(@PathVariable Long id){
        return iperfilService.findPerfil(id);
    }
    
    @PostMapping("/perfil/crear")
    public String createPerfil(@RequestBody Perfil perfil){
        iperfilService.savePerfil(perfil);
        return "Perfil creado correctamente";
    }
    
    @DeleteMapping("/perfil/borrar/{id}")
    public String deletePerfil(@PathVariable Long id){
        iperfilService.deletePerfil(id);
        return "Perfil borrado correctamente";
    }
    
    @PutMapping("/perfil/editar/{id}")
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
    }*/
}
