package com.pe.sistemaalquiler.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Registro {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_registro")
	@SequenceGenerator(name = "seq_registro", sequenceName = "seq_registro", allocationSize = 1)
	@Column(name = "id")
	private Integer id;

	@Column(name = "fec_ingreso")
	private Date fechaIngreso;

	@Column(name = "fec_salida")
	private Date fechaSalida;

	@Column(name = "estado")
	private Integer estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_inquilino", nullable = false)
	private Inquilino inquilino;

	@Column(name = "id_habitacion")
	private Integer idHabitacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_habitacion", insertable = false, updatable = false)
	private Habitacion habitacion;

}