/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sis.nucleo.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author carlos.lopez
 */
@ManagedBean(name="loginBean")
public class Login {
	private String user;
	private String password;
	private String nombre;
	private Integer edad;
	private List<Login> listaUsuarios;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public List<Login> getListaUsuarios() {
		return listaUsuarios;
	}
	public void setListaUsuarios(List<Login> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public String validarLogin() {
		System.out.println("User : "+getUser());
		System.out.println("Password : "+getPassword());
		if(getUser().equals("carlos") && getPassword().equals("123")) {
			System.out.println("welcome . . .");
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> sessionMap = externalContext.getSessionMap();
			listaUsuarios = new ArrayList<Login>();
			sessionMap.put("listaUsuarios", listaUsuarios);
			return "welcome_";
		} else {
			return "login";
		}
	}
	
	public void setLista() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		listaUsuarios = (List<Login>)sessionMap.get("listaUsuarios");
	}
	
	public String guardar() {
		System.out.println("Guardando . . . ");
		System.out.println("Usuario : "+getUser());
		System.out.println("Password : "+getPassword());
		setLista();
		listaUsuarios.add(this);
		return "";
	}
	
	public String actualizar() {
		System.out.println("Actualizando . . . ");
		setLista();
		for(Login obj: listaUsuarios) {
			if(obj.getUser().equals(getUser())) {
				obj.setPassword(getPassword());
				obj.setEdad(getEdad());
				obj.setNombre(getNombre());
			}
		}
		return "";
	}
	
	public String borrar() {
		System.out.println("borrando . . . ");
		setLista();
		for(Login obj: listaUsuarios) {
			if(obj.getUser().equals(getUser())) {
				listaUsuarios.remove(obj);
				break;
			}
		}
		return "";
	}
}
