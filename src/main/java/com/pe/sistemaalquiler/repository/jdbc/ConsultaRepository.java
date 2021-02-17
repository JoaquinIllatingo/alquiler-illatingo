package com.pe.sistemaalquiler.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pe.sistemaalquiler.controller.request.ConsultaRequest;
import com.pe.sistemaalquiler.repository.jdbc.dto.ConsultaDto;
import com.pe.sistemaalquiler.repository.jdbc.mapper.ConsultaMapper;

@Repository
public class ConsultaRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<ConsultaDto> consultaGeneral(ConsultaRequest filter) {
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		MapSqlParameterSource mapSource = new MapSqlParameterSource();
		String query = "";
		query += " SELECT i.id, hab.nombre,per.nombre, per.ape_pat,r.fec_ingreso, fec_fin_mensualidad, fec_pago "
				+ "	FROM public.periodo p " + "	inner join public.registro r " + "	on p.id_registro = r.id "
				+ "	inner join public.inquilino i " + "	on r.id_inquilino = i.id " + "	inner join public.persona per "
				+ "	on per.id = i.id_persona " + "	inner join public.habitacion hab "
				+ "	on hab.id = r.id_habitacion " + "	inner join public.propiedad prop "
				+ "	on prop.id = hab.id_propiedad " + "	where p.estado_pago=1 " + "	and prop.id = :idPropiedad "
				+ "	order by fec_fin_mensualidad desc " + "	limit 1 ";

		mapSource.addValue("idPropiedad", filter.getIdPropiedad());
		return template.query(query, mapSource, new ConsultaMapper());
	}

}
