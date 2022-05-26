
package com.porfolio.BackEnd.Controller;

import com.porfolio.BackEnd.Entity.Formacion;
import com.porfolio.BackEnd.Interface.IFormacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormacionController {
    
    @Autowired 
    private IFormacionService formSer;
       
    @PostMapping ("/new/formacion")
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
    }
    
}
