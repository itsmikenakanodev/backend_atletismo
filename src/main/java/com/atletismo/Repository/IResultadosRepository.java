package com.atletismo.Repository;

import java.util.List;

import com.atletismo.Repository.Modelo.Resultado;
import com.atletismo.Service.dto.ResultadoDTO;
import com.atletismo.Service.dto.ResultadoHistorialDTO;

public interface IResultadosRepository {

	public Resultado buscarId(Integer id);
	public Boolean insertar(Resultado resultados);
	public Boolean actualizar(Resultado resultados);
	public Boolean eliminar(Integer id);
	List<ResultadoDTO> buscarPorCampeonatoYPrueba(Integer idCampeonato, Integer idPrueba);
	List<ResultadoHistorialDTO> buscarResultadosAprobadosPorCedulaUsuario(String cedula);
}
