
package com.porfolio.BackEnd.Service;

import com.porfolio.BackEnd.Entity.Skills;
import com.porfolio.BackEnd.Interface.ISkillsService;
import com.porfolio.BackEnd.Repository.ISkillsRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpSkillsService implements ISkillsService {
    
    @Autowired ISkillsRepository iskillsRepository;

    @Override
    public List<Skills> verSkills() {
        List<Skills> skills = iskillsRepository.findAll();
        return skills;
    }

    @Override
    public void nuevaSkill(Skills skill) {
        iskillsRepository.save(skill);
    }

    @Override
    public void borrarSkills(Long id) {
        iskillsRepository.deleteById(id);
    }

    @Override
    public Skills buscarSkill(Long id) {
        Skills skill = iskillsRepository.findById(id).orElse(null);
        return skill;
    }

    @Override
    public Skills editarSkill(Skills skill) {
        return iskillsRepository.save(skill);
    }
    
}
