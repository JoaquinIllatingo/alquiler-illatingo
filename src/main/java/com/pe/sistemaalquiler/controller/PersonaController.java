package com.pe.sistemaalquiler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.sistemaalquiler.entity.Persona;
import com.pe.sistemaalquiler.service.PersonaService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/persona")
@Slf4j
public class PersonaController {

	@Autowired
	private PersonaService personaService;

	@GetMapping(value = "/{id}", produces = "application/json")
	public Persona getPersona(@PathVariable String id) {
		log.info("Starting getPersona");
		return personaService.findById(Integer.parseInt(id));
	}

	@PostMapping(produces = "application/json")
	public Persona getPersona(@RequestBody Persona persona) {
		log.info("Starting getPersona");
		return personaService.savePersona(persona);
	}

}
