
package com.back.portfolio.controller;

import com.back.portfolio.entity.Estudio;
import com.back.portfolio.service.IEstudioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/study")
//@CrossOrigin(origins = "https://apportfolioweb.web.app/")
public class EstudioController {
    
    @Autowired
    private IEstudioService estuServ;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public void createStudy(@RequestBody Estudio est){
        estuServ.agregarEstudio(est);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public void editStudy(@PathVariable("id") int id, 
                           @RequestBody Estudio est){
        Estudio nvo = estuServ.buscarEstudio(id);
        if(nvo != null){
            nvo.setNombre_institucion(est.getNombre_institucion());
            nvo.setLogo(est.getLogo());
            nvo.setTitulo(est.getTitulo());
            nvo.setFecha_entrada(est.getFecha_entrada());
            nvo.setFecha_salida(est.getFecha_salida());
            //nvo.setPersona(est.getPersona());
            
            estuServ.editarEstudio(nvo);
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteStudy(@PathVariable("id") int id){
        estuServ.borrarEstudio(id);
    }
    
    @GetMapping("/detail/{id}")
    @ResponseBody
    public Estudio detail(@PathVariable("id") int id){
        return estuServ.buscarEstudio(id);
    }
    
    @GetMapping("/showAll")
    @ResponseBody
    public List<Estudio> showStudies(){
        return estuServ.verEstudios();
    }
}
