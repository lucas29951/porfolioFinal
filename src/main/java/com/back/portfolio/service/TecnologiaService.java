
package com.back.portfolio.service;

import com.back.portfolio.entity.Tecnologia;
import com.back.portfolio.repository.TecnologiaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnologiaService implements ITecnologiaService{
    
    @Autowired
    public TecnologiaRepository tecnoRepo;

    @Override
    public List<Tecnologia> verTecnologias() {
        return tecnoRepo.findAll();
    }

    @Override
    public void agregarTecnologia(Tecnologia tec) {
        tecnoRepo.save(tec);
    }

    @Override
    public void borrarTecnologia(int id) {
        tecnoRepo.deleteById(id);
    }

    @Override
    public Tecnologia buscarTecnologia(int id) {
        return tecnoRepo.findById(id).orElse(null);
    }

    @Override
    public void editarTecnologia(Tecnologia tec) {
        tecnoRepo.save(tec);
    }
    
}
