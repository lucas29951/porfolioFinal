
package com.back.portfolio.service;

import com.back.portfolio.entity.Persona;
import java.util.List;


public interface IPersonaService {
    
    public List<Persona> verPersonas();
    public void crearPersona(Persona pers);
    public void borrarPersona(int id);
    public Persona buscarPersona(int id);
    public void editarPersona(Persona pers);
}
