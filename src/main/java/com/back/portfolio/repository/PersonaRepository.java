
package com.back.portfolio.repository;

import com.back.portfolio.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lucas Rodriguez
 */

@Repository
public interface PersonaRepository extends JpaRepository <Persona,Integer>{
    
}
