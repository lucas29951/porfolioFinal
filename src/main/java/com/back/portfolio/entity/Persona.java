
package com.back.portfolio.entity;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Lucas Rodriguez
 */

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idPersona;
    @Basic
    private String nombre;
    private String apellido;
    private String profesion;
    private String resumen;
    private String foto;
    
    @OneToMany(mappedBy="persona", cascade= {CascadeType.ALL})
    private List<Contacto> contactos;
    
    @OneToMany(mappedBy="persona",cascade= {CascadeType.ALL})
    private List<Estudio> estudios;
    
    @OneToMany(mappedBy="persona",cascade=CascadeType.ALL)
    private List<Experiencia> experiencias;
    
    @OneToMany(mappedBy="persona",cascade={CascadeType.ALL})
    private List<Proyecto> proyectos;
    
    @OneToMany(mappedBy="persona", cascade={CascadeType.ALL})
    private List<Tecnologia> tecnologias;
    
    public Persona(){
        super();
    }

    public Persona(int idPersona, String nombre, String apellido, String profesion, String resumen, String foto) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesion = profesion;
        this.resumen = resumen;
        this.foto = foto;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    public List<Estudio> getEstudios() {
        return estudios;
    }

    public void setEstudios(List<Estudio> estudios) {
        this.estudios = estudios;
    }

    public List<Experiencia> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(List<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public List<Tecnologia> getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(List<Tecnologia> tecnologias) {
        this.tecnologias = tecnologias;
    }
    
}
