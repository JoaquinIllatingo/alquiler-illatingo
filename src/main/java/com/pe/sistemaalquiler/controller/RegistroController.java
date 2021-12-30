package com.pe.sistemaalquiler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.sistemaalquiler.controller.request.RegistroRequest;
import com.pe.sistemaalquiler.entity.Registro;
import com.pe.sistemaalquiler.service.RegistroService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/registro")
@Slf4j
public class RegistroController {

	@Autowired
	private RegistroService registroService;

	@PostMapping(produces = "application/json")
	public Registro saveRegistro(@RequestBody RegistroRequest request) {
		log.info("Starting getPersona");
		return registroService.save(request);
	}

}
