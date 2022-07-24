
package com.back.portfolio.service;

import com.back.portfolio.entity.Estudio;
import java.util.List;


public interface IEstudioService {
    
    public List<Estudio> verEstudios();
    public void agregarEstudio(Estudio est);
    public void borrarEstudio(int id);
    public Estudio buscarEstudio(int id);
    public void editarEstudio(Estudio est);
}
