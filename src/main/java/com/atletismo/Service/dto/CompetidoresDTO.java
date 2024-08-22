package com.atletismo.Service.dto;

import com.atletismo.Repository.Modelo.Resultado;
import com.cloud.backend.project.repository.modelo.AsociacionesDeportivas;
import com.cloud.backend.project.repository.modelo.CampeonatosCompetidores;
import com.cloud.backend.project.repository.modelo.CompetidoresPruebas;
import com.cloud.backend.project.repository.modelo.Resultados;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompetidoresDTO {

	private Integer id;
	private Date fechaInscripcion;
	private String cuentaBancaria;
	private UsuarioDTO usuarios;
	private List<Resultado> resultado;
}
