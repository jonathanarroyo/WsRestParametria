package com.bancodebogota.ptdo.parametria.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * © Todos los derechos reservados Banco de Bogotá
 * <p>
 * Class {Document} entity para el manejo de parametro requerido
 * de la tabla {parametros}
 * 
 * @author Stiven Diaz
 * 
 */
@Document(collection = "parametros")
public class ParametroEntity {
	@Id
	private ObjectId _id;
	
	@NotNull
	@Indexed(unique = true)
	private String nombre;
	
	@NotNull
	private String valor;
	
	@Field(value = "fecha_creacion")
	private Date fechaCreacion;
	
	@Field(value = "fecha_actualizacion")
	private Date fechaActualizacion;

	public ParametroEntity() {

	}

	public ParametroEntity(ObjectId _id, String nombre, String valor, Date fechaCreacion, Date fechaActualizacion) {
		this._id = _id;
		this.nombre = nombre;
		this.valor = valor;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
	}

	public ParametroEntity(String nombre) {
		this.nombre = nombre;
	}

	/*public String get_id() {
		return _id.toHexString();
	}*/

	public void set_id(ObjectId _id) {
		this._id = _id;
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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	
	@Override
    public String toString() {
        return "nombre: " + this.nombre //
                + ", valor: " + this.valor + ", fecha creación: " + this.fechaCreacion
                + ", fecha actualización: " + this.fechaActualizacion;
    }
}
