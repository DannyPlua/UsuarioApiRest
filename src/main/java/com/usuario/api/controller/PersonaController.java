package com.usuario.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.usuario.api.model.entity.Personas;
import com.usuario.api.model.service.IServicePersonas;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	private final IServicePersonas personaServ;
	
	@Autowired
	public PersonaController(IServicePersonas personaServ)
	{
		super();
		this.personaServ = personaServ;
		
	}
	
	@PostMapping("/post-listar-personas")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> ListPersonas(){
		
		return personaServ.ListarPersonas();
	}
	
	@PostMapping("/post-listar-personaid")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> ListPersonaId(Long idPersona){
		
		return personaServ.PersonaId(idPersona);
	}
	
	@PostMapping("/post-inserta-persona")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> InsertPersonas(Personas persona){
		
		return personaServ.InsertarPersona(persona);
	}
	
	@PostMapping("/post-actualiza-persona")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> UpdatePersonas(Personas persona){
		
		return personaServ.ActualizaPersona(persona);
	}
}
