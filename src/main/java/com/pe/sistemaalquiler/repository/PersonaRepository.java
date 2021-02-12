package com.pe.sistemaalquiler.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.sistemaalquiler.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

	public Optional<Persona> findById(Integer id);

}
