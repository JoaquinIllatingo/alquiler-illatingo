package com.pe.sistemaalquiler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.sistemaalquiler.entity.Propiedad;

@Repository
public interface PropiedadRepository extends JpaRepository<Propiedad, Integer> {

}
