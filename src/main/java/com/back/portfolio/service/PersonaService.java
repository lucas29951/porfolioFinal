
package com.back.portfolio.service;

import com.back.portfolio.entity.Persona;
import com.back.portfolio.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    public PersonaRepository persoRepo;
    
    @Override
    public List<Persona> verPersonas() {
        return persoRepo.findAll();
    }

    @Override
    public void crearPersona(Persona pers) {
        persoRepo.save(pers);
    }

    @Override
    public void borrarPersona(int id) {
        persoRepo.deleteById(id);
    }

    @Override
    public Persona buscarPersona(int id) {
        return persoRepo.findById(id).orElse(null);
    }

    @Override
    public void editarPersona(Persona pers) {
        persoRepo.save(pers);
    }
    
}
