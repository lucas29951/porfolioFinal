
package com.back.portfolio.repository;

import com.back.portfolio.entity.Estudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lucas Rodriguez
 */

@Repository
public interface EstudioRepository extends JpaRepository <Estudio,Integer>{
    
}
