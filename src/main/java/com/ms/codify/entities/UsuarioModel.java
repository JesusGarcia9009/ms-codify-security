/**
 * 
 */
package com.ms.codify.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase Entidad Usuario, contiene todos los datos de los usuarios del sistema
 * 
 * @author Jesus Garcia
 * @version 1.0 Creacion
 * @since Java 11
 */
@Entity
@Table(name = "usuario")
public class UsuarioModel {
    
	@Id
    @GeneratedValue
    @Column(name = "id_usuario", nullable = false)
    public Long idUsuario;
 
    @Column(name = "rut", length = 50, nullable = false)
    public String rut;
    
    @Column(name = "nombre", length = 50, nullable = false)
    public String nombre;
    
    @Column(name = "apellido_paterno", length = 50, nullable = false)
    public String apellidoPaterno;
    
    @Column(name = "apellido_materno", length = 50, nullable = false)
    public String apellidoMaterno;
    
    @Column(name = "usuario", length = 200, nullable = false)
    public String usuario;
    
    @Column(name = "pass", length = 200, nullable = false)
    public String pass;
    
    @OneToMany(mappedBy = "usuarioModel",cascade = CascadeType.ALL)
    private List<UsuarioPerfilModel> usuarioPerfilList = new ArrayList<>();

	public UsuarioModel(Long idUsuario, String rut, String nombre, String apellidoPaterno, String apellidoMaterno,
			String usuario, String pass) {
		super();
		this.idUsuario = idUsuario;
		this.rut = rut;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.usuario = usuario;
		this.pass = pass;
	}

	public UsuarioModel() {
		super();
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public List<UsuarioPerfilModel> getUsuarioPerfilList() {
		return usuarioPerfilList;
	}

	public void setUsuarioPerfilList(List<UsuarioPerfilModel> usuarioPerfilList) {
		this.usuarioPerfilList = usuarioPerfilList;
	}

	@Override
	public String toString() {
		return "UsuarioModel [idUsuario=" + idUsuario + ", rut=" + rut + ", nombre=" + nombre + ", apellidoPaterno="
				+ apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", usuario=" + usuario + ", pass=" + pass
				+ "]";
	}
}
