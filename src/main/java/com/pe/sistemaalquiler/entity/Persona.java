package com.pe.sistemaalquiler.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_persona")
	@SequenceGenerator(name = "seq_persona", sequenceName = "seq_persona", allocationSize = 1)
	@Column(name = "id")
	private Integer id;

	private String nombre;

	@Column(name = "ape_pat")
	private String apellidoPaterno;

	@Column(name = "ape_mat")
	private String apellidoMaterno;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "inquilino_id", referencedColumnName = "id")

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "persona", cascade = CascadeType.ALL)
//	@PrimaryKeyJoinColumn
	@JsonIgnore
	private Inquilino inquilino;

}