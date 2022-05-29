
package com.porfolio.BackEnd.Repository;

import com.porfolio.BackEnd.Entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillsRepository extends JpaRepository <Skills, Long>{
    
}
