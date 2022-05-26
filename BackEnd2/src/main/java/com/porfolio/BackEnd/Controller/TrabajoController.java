
package com.porfolio.BackEnd.Controller;
import com.porfolio.BackEnd.Entity.Trabajo;
import com.porfolio.BackEnd.Interface.ITrabajoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrabajoController {
    
    @Autowired 
    private ITrabajoService traSer;
       
    @PostMapping ("/new/trabajo")
    public String nuevoTrabajo (@RequestBody Trabajo tra) {
        traSer.nuevoTrabajo(tra);
        return "Nuevo trabajo agregado exitosamente";
    }
    
    @GetMapping ("/ver/trabajos")
    @ResponseBody
    public List<Trabajo> verTrabajos () {
        return traSer.verTrabajos();    
    }
    
    @DeleteMapping ("/delete/{id}")
    public void borrarTrabajo (Long id){
        traSer.borrarTrabajo(id);
    }
    
    
 
    
}
