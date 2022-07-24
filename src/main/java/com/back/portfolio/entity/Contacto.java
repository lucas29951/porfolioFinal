
package com.back.portfolio.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

/**
 *
 * @author Lucas Rodriguez
 */

@Entity
public class Contacto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idContacto;
    @Basic
    private String nombre_info;
    private String info;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idPersona")
    @JsonBackReference
    private Persona persona;
    
    public Contacto(){
        
    }

    public Contacto(int idContacto, String nombre_info, String info, Persona persona) {
        this.idContacto = idContacto;
        this.nombre_info = nombre_info;
        this.info = info;
        this.persona = persona;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public String getNombre_info() {
        return nombre_info;
    }

    public void setNombre_info(String nombre_info) {
        this.nombre_info = nombre_info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
}
