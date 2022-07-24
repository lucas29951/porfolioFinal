
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
public class Proyecto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idProyecto;
    @Basic
    private String nombre_proyecto;
    private LocalDate fecha_realizacion;
    private String descripcion;
    private String enlace_proyecto;
    private String imagen_demo;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idPersona")
    @JsonBackReference
    private Persona persona;
    
    public Proyecto(){
        
    }

    public Proyecto(int idProyecto, String nombre_proyecto, String fecha, String descripcion, String enlace_proyecto, String imagen_demo, Persona persona) {
        this.idProyecto = idProyecto;
        this.nombre_proyecto = nombre_proyecto;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaRe = LocalDate.parse(fecha,formatter);
        
        this.fecha_realizacion = fechaRe;
        this.descripcion = descripcion;
        this.enlace_proyecto = enlace_proyecto;
        this.imagen_demo = imagen_demo;
        this.persona = persona;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre_proyecto() {
        return nombre_proyecto;
    }

    public void setNombre_proyecto(String nombre_proyecto) {
        this.nombre_proyecto = nombre_proyecto;
    }

    public LocalDate getFecha_realizacion() {
        return fecha_realizacion;
    }

    public void setFecha_realizacion(LocalDate fecha_realizacion) {
        this.fecha_realizacion = fecha_realizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEnlace_proyecto() {
        return enlace_proyecto;
    }

    public void setEnlace_proyecto(String enlace_proyecto) {
        this.enlace_proyecto = enlace_proyecto;
    }

    public String getImagen_demo() {
        return imagen_demo;
    }

    public void setImagen_demo(String imagen_demo) {
        this.imagen_demo = imagen_demo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
}
