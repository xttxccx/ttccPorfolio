
package com.porfolio.BackEnd.Controller;

import com.porfolio.BackEnd.Dto.dtoFormacion;
import com.porfolio.BackEnd.Entity.Formacion;
import com.porfolio.BackEnd.Security.Controller.Mensaje;
import com.porfolio.BackEnd.Service.SFormacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("formacion")
@CrossOrigin(origins = "http://localhost:4200")
public class CFormacion {
    @Autowired
    SFormacion sFormacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Formacion>> list(){
        List<Formacion> list = sFormacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Formacion> getById(@PathVariable("id") int id){
        if(!sFormacion.existsById(id))
            return new ResponseEntity(new Mensaje("Esta formación no existe"), HttpStatus.NOT_FOUND);
        Formacion formacion = sFormacion.getOne(id).get();
        return new ResponseEntity(formacion, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoFormacion dtoforma){
        if(StringUtils.isBlank(dtoforma.getNombreF()))
            return new ResponseEntity(new Mensaje("El título es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sFormacion.existsByNombreF(dtoforma.getNombreF()))
            return new ResponseEntity(new Mensaje("Esta formación ya existe"), HttpStatus.BAD_REQUEST);
        
        Formacion formacion = new Formacion(
                dtoforma.getNombreF(), 
                dtoforma.getFechaIF(),
                dtoforma.getFechaFF(),
                dtoforma.getDescripcionF(),
                dtoforma.getImgF()               
        );
        
        sFormacion.save(formacion);        
        return new ResponseEntity(new Mensaje("Formación agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoFormacion dtoforma){
        if(!sFormacion.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(sFormacion.existsByNombreF(dtoforma.getNombreF()) && sFormacion.getByNombreF(dtoforma.getNombreF()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("Esa formación ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoforma.getNombreF()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Formacion formacion = sFormacion.getOne(id).get();
        formacion.setNombreF(dtoforma.getNombreF());
        formacion.setFechaIF(dtoforma.getFechaIF());
        formacion.setFechaFF(dtoforma.getFechaFF());
        formacion.setDescripcionF(dtoforma.getDescripcionF());
        formacion.setImgF(dtoforma.getImgF());
        
        sFormacion.save(formacion);
        return new ResponseEntity(new Mensaje("Formación actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!sFormacion.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sFormacion.delete(id);
        
        return new ResponseEntity(new Mensaje("Formación eliminada"), HttpStatus.OK);
        
    }
    
    
}
