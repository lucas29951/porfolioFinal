
package com.back.portfolio.service;

import com.back.portfolio.entity.Tecnologia;
import java.util.List;


public interface ITecnologiaService {
    
    public List<Tecnologia> verTecnologias();
    public void agregarTecnologia(Tecnologia tec);
    public void borrarTecnologia(int id);
    public Tecnologia buscarTecnologia(int id);
    public void editarTecnologia(Tecnologia tec);
}
