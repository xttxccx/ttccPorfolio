
package com.porfolio.BackEnd.Controller;

import com.porfolio.BackEnd.Dto.dtoSkill;
import com.porfolio.BackEnd.Entity.Skill;
import com.porfolio.BackEnd.Security.Controller.Mensaje;
import com.porfolio.BackEnd.Service.SSkill;
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
@RequestMapping ("skill")
@CrossOrigin(origins = "https://ttcc-portfolio-front.web.app")
public class CSkill {
    @Autowired
    SSkill sSkill;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> list() {
        List<Skill> list= sSkill.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id){
        if(!sSkill.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Skill skill = sSkill.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkill dtos) {
        if(StringUtils.isBlank(dtos.getNombreS()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sSkill.existsByNombreS(dtos.getNombreS()))
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        
        Skill skill = new Skill(dtos.getNombreS(), dtos.getPorcentajeS());
        sSkill.save(skill);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkill dtos){
        if(!sSkill.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(sSkill.existsByNombreS(dtos.getNombreS()) && sSkill.getByNombreS(dtos.getNombreS()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtos.getNombreS()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Skill skill = sSkill.getOne(id).get();
        skill.setNombreS(dtos.getNombreS());
        skill.setPorcentajeS(dtos.getPorcentajeS());
        
        sSkill.save(skill);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);                  
            
    }
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!sSkill.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sSkill.delete(id);
        
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }
    
}
