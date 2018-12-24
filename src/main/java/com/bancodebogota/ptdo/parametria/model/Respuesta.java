package com.bancodebogota.ptdo.parametria.model;

public class Respuesta {

	private Integer estado;
	private String descripcion;
	private String parametro;
	private String valor;

	public Respuesta() {

	}

	public Respuesta(Integer estado, String descripcion) {
		this.estado = estado;
		this.descripcion = descripcion;
	}

	public Respuesta(Integer estado, String descripcion, String parametro, String valor) {
		this.estado = estado;
		this.descripcion = descripcion;
		this.parametro = parametro;
		this.valor = valor;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
