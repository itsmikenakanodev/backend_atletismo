package com.atletismo.Service.dto;

import com.atletismo.Repository.Modelo.Resultado;
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
