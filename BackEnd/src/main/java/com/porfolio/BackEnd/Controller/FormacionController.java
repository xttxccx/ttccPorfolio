
package com.porfolio.BackEnd.Controller;

import com.porfolio.BackEnd.Entity.Formacion;
import com.porfolio.BackEnd.Interface.IFormacionService;
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
@RequestMapping("/formacion")
public class FormacionController {
    
    @Autowired IFormacionService formSer;
    
    @PostMapping ("/nueva")
    public String nuevaFormacion (@RequestBody Formacion form) {
        formSer.nuevaFormacion(form);
        return "Nueva formación agregada exitosamente";
    }
    
    @GetMapping ("/lista")
    @ResponseBody
    public List<Formacion> verFormaciones () {
        return formSer.verFormaciones();    
    }
    
    @GetMapping("/ver/{id}")
    public ResponseEntity<Formacion> buscarFormacion(@PathVariable("id") Long id){
        Formacion formacion=formSer.buscarFormacion(id) ;
        return new ResponseEntity<>(formacion, HttpStatus.OK);
    }
    
    @PutMapping("/editar")
    public ResponseEntity<Formacion> editarFormacion(@RequestBody Formacion form){
       Formacion formacion=formSer.editarFormacion(form);
       return new ResponseEntity<>(formacion, HttpStatus.OK);
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String borrarFormacion (@PathVariable("id") Long id){
        formSer.borrarFormacion(id);
        return "Formación eliminada exitosamente.";
    }
       
    /*@PostMapping ("/new/formacion")
    public String nuevaFormacion (@RequestBody Formacion form) {
        formSer.nuevaFormacion(form);
        return "Nueva formación agregada exitosamente";
    }
    
    @GetMapping ("/ver/formaciones")
    @ResponseBody
    public List<Formacion> verFormaciones () {
        return formSer.verFormaciones();    
    }
    
    @DeleteMapping ("/delete/form{id}")
    public String borrarFormacion (Long id){
        formSer.borrarFormacion(id);
        return "Formación eliminada exitosamente.";
    }*/
    
}
