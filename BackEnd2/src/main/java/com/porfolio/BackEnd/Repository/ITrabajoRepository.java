package com.porfolio.BackEnd.Repository;

import com.porfolio.BackEnd.Entity.Trabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface ITrabajoRepository extends JpaRepository <Trabajo, Long>{
    
    
}
