package com.pe.sistemaalquiler.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.sistemaalquiler.entity.Persona;
import com.pe.sistemaalquiler.repository.PersonaRepository;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository personaRepository;

	public Persona findById(Integer id) {

		Optional<Persona> optional = personaRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return Persona.builder().id(5).nombre("demo").build();
		}
	}

	public Persona savePersona(Persona persona) {
		return personaRepository.save(persona);
	}

}
