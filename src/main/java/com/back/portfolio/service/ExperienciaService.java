
package com.back.portfolio.service;

import com.back.portfolio.entity.Experiencia;
import com.back.portfolio.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{

    @Autowired
    public ExperienciaRepository expRepo;
    
    @Override
    public List<Experiencia> verExperiencias() {
        return expRepo.findAll();
    }

    @Override
    public void agregarExperiencia(Experiencia exp) {
        expRepo.save(exp);
    }

    @Override
    public void borrarExperiencia(int id) {
        expRepo.deleteById(id);
    }

    @Override
    public Experiencia buscarExperiencia(int id) {
        return expRepo.findById(id).orElse(null);
    }

    @Override
    public void editarExperiencia(Experiencia exp) {
        expRepo.save(exp);
    }
    
}
