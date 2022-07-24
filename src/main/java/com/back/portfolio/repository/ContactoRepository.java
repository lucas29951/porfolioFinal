
package com.back.portfolio.repository;

import com.back.portfolio.entity.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lucas Rodriguez
 */

@Repository
public interface ContactoRepository extends JpaRepository <Contacto,Integer>{
    
}
