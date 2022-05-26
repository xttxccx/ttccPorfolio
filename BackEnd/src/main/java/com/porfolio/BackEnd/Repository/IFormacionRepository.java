
package com.porfolio.BackEnd.Repository;

import com.porfolio.BackEnd.Entity.Formacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFormacionRepository extends JpaRepository <Formacion, Long>{
    
}
