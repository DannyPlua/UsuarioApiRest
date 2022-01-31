package com.usuario.api.model.service;

import org.springframework.http.ResponseEntity;
import com.usuario.api.model.entity.Personas;

public interface IServicePersonas {

	public ResponseEntity<?> ListarPersonas();
	
	public ResponseEntity<?> PersonaId(Long idPersona);
	
	public ResponseEntity<?> InsertarPersona(Personas persona);
	
	public ResponseEntity<?> ActualizaPersona(Personas persona);
	
}
