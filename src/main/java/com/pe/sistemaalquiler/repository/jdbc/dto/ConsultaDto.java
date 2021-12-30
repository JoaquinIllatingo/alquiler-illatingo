package com.pe.sistemaalquiler.repository.jdbc.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaDto {

	private Integer idInquilino;
	private String nombreHabitacion;
	private String nombrePersona;
	private String apellidoPaterno;
	private Date fechaIngreso;
	private Date fechaFinMensualidad;
	private Date fechaPago;
	private Integer numeroMesesDebe;

}
