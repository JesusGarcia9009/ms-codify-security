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
@Table(name = "perfil")
public class PerfilModel {
    
	@Id
    @GeneratedValue
    @Column(name = "id_perfil", nullable = false)
    private Long idPerfil;
 
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;
    
    @Column(name = "descripcion", length = 200, nullable = false)
    private String descripcion;
    
    @OneToMany(mappedBy = "perfilModel",cascade = CascadeType.ALL)
    private List<UsuarioPerfilModel> usuarioPerfilList = new ArrayList<>();

	public PerfilModel(Long idPerfil, String nombre, String descripcion) {
		super();
		this.idPerfil = idPerfil;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public PerfilModel() {
		super();
	}

	public Long getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public List<UsuarioPerfilModel> getUsuarioPerfilList() {
		return usuarioPerfilList;
	}

	public void setUsuarioPerfilList(List<UsuarioPerfilModel> usuarioPerfilList) {
		this.usuarioPerfilList = usuarioPerfilList;
	}

	@Override
	public String toString() {
		return "PerfilModel [idPerfil=" + idPerfil + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
    
    
 
    
}
