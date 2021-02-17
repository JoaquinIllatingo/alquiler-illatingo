package com.pe.sistemaalquiler.repository.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.pe.sistemaalquiler.repository.jdbc.dto.ConsultaDto;

public class ConsultaMapper implements RowMapper<ConsultaDto> {

	@Override
	public ConsultaDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ConsultaDto obj = new ConsultaDto();
		obj.setIdInquilino(rs.getInt(1));
		obj.setNombreHabitacion(rs.getString(2));
		obj.setNombrePersona(rs.getString(3));
		obj.setApellidoPaterno(rs.getString(4));
		obj.setFechaIngreso(rs.getDate(5));
		obj.setFechaFinMensualidad(new Date(rs.getString(6)));
		obj.setFechaPago(rs.getDate(7));

		return obj;
	}

}
