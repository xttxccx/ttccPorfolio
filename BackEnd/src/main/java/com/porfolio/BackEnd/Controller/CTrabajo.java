
package com.porfolio.BackEnd.Controller;

import com.porfolio.BackEnd.Dto.dtoTrabajo;
import com.porfolio.BackEnd.Entity.Trabajo;
import com.porfolio.BackEnd.Security.Controller.Mensaje;
import com.porfolio.BackEnd.Service.STrabajo;
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
@RequestMapping("trabajo")
@CrossOrigin(origins = "https://ttcc-portfolio-front.web.app")
public class CTrabajo {
    @Autowired
    STrabajo sTrabajo;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Trabajo>> list(){
        List<Trabajo> list = sTrabajo.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Trabajo> getById(@PathVariable("id") int id){
        if(!sTrabajo.existsById(id))
            return new ResponseEntity(new Mensaje("Este trabajo no existe"), HttpStatus.NOT_FOUND);
        Trabajo trabajo = sTrabajo.getOne(id).get();
        return new ResponseEntity(trabajo, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoTrabajo dtotra){
        if(StringUtils.isBlank(dtotra.getNombreT()))
            return new ResponseEntity(new Mensaje("El título es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sTrabajo.existsByNombreT(dtotra.getNombreT()))
            return new ResponseEntity(new Mensaje("Este trabajo ya existe"), HttpStatus.BAD_REQUEST);
        
        Trabajo trabajo = new Trabajo(
                dtotra.getNombreT(), 
                dtotra.getFechaIT(),
                dtotra.getFechaFT(),
                dtotra.getDescripcionT(),
                dtotra.getImgT()               
        );
        
        sTrabajo.save(trabajo);        
        return new ResponseEntity(new Mensaje("Trabajo agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoTrabajo dtotra){
        if(!sTrabajo.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(sTrabajo.existsByNombreT(dtotra.getNombreT()) && sTrabajo.getByNombreT(dtotra.getNombreT()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("Ese trabajo ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtotra.getNombreT()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Trabajo trabajo = sTrabajo.getOne(id).get();
        trabajo.setNombreT(dtotra.getNombreT());
        trabajo.setFechaIT(dtotra.getFechaIT());
        trabajo.setFechaFT(dtotra.getFechaFT());
        trabajo.setDescripcionT(dtotra.getDescripcionT());
        trabajo.setImgT(dtotra.getImgT());
        
        sTrabajo.save(trabajo);
        return new ResponseEntity(new Mensaje("Trabajo actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!sTrabajo.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sTrabajo.delete(id);
        
        return new ResponseEntity(new Mensaje("Trabajo eliminado"), HttpStatus.OK);
        
    }
    
}
