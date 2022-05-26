package com.porfolio.BackEnd.Controller;

import com.porfolio.BackEnd.Entity.Docencia;
import com.porfolio.BackEnd.Interface.IDocenciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DocenciaController {
    @Autowired IDocenciaService idocenciaService;
    
    @GetMapping("/docencia/traer")
    public List<Docencia> getDocencia() {
        return idocenciaService.getDocencia();
    }
    
    @GetMapping("/docencia/traer/{id}")
    public Docencia findDocencia(@PathVariable Long id){
        return idocenciaService.findDocencia(id);
    }
    
    @PostMapping("/docencia/crear")
    public String createDocencia(@RequestBody Docencia docencia){
        idocenciaService.saveDocencia(docencia);
        return "Experiencia docente cargada con éxito.";
    }
    
    @DeleteMapping("/docencia/borrar/{id}")
    public String deleteDocencia(@PathVariable Long id){
        idocenciaService.deleteDocencia(id);
        return "Experiencia docente eliminada con éxito.";
    }
    
    @PutMapping("/docencia/editar/{id}")
    public Docencia editDocencia(@PathVariable Long id,
                              @RequestParam("anio") String nuevoAnio,
                              @RequestParam("empleo") String nuevoEmpleo,
                              @RequestParam("descripcion") String nuevaDescripcion,
                              @RequestParam("img") String nuevaImg) {
        
        Docencia docencia = idocenciaService.findDocencia(id);
        
        docencia.setAnio(nuevoAnio);
        docencia.setEmpleo(nuevoEmpleo);
        docencia.setDescripcion(nuevaDescripcion);
        docencia.setImg(nuevaImg);
                
        idocenciaService.saveDocencia(docencia);
        return docencia;
    }
    
}
