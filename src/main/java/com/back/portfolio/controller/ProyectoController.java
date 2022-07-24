
package com.back.portfolio.controller;

import com.back.portfolio.entity.Proyecto;
import com.back.portfolio.service.IProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoController {
    
    @Autowired
    private IProyectoService proServ;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public void createProject(@RequestBody Proyecto pro){
        proServ.agregarProyecto(pro);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public void editProject(@PathVariable("id") int id, 
                           @RequestBody Proyecto pro){
        Proyecto nvo = proServ.buscarProyecto(id);
        if(nvo != null){
            nvo.setNombre_proyecto(pro.getNombre_proyecto());
            nvo.setDescripcion(pro.getDescripcion());
            nvo.setImagen_demo(pro.getImagen_demo());
            nvo.setEnlace_proyecto(pro.getEnlace_proyecto());
            nvo.setFecha_realizacion(pro.getFecha_realizacion());
            //nvo.setPersona(pro.getPersona());
            
            proServ.editarProyecto(nvo);
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteProject(@PathVariable("id") int id){
        proServ.borrarProyecto(id);
    }
    
    @GetMapping("/detail/{id}")
    @ResponseBody
    public Proyecto detail(@PathVariable("id") int id){
        return proServ.buscarProyecto(id);
    }
    
    @GetMapping("/showAll")
    @ResponseBody
    public List<Proyecto> showProjects(){
        return proServ.verProyectos();
    }
}
