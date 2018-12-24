package com.bancodebogota.ptdo.parametria.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * © Todos los derechos reservados Banco de Bogotá
 * <p>
 * Class para el manejo del parametro requerido
 * 
 * @author Stiven Diaz
 * 
 */
public class Parametro {
	
	@NotNull
	@Size(min = 1, max = 50)
	private String nombre;
	
	@NotNull
	@Size(min = 1, max = 500)
	private String valor;

	public Parametro() {

	}

	public Parametro(String nombre, String valor) {
		this.nombre = nombre;
		this.valor = valor;
	}

	public Parametro(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
