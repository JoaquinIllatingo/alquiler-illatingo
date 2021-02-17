package com.pe.sistemaalquiler.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Propiedad {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_propiedad")
	@SequenceGenerator(name = "seq_propiedad", sequenceName = "seq_propiedad", allocationSize = 1)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "distrito")
	private String distrito;

	@OneToMany(mappedBy = "propiedad", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Habitacion> habitaciones;

}