package com.bancodebogota.ptdo.parametria.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bancodebogota.ptdo.parametria.entity.ParametroEntity;

/**
 * © Todos los derechos reservados Banco de Bogotá
 * <p>
 * Interface para el manejo de la tabla Parametro en mondodb
 * extend {MongoRepository<Parametro, String>}
 * 
 * @author Stiven Diaz
 * 
 */
@Repository("ParametroRepository")
public interface ParametroRepository extends MongoRepository<ParametroEntity, String> {
	
	/**
	 * Método para la consulta del parametro por nombre
	 * retorna {Optional<Parametro>}
	 * 
	 * @param nombre
	 * @return
	 */
	Optional<ParametroEntity> findByNombre(String nombre);
	
	/**
	 * Método para la consulta del parametro por _id
	 * retorna {Optional<Parametro>}
	 * 
	 * @param _id
	 * @return
	 */
	Optional<ParametroEntity> findBy_id(ObjectId _id);
}
