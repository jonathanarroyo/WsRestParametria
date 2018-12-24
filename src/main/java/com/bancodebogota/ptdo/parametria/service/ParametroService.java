package com.bancodebogota.ptdo.parametria.service;

import java.util.List;

import com.bancodebogota.ptdo.parametria.model.Parametro;

/**
 * © Todos los derechos reservados Banco de Bogotá
 * <p>
 * Interface para el manejo de la data de la tabla Parametros
 * 
 * @author Stiven Diaz
 * 
 */
public interface ParametroService {
	
	/**
	 * Método para el manejo de toda la data en la tabla Parametros de mongodb
	 * retorna la Class {Parametro}
	 * 
	 * @return
	 */
	List<Parametro> findAll();
	
	/**
	 * Método para el manejo de la data consultada por el campo {nombre} en la tabla Parametros de mongodb
	 * retorna la Class {Parametro}
	 * 
	 * @param nombre
	 * @return
	 */
	Parametro findParametroByNombre(String nombre);
	
	/**
	 * Método que realiza el manejo de la data para guardar el registro en la tabla Parametros de mongodb
	 * retorna la Class {Parametro}
	 * 
	 * @param parametro
	 * @return
	 */
	Parametro save(Parametro parametro);
	
	/**
	 * Método que realiza el manejo de la data para modificar el registro en la tabla Parametros de mongodb
	 * retorna la Class {Parametro}
	 * 
	 * @param nombre
	 * @param parametro
	 * @return
	 */
	Parametro updateParametroByNombre(String nombre, Parametro parametro);
	
	/**
	 * Método que realiza el manejo de la data para eliminar el registro en la tabla Parametros de mongodb
	 * 
	 * @param parametro
	 */
	void deleteParametroByNombre(String nombre);

}
