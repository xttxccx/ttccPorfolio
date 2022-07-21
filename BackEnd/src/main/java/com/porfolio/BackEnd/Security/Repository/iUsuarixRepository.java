
package com.porfolio.BackEnd.Security.Repository;

import com.porfolio.BackEnd.Security.Entity.Usuarix;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUsuarixRepository extends JpaRepository<Usuarix, Integer>{
    Optional<Usuarix> findByNombreUsuarix (String nombreUsuarix);
    
    boolean existsByNombreUsuarix(String nombreUsuarix);
    boolean existsByEmail(String email);
}
