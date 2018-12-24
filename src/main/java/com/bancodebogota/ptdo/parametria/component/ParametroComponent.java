package com.bancodebogota.ptdo.parametria.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bancodebogota.ptdo.parametria.entity.ParametroEntity;
import com.bancodebogota.ptdo.parametria.model.Parametro;

/**
 * © Todos los derechos reservados Banco de Bogotá
 * <p>
 * Class {Component} componente para convertir {ParametroEntity} a {Parametro}
 * y convertir {Parametro} a {ParametroEntity}
 * 
 * @author Stiven Diaz
 * 
 */
@Component("ParametroComponent")
public class ParametroComponent {

	/**
	 * Método para convertir la entidad {ParametroEntity} al modelo {Parametro}
	 * 
	 * @param parametroEntity
	 * @return
	 */
	public Parametro entity2model(ParametroEntity parametroEntity) {
		Parametro parametro = new Parametro();
		parametro.setNombre(parametroEntity.getNombre());
		parametro.setValor(parametroEntity.getValor());
		return parametro;
	}
	
		
	/**
	 * Método para convertir una lista de la entidad {ParametroEntity} a una del modelo {Parametro}
	 * 
	 * @param parametroEntityList
	 * @return
	 */
	public List<Parametro> entity2modelList(List<ParametroEntity> parametroEntityList) {
		List<Parametro> parametroList = new ArrayList<Parametro>();
		for(ParametroEntity parametroEntity : parametroEntityList) {
			parametroList.add(entity2model(parametroEntity));
		}
		return parametroList;
	}

	
	/**
	 * Método para convertir el modelo {Parametro} a la entidad {ParametroEntity} 
	 * 
	 * @param parametro
	 * @return
	 */
	public ParametroEntity model2entity(Parametro parametro) {
		ParametroEntity parametroEntity = new ParametroEntity();
		parametroEntity.setNombre(parametro.getNombre());
		parametroEntity.setValor(parametro.getValor());
		return parametroEntity;
	}

}
