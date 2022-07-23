
package com.porfolio.BackEnd.Controller;

import com.porfolio.BackEnd.Dto.dtoDocencia;
import com.porfolio.BackEnd.Entity.Docencia;
import com.porfolio.BackEnd.Security.Controller.Mensaje;
import com.porfolio.BackEnd.Service.SDocencia;
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
@RequestMapping("docencia")
@CrossOrigin(origins = "https://ttcc-portfolio-front.web.app")
public class CDocencia {
    @Autowired
    SDocencia sDocencia;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Docencia>> list(){
        List<Docencia> list = sDocencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Docencia> getById(@PathVariable("id") int id){
        if(!sDocencia.existsById(id))
            return new ResponseEntity(new Mensaje("Este trabajo docente no existe"), HttpStatus.NOT_FOUND);
        Docencia docencia = sDocencia.getOne(id).get();
        return new ResponseEntity(docencia, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoDocencia dtodoc){
        if(StringUtils.isBlank(dtodoc.getNombreD()))
            return new ResponseEntity(new Mensaje("El título es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sDocencia.existsByNombreD(dtodoc.getNombreD()))
            return new ResponseEntity(new Mensaje("Este trabajo docente ya existe"), HttpStatus.BAD_REQUEST);
        
        Docencia docencia = new Docencia(
                dtodoc.getNombreD(), 
                dtodoc.getFechaID(),
                dtodoc.getFechaFD(),
                dtodoc.getDescripcionD(),
                dtodoc.getImgD()               
        );
        
        sDocencia.save(docencia);        
        return new ResponseEntity(new Mensaje("Trabajo docente agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoDocencia dtodoc){
        if(!sDocencia.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(sDocencia.existsByNombreD(dtodoc.getNombreD()) && sDocencia.getByNombreD(dtodoc.getNombreD()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("Ese trabajo docente ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtodoc.getNombreD()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Docencia docencia = sDocencia.getOne(id).get();
        docencia.setNombreD(dtodoc.getNombreD());
        docencia.setFechaID(dtodoc.getFechaID());
        docencia.setFechaFD(dtodoc.getFechaFD());
        docencia.setDescripcionD(dtodoc.getDescripcionD());
        docencia.setImgD(dtodoc.getImgD());
        
        sDocencia.save(docencia);
        return new ResponseEntity(new Mensaje("Trabajo docente actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!sDocencia.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sDocencia.delete(id);
        
        return new ResponseEntity(new Mensaje("Trabajo docente eliminado"), HttpStatus.OK);
        
    }
    
}
