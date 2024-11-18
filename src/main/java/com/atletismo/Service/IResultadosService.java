package com.atletismo.Service;

import com.atletismo.Repository.Modelo.Resultado;
import com.atletismo.Service.dto.ResultadoDTO;

import java.util.List;

public interface IResultadosService {

	public Resultado buscarResultado(Integer id);
	public Boolean insertarResultado(Resultado resultados);
	public Boolean actualizarResultado(Resultado resultados);
	public Boolean eliminarResultado(Integer id);
	public List<ResultadoDTO> buscarPorCampeonatoYPrueba(Integer idCampeonato, Integer idPrueba);
}
