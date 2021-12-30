package com.pe.sistemaalquiler.controller.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistroRequest {

	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String tipoDocumento;
	private String numeroDocumento;
	private String trabajo;
	private String observacion;

	private Date fechaIngreso;
	private Integer habitacion;

}
