package com.usuario.api.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Usuario")
public class Personas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Personas")
    private long idPersonas;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Apellido")
    private String apellido;
    
    @Basic(optional = false)
    @Column(name = "edad")
    private int edad;
    
    @Column(name = "fecha_Nac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;

	public Personas() {		
	}

	public Personas(long idPersonas) {
		this.idPersonas = idPersonas;
	}

	public Personas(long idPersonas, String nombre, String apellido, int edad, Date fechaNac, String direccion,
			String correo) {
		this.idPersonas = idPersonas;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fechaNac = fechaNac;
		this.direccion = direccion;
		this.correo = correo;
	}

	public long getIdPersonas() {
		return idPersonas;
	}

	public void setIdPersonas(long idPersonas) {
		this.idPersonas = idPersonas;
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
    	
}