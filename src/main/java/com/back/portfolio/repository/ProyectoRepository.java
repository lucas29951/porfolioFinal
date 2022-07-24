
package com.back.portfolio.repository;

import com.back.portfolio.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lucas Rodriguez
 */

@Repository
public interface ProyectoRepository extends JpaRepository <Proyecto,Integer>{
    
}
