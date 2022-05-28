
package com.porfolio.BackEnd.Controller;
import com.porfolio.BackEnd.Entity.Trabajo;
import com.porfolio.BackEnd.Interface.ITrabajoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trabajo")
public class TrabajoController {
    
    @Autowired 
    private ITrabajoService traSer;
       
    @PostMapping ("/nuevo")
    public String nuevoTrabajo (@RequestBody Trabajo tra) {
        traSer.nuevoTrabajo(tra);
        return "Nuevo trabajo agregado exitosamente";
    }
    
    @GetMapping ("/lista")
    @ResponseBody
    public List<Trabajo> verTrabajos () {
        return traSer.verTrabajos();    
    }
    
    @GetMapping("/ver/{id}")
    public ResponseEntity<Trabajo> buscarTrabajo(@PathVariable("id") Long id){
        Trabajo trabajo=traSer.buscarTrabajo(id);
        return new ResponseEntity<>(trabajo, HttpStatus.OK);
    }
    
    @PutMapping("/editar")
    public ResponseEntity<Trabajo> editarTrabajo(@RequestBody Trabajo tra){
       Trabajo trabajo=traSer.editarTrabajo(tra);
       return new ResponseEntity<>(trabajo, HttpStatus.OK);
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String borrarTrabajo (@PathVariable("id") Long id){
        traSer.borrarTrabajo(id);
        return "Trabajo eliminado exitosamente.";
    }
    
    
 
    
}
