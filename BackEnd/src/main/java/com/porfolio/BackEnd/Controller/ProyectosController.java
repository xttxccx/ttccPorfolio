
package com.porfolio.BackEnd.Controller;


import com.porfolio.BackEnd.Entity.Proyectos;
import com.porfolio.BackEnd.Interface.IProyectosService;
import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/proyecto")
public class ProyectosController {
    
    @Autowired IProyectosService proySer;
    
    @PostMapping ("/nuevo")
    public String nuevoProyecto (@RequestBody Proyectos proy) {
        proySer.nuevoProyecto(proy); 
        return "Nuevo proyecto agregado exitosamente";
    }
    
    @GetMapping ("/lista")
    @ResponseBody
    public List<Proyectos> verProyectos () {
        return proySer.verProyectos() ;    
    }
    
    @GetMapping("/ver/{id}")
    public ResponseEntity<Proyectos> buscarProyecto(@PathVariable("id") Long id){
        Proyectos proyecto=proySer.buscarProyecto(id) ;
        return new ResponseEntity<>(proyecto, HttpStatus.OK);
    }
    
    @PutMapping("/editar")
    public ResponseEntity<Proyectos> editarProyecto(@RequestBody Proyectos proy){
       Proyectos proyecto=proySer.editarProyecto(proy) ;
       return new ResponseEntity<>(proyecto, HttpStatus.OK);
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String borrarProyecto (@PathVariable("id") Long id){
        proySer.borrarProyecto(id);
        return "Proyecto eliminado exitosamente.";
    }
    
}
