
package com.porfolio.BackEnd.Interface;

import com.porfolio.BackEnd.Entity.Skills;
import java.util.List;

public interface ISkillsService {
    
    public List<Skills> verSkills ();
    public void nuevaSkill (Skills skill);
    public void borrarSkills (Long id);
    public Skills buscarSkill (Long id);
    public Skills editarSkill (Skills skill);
    
}
