package com.atletismo.Repository;

import com.atletismo.Repository.Modelo.Prueba;

import java.util.List;

public interface IPruebasRepository {

    public Boolean insertar(Prueba pruebas);

    public Prueba buscarPorId(Integer id);

    public Boolean actualizar(Prueba pruebas);

    public Boolean eliminar(Integer id);
    public List<Prueba> buscarTodas();

}
