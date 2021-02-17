package com.pe.sistemaalquiler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.sistemaalquiler.entity.Propiedad;
import com.pe.sistemaalquiler.repository.PropiedadRepository;

@Service
public class PropiedadService {

	@Autowired
	private PropiedadRepository propiedadRepository;

	public List<Propiedad> findAll() {
		return propiedadRepository.findAll();
	}
}
