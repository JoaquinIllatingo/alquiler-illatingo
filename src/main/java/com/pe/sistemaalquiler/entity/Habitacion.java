package com.pe.sistemaalquiler.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Habitacion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_habitacion")
	@SequenceGenerator(name = "seq_habitacion", sequenceName = "seq_habitacion", allocationSize = 1)
	@Column(name = "id")
	private Integer id;

//	@Column(name = "id_propiedad")
//	private String idPropiedad;

	@Column(name = "nombre")
	private String nombre;

	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_propiedad", insertable = false, updatable = false)
	@JoinColumn(name = "id_propiedad", nullable = false)
	@JsonIgnore
	private Propiedad propiedad;

	@OneToMany(mappedBy = "habitacion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Registro> registros;

}
