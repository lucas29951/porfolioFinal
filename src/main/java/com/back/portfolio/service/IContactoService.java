
package com.back.portfolio.service;

import com.back.portfolio.entity.Contacto;
import java.util.List;


public interface IContactoService {
    
    public List<Contacto> verContactos();
    public void agregarContacto(Contacto con);
    public void borrarContacto(int id);
    public Contacto buscarContacto(int id);
    public void editarContacto(Contacto con);
}
