
package com.back.portfolio.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.*;

/**
 *
 * @author Lucas Rodriguez
 */

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idExp;
    @Basic
    private String nombre_puesto;
    private String lugar;
    private String logo_empresa;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private String descripcion;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idPersona")
    @JsonBackReference
    private Persona persona;
    
    public Experiencia(){
        
    }

    public Experiencia(int idExp, String nombre_puesto, String lugar, String logo_empresa, String inicio, String fin, String descripcion, Persona persona) {
        this.idExp = idExp;
        this.nombre_puesto = nombre_puesto;
        this.lugar = lugar;
        this.logo_empresa = logo_empresa;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaInicio = LocalDate.parse(inicio,formatter);
        LocalDate fechaFin = LocalDate.parse(fin,formatter);
        
        this.fecha_inicio = fechaInicio;
        this.fecha_fin = fechaFin;
        this.descripcion = descripcion;
        this.persona = persona;
    }

    public int getIdExp() {
        return idExp;
    }

    public void setIdExp(int idExp) {
        this.idExp = idExp;
    }

    public String getNombre_puesto() {
        return nombre_puesto;
    }

    public void setNombre_puesto(String nombre_puesto) {
        this.nombre_puesto = nombre_puesto;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getLogo_empresa() {
        return logo_empresa;
    }

    public void setLogo_empresa(String logo_empresa) {
        this.logo_empresa = logo_empresa;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
}
