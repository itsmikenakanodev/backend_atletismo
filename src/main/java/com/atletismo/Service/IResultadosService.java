package com.atletismo.Service;

import com.atletismo.Repository.Modelo.Resultado;

public interface IResultadosService {

	public Resultado buscarResultado(Integer id);
	public void insertarResultado(Resultado resultados);
	public void actualizarResultado(Resultado resultados);
	public void eliminarResultado(Integer id);
}
