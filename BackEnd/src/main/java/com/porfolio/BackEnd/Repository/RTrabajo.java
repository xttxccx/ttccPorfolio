
package com.porfolio.BackEnd.Repository;

import com.porfolio.BackEnd.Entity.Trabajo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RTrabajo extends JpaRepository<Trabajo, Integer>{
    
    public Optional<Trabajo> findByNombreT(String nombreT);
    public boolean existsByNombreT(String nombreT);
    
}
