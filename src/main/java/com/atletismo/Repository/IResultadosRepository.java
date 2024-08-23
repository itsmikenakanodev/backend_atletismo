package com.atletismo.Repository;

import com.atletismo.Repository.Modelo.Resultado;

public interface IResultadosRepository {

	public Resultado buscarId(Integer id);
	public Boolean insertar(Resultado resultados);
	public Boolean actualizar(Resultado resultados);
	public Boolean eliminar(Integer id);
}
