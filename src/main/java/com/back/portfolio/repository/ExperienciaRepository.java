
package com.back.portfolio.repository;

import com.back.portfolio.entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lucas Rodriguez
 */

@Repository
public interface ExperienciaRepository extends JpaRepository <Experiencia,Integer>{
    
}
