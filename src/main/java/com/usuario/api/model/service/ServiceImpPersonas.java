package com.usuario.api.model.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usuario.api.model.dao.IPersonasDao;
import com.usuario.api.model.entity.Personas;
import com.usuario.api.model.util.*;
import com.usuario.api.model.util.Error;
@Service
public class ServiceImpPersonas implements IServicePersonas {
	
	private Response response;
	private Error error;
	
	List<HashMap<String, String>> listResult;
	HashMap<String, String> result;
	
	@Autowired
	private IPersonasDao personaDao;
	
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<?> ListarPersonas(){
		List<Personas> listPerson = new ArrayList<Personas>();
		listResult = new ArrayList<>();
		response = new Response();
		
		try {
			
			listPerson = personaDao.findAll();
			if(!listPerson.isEmpty())
			{
				response.setSuccess(true);
				response.setCount(listPerson.size());
				response.setData(listPerson);				
			}else {
				
				error = new Error(HttpStatus.OK.value(), "001", "No hay Datos");
				
				response.setSuccess(false);
				response.setError(error);
				response.setCount(0);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			
		} catch (DataAccessException ex) {
			String usermessage = ex.getMessage().concat(": ,".concat(ex.getMostSpecificCause().getMessage()));
			
			error = new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "9999", usermessage);
			
			response.setSuccess(false);
			response.setError(error);
			response.setCount(0);		
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	
	@Override
	public ResponseEntity<?> PersonaId(Long idPersona) {
		Personas persona = new Personas();
		List<Personas> listPerson = new ArrayList<Personas>();
		listResult = new ArrayList<>();
		response = new Response();
		try {
			persona = personaDao.findByIdPersonas(idPersona);
			
			if(persona != null)
			{
				listPerson.add(persona);
				
				response.setSuccess(true);
				response.setCount(listPerson.size());
				response.setData(listPerson);
			}else {
				error = new Error(HttpStatus.OK.value(), "001", "No hay Datos");
				
				response.setSuccess(false);
				response.setError(error);
				response.setCount(0);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			
		} catch (DataAccessException ex) {
			String usermessage = ex.getMessage().concat(": ,".concat(ex.getMostSpecificCause().getMessage()));
			
			error = new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "9999", usermessage);
			
			response.setSuccess(false);
			response.setError(error);
			response.setCount(0);		
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}


	@Override
	public ResponseEntity<?> InsertarPersona(Personas persona) {
		
		result = new HashMap<String, String>();
		listResult = new ArrayList<HashMap<String,String>>();
		
		try {
			personaDao.save(persona);
			result.put("codigo", "000");
			result.put("mensaje", "OK");
			
			listResult.add(result);
			
			response.setSuccess(true);
			response.setData(listResult);
			response.setCount(listResult.size());
			
		} catch (DataAccessException ex) {
			String usermessage = ex.getMessage().concat(": ,".concat(ex.getMostSpecificCause().getMessage()));
			
			error = new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "9999", usermessage);
			
			response.setSuccess(false);
			response.setError(error);
			response.setCount(0);		
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<?> ActualizaPersona(Personas persona)
	{
		result = new HashMap<String, String>();
		listResult = new ArrayList<HashMap<String,String>>();
		int resp;
		
		String nombre = persona.getNombre();
		String apellido = persona.getApellido();
		int edad = persona.getEdad();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fechaNac = formatter.format(persona.getFechaNac());
		String direccion = persona.getDireccion();
		String correo = persona.getCorreo();
		Long idPersona = persona.getIdPersonas();
			
		try {
			
			result = new HashMap<String, String>();
			
			resp = personaDao.ModificarPersonas(nombre, apellido, edad, fechaNac, direccion, correo, idPersona);
			
			if(resp > 0)
			{
				result.put("codigo", "000");
				result.put("mensaje", "Ok");
			}else {
				result.put("codigo", "001");
				result.put("mensaje", "Registro no encontrado");
			}
			listResult.add(result);
			
			response.setSuccess(true);
			response.setCount(listResult.size());
			response.setData(listResult);	
			
		} catch (DataAccessException ex) {
			String usermessage = ex.getMessage().concat(": ,".concat(ex.getMostSpecificCause().getMessage()));
			
			error = new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "9999", usermessage);
			
			response.setSuccess(false);
			response.setError(error);
			response.setCount(0);		
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

}
