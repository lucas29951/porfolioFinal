
package com.back.portfolio.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

/**
 *
 * @author Lucas Rodriguez
 */

@Entity
public class Tecnologia {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idTec;
    @Basic
    private String nombre_tecno;
    private int nivel;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idPersona")
    @JsonBackReference
    private Persona persona;
    
    public Tecnologia(){
        
    }

    public Tecnologia(int idTec, String nombre_tecno, int nivel, Persona persona) {
        this.idTec = idTec;
        this.nombre_tecno = nombre_tecno;
        this.nivel = nivel;
        this.persona = persona;
    }

    public int getIdTec() {
        return idTec;
    }

    public void setIdTec(int idTec) {
        this.idTec = idTec;
    }

    public String getNombre_tecno() {
        return nombre_tecno;
    }

    public void setNombre_tecno(String nombre_tecno) {
        this.nombre_tecno = nombre_tecno;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
}
