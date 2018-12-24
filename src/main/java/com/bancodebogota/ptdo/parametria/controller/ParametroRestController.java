package com.bancodebogota.ptdo.parametria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancodebogota.ptdo.parametria.exception.ParametroException;
import com.bancodebogota.ptdo.parametria.model.Parametro;
import com.bancodebogota.ptdo.parametria.model.Respuesta;
import com.bancodebogota.ptdo.parametria.service.ParametroService;

/**
 * © Todos los derechos reservados Banco de Bogotá
 * <p>
 * Class {RestController} para el manejo del parametro
 * 
 * @author Stiven Diaz
 * 
 */
@RestController
@RequestMapping("/parametro")
public class ParametroRestController {

	@Autowired
	@Qualifier("ParametroService")
	private ParametroService parametroService;

	/**
	 * Método que retorna todos los parametros
	 * {ResponseEntity<Respuesta>}
	 * 
	 * @param nombre
	 * @return
	 */
	@GetMapping("/")
	public ResponseEntity<List<Parametro>> getParametroAll() {
		try {
			return ResponseEntity.ok(parametroService.findAll());
		} catch (ParametroException e) {
			return ResponseEntity.ok(null);
		}

	}

	/**
	 * Método para la consulta del parametro por nombre retorna
	 * {ResponseEntity<Respuesta>}
	 * 
	 * @param nombre
	 * @return
	 */
	@GetMapping("/{nombre}")
	public ResponseEntity<Respuesta> getParametroByNombre(@PathVariable("nombre") String nombre) {
		Respuesta respuesta = new Respuesta();
		try {
			Parametro parametro = parametroService.findParametroByNombre(nombre);
			respuesta.setEstado(0);
			respuesta.setDescripcion("Transacción exitosa");
			respuesta.setParametro(parametro.getNombre());
			respuesta.setValor(parametro.getValor());
			return ResponseEntity.ok(respuesta);
		} catch (ParametroException e) {
			respuesta.setEstado(e.getCodError());
			respuesta.setDescripcion(e.getMessage());
			return ResponseEntity.ok(respuesta);
		}

	}

	/**
	 * Método para agregar un nuevo parametro {BindingResult} Class que valida los
	 * errores encontrados en el request retorna {ResponseEntity<Respuesta>}
	 * 
	 * @param parametro
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("/")
	public ResponseEntity<Respuesta> createParametro(@Valid @RequestBody Parametro parametro,
			BindingResult bindingResult) {

		Respuesta respuesta = new Respuesta();

		if (bindingResult.hasErrors()) {

			StringBuilder inputError = new StringBuilder();

			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				if (!inputError.toString().equals(""))
					inputError.append(" - ");
				inputError.append(fieldError.getField() + ": " + fieldError.getDefaultMessage());
			}

			respuesta.setEstado(400);
			respuesta.setDescripcion(inputError.toString());
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.BAD_REQUEST);
		}

		try {
			parametro = parametroService.save(parametro);
			respuesta.setEstado(0);
			respuesta.setDescripcion("Transacción exitosa");
			respuesta.setParametro(parametro.getNombre());
			respuesta.setValor(parametro.getValor());
			return ResponseEntity.ok(respuesta);
		} catch (ParametroException e) {
			respuesta.setEstado(e.getCodError());
			respuesta.setDescripcion(e.getMessage());
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * Método para modificar un parametro por nombre {BindingResult} Class que
	 * valida los errores encontrados en el request retorna
	 * {ResponseEntity<Respuesta>}
	 * 
	 * @param nombre
	 * @param parametro
	 * @param bindingResult
	 * @return
	 */
	@PutMapping("/{nombre}")
	public ResponseEntity<Respuesta> modifyParametroByNombre(@PathVariable("nombre") String nombre,
			@Valid @RequestBody Parametro parametro, BindingResult bindingResult) {
		Respuesta respuesta = new Respuesta();

		if (bindingResult.hasErrors()) {

			StringBuilder inputError = new StringBuilder();

			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				if (!inputError.toString().equals(""))
					inputError.append(" - ");
				inputError.append(fieldError.getField() + ": " + fieldError.getDefaultMessage());
			}

			respuesta.setEstado(400);
			respuesta.setDescripcion(inputError.toString());
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.BAD_REQUEST);
		}

		try {
			parametro = parametroService.updateParametroByNombre(nombre, parametro);
			respuesta.setEstado(0);
			respuesta.setDescripcion("Transacción exitosa");
			respuesta.setParametro(parametro.getNombre());
			respuesta.setValor(parametro.getValor());
			return ResponseEntity.ok(respuesta);
		} catch (ParametroException e) {
			respuesta.setEstado(e.getCodError());
			respuesta.setDescripcion(e.getMessage());
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * Método para eliminar un parametro por nombre retorna
	 * {ResponseEntity<Respuesta>}
	 * 
	 * @param nombre
	 * @return
	 */
	@DeleteMapping("/{nombre}")
	public ResponseEntity<Respuesta> deleteParametroByNombre(@PathVariable String nombre) {
		Respuesta respuesta = new Respuesta();
		try {
			parametroService.deleteParametroByNombre(nombre);
			respuesta.setEstado(0);
			respuesta.setDescripcion("Transacción exitosa");
			return ResponseEntity.ok(respuesta);
		} catch (ParametroException e) {
			respuesta.setEstado(e.getCodError());
			respuesta.setDescripcion(e.getMessage());
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.BAD_REQUEST);
		}
	}

}
