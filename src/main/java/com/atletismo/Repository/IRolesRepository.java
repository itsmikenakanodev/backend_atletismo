package com.atletismo.Repository;

import com.atletismo.Repository.Modelo.Rol;

import java.util.List;

public interface IRolesRepository {

    public Boolean insertarRol(Rol rol);
    public Boolean actualizarRol(Rol rol);
    public Boolean eliminarRol(Integer id);
    public Rol buscarRol(Integer id);

    public List<Rol> buscarTodosRoles();

}
