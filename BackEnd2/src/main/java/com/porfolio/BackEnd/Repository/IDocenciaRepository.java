package com.porfolio.BackEnd.Repository;


import com.porfolio.BackEnd.Entity.Docencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocenciaRepository extends JpaRepository<Docencia, Long>{
    
}
