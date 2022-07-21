
package com.porfolio.BackEnd.Security.Repository;

import com.porfolio.BackEnd.Security.Entity.Rol;
import com.porfolio.BackEnd.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);    
}
