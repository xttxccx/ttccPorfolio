package com.porfolio.BackEnd.Repository;

import com.porfolio.BackEnd.Entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface IPerfilRepository extends JpaRepository<Perfil, Long> {
    
}
