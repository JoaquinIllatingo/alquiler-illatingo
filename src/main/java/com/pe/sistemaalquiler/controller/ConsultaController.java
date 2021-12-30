package com.pe.sistemaalquiler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.sistemaalquiler.controller.request.ConsultaRequest;
import com.pe.sistemaalquiler.repository.jdbc.dto.ConsultaDto;
import com.pe.sistemaalquiler.service.ConsultaService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/consulta")
@Slf4j
public class ConsultaController {

	@Autowired
	private ConsultaService consultaService;

	@PostMapping(value = "/general", produces = "application/json")
	public List<ConsultaDto> getConsultaGeneral(@RequestBody ConsultaRequest request) {
		log.info("Starting getConsultaGeneral");
		return consultaService.consultar(request);
	}

}
