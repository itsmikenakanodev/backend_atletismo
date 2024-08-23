package com.atletismo.Service;

import com.atletismo.Repository.Modelo.Resultado;

public interface IResultadosService {

	public Resultado buscarResultado(Integer id);
	public Boolean insertarResultado(Resultado resultados);
	public Boolean actualizarResultado(Resultado resultados);
	public Boolean eliminarResultado(Integer id);
}
