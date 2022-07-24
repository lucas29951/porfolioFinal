
package com.back.portfolio.service;

import com.back.portfolio.entity.Contacto;
import com.back.portfolio.repository.ContactoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactoService implements IContactoService{

    @Autowired
    public ContactoRepository contRepo;
    
    @Override
    public List<Contacto> verContactos() {
        return contRepo.findAll();
    }

    @Override
    public void agregarContacto(Contacto con) {
        contRepo.save(con);
    }

    @Override
    public void borrarContacto(int id) {
        contRepo.deleteById(id);
    }

    @Override
    public Contacto buscarContacto(int id) {
        return contRepo.findById(id).orElse(null);
    }

    @Override
    public void editarContacto(Contacto con) {
        contRepo.save(con);
    }
    
}
