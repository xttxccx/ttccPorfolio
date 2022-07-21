
package com.porfolio.BackEnd.Repository;

import com.porfolio.BackEnd.Entity.Formacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RFormacion extends JpaRepository<Formacion, Integer>{
    
    public Optional<Formacion> findByNombreF(String nombreF);
    public boolean existsByNombreF(String nombreF);
    
}
