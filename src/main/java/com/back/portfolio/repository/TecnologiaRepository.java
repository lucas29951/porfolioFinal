
package com.back.portfolio.repository;

import com.back.portfolio.entity.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lucas Rodriguez
 */

@Repository
public interface TecnologiaRepository extends JpaRepository <Tecnologia,Integer>{
    
}
