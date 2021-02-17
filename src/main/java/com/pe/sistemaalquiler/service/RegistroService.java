package com.pe.sistemaalquiler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.sistemaalquiler.controller.request.RegistroRequest;
import com.pe.sistemaalquiler.entity.Inquilino;
import com.pe.sistemaalquiler.entity.Persona;
import com.pe.sistemaalquiler.entity.Registro;
import com.pe.sistemaalquiler.repository.PersonaRepository;
import com.pe.sistemaalquiler.repository.RegistroRepository;

@Service
public class RegistroService {

	@Autowired
	private RegistroRepository registroRepository;

	@Autowired
	private PersonaRepository personaRepository;

	public Registro save(RegistroRequest request) {

		Persona p = new Persona();
		p.setNombre(request.getNombre());
		p.setApellidoPaterno(request.getApellidoPaterno());
		p.setApellidoMaterno(request.getApellidoMaterno());

		Inquilino i = new Inquilino();
		i.setEstado(1);
		i.setObservacion(request.getObservacion());
		i.setTrabajo(request.getTrabajo());

		p.setInquilino(i);
		i.setPersona(p);

		personaRepository.save(p);

		Registro r = new Registro();
		r.setFechaIngreso(request.getFechaIngreso());
		r.setEstado(1);
		r.setIdHabitacion(request.getHabitacion());
		r.setInquilino(i);

		return registroRepository.save(r);
	}

}
