
package com.porfolio.BackEnd.Repository;

import com.porfolio.BackEnd.Entity.Perfil;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RPerfil extends JpaRepository<Perfil, Integer>{
    
    public Optional<Perfil> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
    
}
