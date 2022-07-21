
package com.porfolio.BackEnd.Security.Service;

import com.porfolio.BackEnd.Security.Entity.Usuarix;
import com.porfolio.BackEnd.Security.Repository.iUsuarixRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarixService {
    @Autowired
    iUsuarixRepository iusuarixRepository;
    
    public Optional<Usuarix> getByNombreUsuarix(String nombreUsuarix) {
        return iusuarixRepository.findByNombreUsuarix(nombreUsuarix);
    }
    
    public boolean existsByNombreUsuarix(String nombreUsuarix){
        return iusuarixRepository.existsByNombreUsuarix(nombreUsuarix);
    }
    
    public boolean existsByEmail(String email){
        return iusuarixRepository.existsByEmail(email);
    }
    
    public void save(Usuarix usuarix){
        iusuarixRepository.save(usuarix);
    }
}
