package com.porfolio.BackEnd.Controller;

import com.porfolio.BackEnd.Entity.Docencia;
import com.porfolio.BackEnd.Interface.IDocenciaService;
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
@RequestMapping("/docencia")
public class DocenciaController {
    
    @Autowired IDocenciaService docSer;
    
    @PostMapping ("/nueva")
    public String nuevaDocencia (@RequestBody Docencia doc) {
        docSer.nuevaDocencia(doc);
        return "Nueva docencia agregada exitosamente";
    }
    
    @GetMapping ("/lista")
    @ResponseBody
    public List<Docencia> verDocencia () {
        return docSer.verDocencia();    
    }
    
    @GetMapping("/ver/{id}")
    public ResponseEntity<Docencia> buscarDocencia(@PathVariable("id") Long id){
        Docencia docencia=docSer.buscarDocencia(id) ;
        return new ResponseEntity<>(docencia, HttpStatus.OK);
    }
    
    @PutMapping("/editar")
    public ResponseEntity<Docencia> editarDocencia(@RequestBody Docencia doc){
       Docencia docencia=docSer.editarDocencia(doc) ;
       return new ResponseEntity<>(docencia, HttpStatus.OK);
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String borrarDocencia (@PathVariable("id") Long id){
        docSer.borrarDocencia(id);
        return "Docencia eliminada exitosamente.";
    }
    
    /*
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
    }*/
    
}
