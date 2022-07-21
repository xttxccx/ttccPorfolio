
package com.porfolio.BackEnd.Repository;

import com.porfolio.BackEnd.Entity.Docencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RDocencia extends JpaRepository<Docencia, Integer>{
    
    public Optional<Docencia> findByNombreD(String nombreD);
    public boolean existsByNombreD(String nombreD);
    
}
