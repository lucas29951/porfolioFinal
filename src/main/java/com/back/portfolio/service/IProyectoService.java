
package com.back.portfolio.service;

import com.back.portfolio.entity.Proyecto;
import java.util.List;


public interface IProyectoService {
    
    public List<Proyecto> verProyectos();
    public void agregarProyecto(Proyecto pro);
    public void borrarProyecto(int id);
    public Proyecto buscarProyecto(int id);
    public void editarProyecto(Proyecto pro);
}
