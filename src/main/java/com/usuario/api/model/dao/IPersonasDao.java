package com.usuario.api.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.usuario.api.model.entity.Personas;

@Repository
public interface IPersonasDao extends JpaRepository<Personas, Long>{
	
	Personas findByIdPersonas(long personaId);
	
	@Modifying
	@Transactional
	@Query(
			value = "UPDATE dbo.Personas\r\n" + 
			"   SET nombre = :nombre\r\n" + 
			"      ,apellido = :apellido\r\n" + 
			"      ,edad = :edad\r\n" + 
			"      ,fechaNac = :fechaNac\r\n" + 
			"      ,direccion = :direccion\r\n" + 
			"      ,correo = :correo\r\n" + 
			" WHERE idPersonas = :idPersona", nativeQuery = true
			)
	Integer ModificarPersonas(@Param("nombre") String nombre,@Param("apellido") String apellido,
			@Param("edad") int edad,@Param("fechaNac") String fechaNac,@Param("direccion") String direccion,
			@Param("correo") String correo,@Param("idPersona") Long idPersona);
}
