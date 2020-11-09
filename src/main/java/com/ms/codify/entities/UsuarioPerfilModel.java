/**
 * 
 */
package com.ms.codify.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase Entidad Usuario, contiene todos los datos de los usuarios del sistema
 * 
 * @author Jesus Garcia
 * @version 1.0 Creacion
 * @since Java 11
 */
@Entity
@Table(name = "usuario_perfil")
public class UsuarioPerfilModel {
    
	@Id
    @GeneratedValue
    @Column(name = "id_usuario_perfil", nullable = false)
    private Long idUsuarioPerfil;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioModel usuarioModel;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_perfil", nullable = false)
    private PerfilModel perfilModel;

	public UsuarioPerfilModel(Long idUsuarioPerfil, UsuarioModel usuarioModel, PerfilModel perfilModel) {
		super();
		this.idUsuarioPerfil = idUsuarioPerfil;
		this.usuarioModel = usuarioModel;
		this.perfilModel = perfilModel;
	}

	public UsuarioPerfilModel() {
		super();
	}

	public Long getIdUsuarioPerfil() {
		return idUsuarioPerfil;
	}

	public void setIdUsuarioPerfil(Long idUsuarioPerfil) {
		this.idUsuarioPerfil = idUsuarioPerfil;
	}

	public UsuarioModel getUsuario() {
		return usuarioModel;
	}

	public void setUsuario(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}

	public PerfilModel getPerfil() {
		return perfilModel;
	}

	public void setPerfil(PerfilModel perfilModel) {
		this.perfilModel = perfilModel;
	}

	@Override
	public String toString() {
		return "UsuarioPerfilModel [idUsuarioPerfil=" + idUsuarioPerfil + ", usuario=" + usuarioModel + ", perfil=" + perfilModel
				+ "]";
	}
    
    
    
}
