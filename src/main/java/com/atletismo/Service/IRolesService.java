package com.atletismo.Service;

import com.atletismo.Repository.Modelo.Rol;

import java.util.List;

public interface IRolesService {

    public Boolean insertarRol(Rol rol);
    public Boolean actualizarRol(Rol rol);
    public Boolean eliminarRol(Integer id);
    public Rol buscar(Integer id);

    public List<Rol> buscarTodosRoles();
}
