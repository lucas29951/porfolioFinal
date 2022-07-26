
package com.back.portfolio.controller;

import com.back.portfolio.entity.Experiencia;
import com.back.portfolio.service.IExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/experience")
//@CrossOrigin(origins = "https://apportfolioweb.web.app/")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {
    
    @Autowired
    private IExperienciaService expServ;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public void createExperience(@RequestBody Experiencia exp){
        expServ.agregarExperiencia(exp);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public void editExperience(@PathVariable("id") int id, 
                           @RequestBody Experiencia exp){
        Experiencia nva = expServ.buscarExperiencia(id);
        if(nva != null){
            nva.setNombre_puesto(exp.getNombre_puesto());
            nva.setLugar(exp.getLugar());
            nva.setLogo_empresa(exp.getLogo_empresa());
            nva.setFecha_inicio(exp.getFecha_inicio());
            nva.setFecha_fin(exp.getFecha_fin());
            nva.setDescripcion(exp.getDescripcion());
            //nva.setPersona(exp.getPersona());
            
            expServ.editarExperiencia(nva);
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteExperience(@PathVariable("id") int id){
        expServ.borrarExperiencia(id);
    }
    
    @GetMapping("/detail/{id}")
    @ResponseBody
    public Experiencia detail(@PathVariable("id") int id){
        return expServ.buscarExperiencia(id);
    }
    
    @GetMapping("/showAll")
    @ResponseBody
    public List<Experiencia> showExperiences(){
        return expServ.verExperiencias();
    }
}
