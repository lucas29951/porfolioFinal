
package com.back.portfolio.controller;

import com.back.portfolio.entity.Contacto;
import com.back.portfolio.service.IContactoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
//@CrossOrigin(origins = "https://apportfolioweb.web.app/")
@CrossOrigin(origins = "http://localhost:4200")
public class ContactoController {
    
    @Autowired
    private IContactoService contServ;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public void addContact(@RequestBody Contacto con){
        contServ.agregarContacto(con);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public void editContact(@PathVariable("id") int id, 
                           @RequestBody Contacto con){
        Contacto nvo = contServ.buscarContacto(id);
        if(nvo != null){
            nvo.setNombre_info(con.getNombre_info());
            nvo.setInfo(con.getInfo());
            //nvo.setPersona(con.getPersona());
            
            contServ.editarContacto(nvo);
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteContact(@PathVariable("id") int id){
        contServ.borrarContacto(id);
    }
    
    @GetMapping("/detail/{id}")
    @ResponseBody
    public Contacto detail(@PathVariable("id") int id){
        return contServ.buscarContacto(id);
    }
    
    @GetMapping("/showAll")
    @ResponseBody
    public List<Contacto> showContacts(){
        return contServ.verContactos();
    }
}
