package com.atletismo.Repository;

import com.atletismo.Repository.Modelo.Resultado;

public interface IResultadosRepository {

	public Resultado buscarId(Integer id);
	public void insertar(Resultado resultados);
	public void actualizar(Resultado resultados);
	public void eliminar(Integer id);
}
