package com.atletismo.Service;

import com.atletismo.Repository.Modelo.CampeonatoPrueba;
import com.atletismo.Service.dto.CampeonatosPruebasDTO;

import java.util.List;


public interface ICampeonatosPruebasService {

	public Boolean insertar(CampeonatoPrueba campeonatosPruebas);
	public CampeonatoPrueba buscarPorId(Integer id);
	public CampeonatosPruebasDTO buscarPorIdDto(Integer id);
	public List<CampeonatosPruebasDTO> filtrarCampeonato(Integer idCampeonato);
	public Boolean actualizar(CampeonatoPrueba campeonatosPruebas);
	public Boolean eliminar(Integer id);
	public List<CampeonatosPruebasDTO> obtenerTodos();

	void deleteByCampeonatoIdAndPruebaId(Integer campeonatoId, Integer pruebaId);
	CampeonatoPrueba findByCampeonatoIdAndPruebaId(Integer campeonatoId, Integer pruebaId);
}
