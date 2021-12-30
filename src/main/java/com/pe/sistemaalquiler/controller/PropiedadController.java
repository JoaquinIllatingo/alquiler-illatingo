package com.pe.sistemaalquiler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.sistemaalquiler.entity.Propiedad;
import com.pe.sistemaalquiler.service.PropiedadService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/propiedad")
@Slf4j
public class PropiedadController {

	@Autowired
	private PropiedadService propiedadService;

	@GetMapping(produces = "application/json")
	public List<Propiedad> getPropiedad() {
		log.info("Starting getPropiedad");
		return propiedadService.findAll();
	}

}
