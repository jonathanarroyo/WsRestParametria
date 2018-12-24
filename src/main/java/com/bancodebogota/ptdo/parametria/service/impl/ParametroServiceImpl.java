package com.bancodebogota.ptdo.parametria.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.bancodebogota.ptdo.parametria.component.ParametroComponent;
import com.bancodebogota.ptdo.parametria.entity.ParametroEntity;
import com.bancodebogota.ptdo.parametria.exception.ParametroException;
import com.bancodebogota.ptdo.parametria.model.Parametro;
import com.bancodebogota.ptdo.parametria.repository.ParametroRepository;
import com.bancodebogota.ptdo.parametria.service.ParametroService;
import com.mongodb.MongoSocketOpenException;

/**
 * © Todos los derechos reservados Banco de Bogotá
 * <p>
 * Class {Service} para el manejo de la data de la tabla Parametros implemeta
 * {ParametroService}
 * 
 * @author Stiven Diaz
 * 
 */
@Service("ParametroService")
public class ParametroServiceImpl implements ParametroService {

	@Autowired
	@Qualifier("ParametroRepository")
	private ParametroRepository parametroRepository;

	@Autowired
	@Qualifier("ParametroComponent")
	private ParametroComponent parametroConverter;

	@Override
	public List<Parametro> findAll() {
		try {
			List<ParametroEntity> parametroEntityList = parametroRepository.findAll();
			if (parametroEntityList.size() > 0) {
				return parametroConverter.entity2modelList(parametroEntityList);
			} else {
				throw ParametroException.NotFoundException("Vacio");
			}
		} catch (MongoSocketOpenException e) {
			throw ParametroException.MongoSocketOpenException(e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bancodebogota.ptdo.parametria.service.ParametroService#
	 * findParametroByNombre(java.lang.String)
	 */
	@Override
	public Parametro findParametroByNombre(String nombre) {
		try {
			Optional<ParametroEntity> optionalParametroEntity = parametroRepository.findByNombre(nombre);
			if (optionalParametroEntity.isPresent()) {
				return parametroConverter.entity2model(optionalParametroEntity.get());
			} else {
				throw ParametroException.NotFoundException(nombre);
			}
		} catch (MongoSocketOpenException e) {
			throw ParametroException.MongoSocketOpenException(e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bancodebogota.ptdo.parametria.service.ParametroService#save(com.
	 * bancodebogota.ptdo.parametria.model.Parametro)
	 */
	@Override
	public Parametro save(Parametro parametro) {
		try {
			ParametroEntity parametroEntity = parametroConverter.model2entity(parametro);
			parametroEntity.set_id(ObjectId.get());
			parametroEntity.setFechaCreacion(new Date());
			parametroRepository.save(parametroEntity);
			return parametro;
		} catch (MongoSocketOpenException e) {
			throw ParametroException.MongoSocketOpenException(e);
		} catch (DuplicateKeyException e) {
			throw ParametroException.DuplicateKeyException(parametro.getNombre(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bancodebogota.ptdo.parametria.service.ParametroService#
	 * updateParametroByNombre(java.lang.String,
	 * com.bancodebogota.ptdo.parametria.model.Parametro)
	 */
	@Override
	public Parametro updateParametroByNombre(String nombre, Parametro parametro) {
		try {
			Optional<ParametroEntity> optionalParametroEntity = parametroRepository.findByNombre(nombre);
			if (optionalParametroEntity.isPresent()) {
				optionalParametroEntity.get().setValor(parametro.getValor());
				optionalParametroEntity.get().setFechaActualizacion(new Date());
				parametroRepository.save(optionalParametroEntity.get());
				parametro.setNombre(optionalParametroEntity.get().getNombre());
				return parametro;
			} else {
				throw ParametroException.NotFoundException(nombre);
			}
		} catch (MongoSocketOpenException e) {
			throw ParametroException.MongoSocketOpenException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bancodebogota.ptdo.parametria.service.ParametroService#delete(com.
	 * bancodebogota.ptdo.parametria.model.Parametro)
	 */
	@Override
	public void deleteParametroByNombre(String nombre) {
		Optional<ParametroEntity> optionalParametroEntity = parametroRepository.findByNombre(nombre);
		if (optionalParametroEntity.isPresent()) {
			parametroRepository.delete(optionalParametroEntity.get());
		} else {
			throw ParametroException.NotFoundException(nombre);
		}
	}

}