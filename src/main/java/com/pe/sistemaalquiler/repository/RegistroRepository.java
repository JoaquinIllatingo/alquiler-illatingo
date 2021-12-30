package com.pe.sistemaalquiler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.sistemaalquiler.entity.Registro;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer> {

}
