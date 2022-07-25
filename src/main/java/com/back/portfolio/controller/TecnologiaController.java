
package com.back.portfolio.controller;

import com.back.portfolio.entity.Tecnologia;
import com.back.portfolio.service.ITecnologiaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/technology")
@CrossOrigin(origins = "https://apportfolioweb.web.app/")
public class TecnologiaController {
    
    @Autowired
    private ITecnologiaService tecnoServ;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public void createTechnology(@RequestBody Tecnologia tec){
        tecnoServ.agregarTecnologia(tec);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public void editTechnology(@PathVariable("id") int id, 
                           @RequestBody Tecnologia tec){
        Tecnologia nva = tecnoServ.buscarTecnologia(id);
        if(nva != null){
            nva.setNombre_tecno(tec.getNombre_tecno());
            nva.setNivel(tec.getNivel());
            //nva.setPersona(tec.getPersona());
            
            tecnoServ.editarTecnologia(nva);
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteTechnology(@PathVariable("id") int id){
        tecnoServ.borrarTecnologia(id);
    }
    
    @GetMapping("/detail/{id}")
    @ResponseBody
    public Tecnologia detail(@PathVariable("id") int id){
        return tecnoServ.buscarTecnologia(id);
    }
    
    @GetMapping("/showAll")
    @ResponseBody
    public List<Tecnologia> showTechnologies(){
        return tecnoServ.verTecnologias();
    }
}
