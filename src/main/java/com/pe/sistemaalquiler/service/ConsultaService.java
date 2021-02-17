package com.pe.sistemaalquiler.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.sistemaalquiler.controller.request.ConsultaRequest;
import com.pe.sistemaalquiler.repository.jdbc.ConsultaRepository;
import com.pe.sistemaalquiler.repository.jdbc.dto.ConsultaDto;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository repository;

	public List<ConsultaDto> consultar(ConsultaRequest request) {

		List<ConsultaDto> list = repository.consultaGeneral(request);

		for (ConsultaDto consultaDto : list) {
			consultaDto.setNumeroMesesDebe(getMesesDebe(consultaDto.getFechaFinMensualidad()));
		}

		return list;

	}

	public Integer getMesesDebe(Date fecha) {
		LocalDate fechaAux = convertToLocalDateViaInstant(fecha);
		Period diff = Period.between(fechaAux, LocalDate.now());
		diff.getDays();

		if (diff.getDays() < 1) {
			return 1;
		} else if (diff.getDays() > 30 && diff.getDays() <= 60) {
			return 2;
		} else if (diff.getDays() > 60 && diff.getDays() <= 90) {
			return 3;
		} else if (diff.getDays() > 90 && diff.getDays() <= 120) {
			return 4;
		} else if (diff.getDays() > 120 && diff.getDays() <= 150) {
			return 5;
		} else {
			return 6;

		}

	}

	public LocalDate convertToLocalDateViaInstant(Date input) {

		Instant instant = input.toInstant();
		ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());

		LocalDate date = zdt.toLocalDate();

		return date;
//		return dateToConvert.toInstant()
//				.atZone(ZoneId.systemDefault()).toLocalDate();
	}
}
