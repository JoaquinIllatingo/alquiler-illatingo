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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
public class Inquilino {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_inquilino")
	@SequenceGenerator(name = "seq_inquilino", sequenceName = "seq_inquilino", allocationSize = 1)
	@Column(name = "id")
	private Integer id;

	@Column(name = "trabajo")
	private String trabajo;

	@Column(name = "observacion")
	private String observacion;

	@Column(name = "estado")
	private Integer estado;

//	@OneToOne(mappedBy = "inquilino")
//	@OneToOne
	@OneToOne(fetch = FetchType.LAZY, optional = false)
//	@MapsId
	@JoinColumn(name = "id_persona")
	private Persona persona;

	@OneToMany(mappedBy = "inquilino", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Registro> registros;

}