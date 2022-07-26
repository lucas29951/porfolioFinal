
package com.back.portfolio.controller;

import com.back.portfolio.entity.Persona;
import com.back.portfolio.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
//@CrossOrigin(origins = "https://apportfolioweb.web.app/")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    
    @Autowired
    private IPersonaService persoServ;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public void createPerson(@RequestBody Persona pers){
        persoServ.crearPersona(pers);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public void editPerson(@PathVariable("id") int id, 
                           @RequestBody Persona pers){
        Persona nva = persoServ.buscarPersona(id);
        if(nva != null){
            nva.setNombre(pers.getNombre());
            nva.setApellido(pers.getApellido());
            nva.setProfesion(pers.getProfesion());
            nva.setResumen(pers.getResumen());
            nva.setFoto(pers.getFoto());
            
            persoServ.editarPersona(nva);
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable("id") int id){
        persoServ.borrarPersona(id);
    }
    
    @GetMapping("/detail/{id}")
    @ResponseBody
    public Persona detail(@PathVariable("id") int id){
        return persoServ.buscarPersona(id);
    }
    
    @GetMapping("/showAll")
    @ResponseBody
    public List<Persona> showPersons(){
        return persoServ.verPersonas();
    }
}
