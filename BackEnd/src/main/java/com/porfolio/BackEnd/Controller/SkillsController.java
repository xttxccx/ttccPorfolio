
package com.porfolio.BackEnd.Controller;

import com.porfolio.BackEnd.Entity.Skills;
import com.porfolio.BackEnd.Interface.ISkillsService;
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
@RequestMapping("/skill")
public class SkillsController {
    
    @Autowired ISkillsService skillSer;
    
    @PostMapping ("/nueva")
    public String nuevaSkill (@RequestBody Skills skill) {
        skillSer.nuevaSkill(skill);
        return "Nueva skill agregada exitosamente";
    }
    
    @GetMapping ("/lista")
    @ResponseBody
    public List<Skills> verSkills () {
        return skillSer.verSkills();
    }
    
    @GetMapping("/ver/{id}")
    public ResponseEntity<Skills> buscarSkill(@PathVariable("id") Long id){
        Skills skill=skillSer.buscarSkill(id);
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }
    
    @PutMapping("/editar")
    public ResponseEntity<Skills> editarSkills(@RequestBody Skills ski){
       Skills skill=skillSer.editarSkill(ski);
       return new ResponseEntity<>(skill, HttpStatus.OK);
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String borrarSkill (@PathVariable("id") Long id){
        skillSer.borrarSkills(id);
        return "Skill eliminada exitosamente.";
    }
    
}
