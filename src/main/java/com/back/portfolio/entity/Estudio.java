
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
public class Estudio {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idEstudio;
    @Basic
    private String nombre_institucion;
    private String logo;
    private String titulo;
    private LocalDate fecha_entrada;
    private LocalDate fecha_salida;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idPersona")
    @JsonBackReference
    private Persona persona;
    
    public Estudio(){
        
    }

    public Estudio(int idEstudio, String nombre_institucion, String logo, String titulo, String entrada, String salida, Persona persona) {
        this.idEstudio = idEstudio;
        this.nombre_institucion = nombre_institucion;
        this.logo = logo;
        this.titulo = titulo;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaIn = LocalDate.parse(entrada,formatter);
        LocalDate fechaSal = LocalDate.parse(salida,formatter);
        
        this.fecha_entrada = fechaIn;
        this.fecha_salida = fechaSal;
        this.persona = persona;
    }

    public int getIdEstudio() {
        return idEstudio;
    }

    public void setIdEstudio(int idEstudio) {
        this.idEstudio = idEstudio;
    }

    public String getNombre_institucion() {
        return nombre_institucion;
    }

    public void setNombre_institucion(String nombre_institucion) {
        this.nombre_institucion = nombre_institucion;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(LocalDate fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public LocalDate getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(LocalDate fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
}
