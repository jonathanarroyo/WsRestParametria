package com.bancodebogota.ptdo.parametria.exception;

/**
 * © Todos los derechos reservados Banco de Bogotá
 * <p>
 * Class {Document} collection Parametros de mongodb
 * extends {RuntimeException}
 * 
 * @author Stiven Diaz
 * 
 */
public class ParametroException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -422137370963115530L;
	
	private Integer codError;
	
	protected ParametroException(String mensaje, RuntimeException e) {
		super(mensaje, e);
	}

	public Integer getCodError() {
		return codError;
	}

	public void setCodError(Integer codError) {
		this.codError = codError;
	}
	
	public static ParametroException NotFoundException(String nombre) {
		ParametroException parametroException = new ParametroException(String.format("No existe el parametro: '%s'.", nombre), null);
		parametroException.setCodError(1);
		return parametroException;
    }
	
	public static ParametroException DuplicateKeyException(String nombre, RuntimeException e) {
		ParametroException parametroException = new ParametroException(String.format("Ya existe el parametro: '%s'.", nombre), e);
		parametroException.setCodError(1);
		return parametroException;
    }
	
	public static ParametroException MongoSocketOpenException(RuntimeException e) {
		ParametroException parametroException = new ParametroException("Error al conectarse a la data.", e);
		parametroException.setCodError(500);
		return parametroException;
    }
	
}
