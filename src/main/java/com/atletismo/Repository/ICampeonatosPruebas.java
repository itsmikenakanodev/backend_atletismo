package com.atletismo.Repository;

import com.atletismo.Repository.Modelo.CampeonatoPrueba;
import java.util.List;

public interface ICampeonatosPruebas {
	
	public Boolean insertar(CampeonatoPrueba campeonatosPruebas);
	public Boolean actualizar(CampeonatoPrueba campeonatosPruebas);
	public Boolean eliminar(Integer id);
	public CampeonatoPrueba buscarPorId(Integer id);
	public List<CampeonatoPrueba> buscarPorIdCampeonatos(Integer idCampeonato);
	public List<CampeonatoPrueba> obtenerTodos();

}
