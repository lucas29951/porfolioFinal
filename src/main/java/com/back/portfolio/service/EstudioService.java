
package com.back.portfolio.service;

import com.back.portfolio.entity.Estudio;
import com.back.portfolio.repository.EstudioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudioService implements IEstudioService{

    @Autowired
    public EstudioRepository estuRepo;
    
    @Override
    public List<Estudio> verEstudios() {
        return estuRepo.findAll();
    }

    @Override
    public void agregarEstudio(Estudio est) {
        estuRepo.save(est);
    }

    @Override
    public void borrarEstudio(int id) {
        estuRepo.deleteById(id);
    }

    @Override
    public Estudio buscarEstudio(int id) {
        return estuRepo.findById(id).orElse(null);
    }

    @Override
    public void editarEstudio(Estudio est) {
        estuRepo.save(est);
    }
    
}
