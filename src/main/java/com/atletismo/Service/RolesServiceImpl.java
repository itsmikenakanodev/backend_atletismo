package com.atletismo.Service;

import com.atletismo.Repository.IRolesRepository;
import com.atletismo.Repository.Modelo.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements IRolesService {

    @Autowired
    IRolesRepository rolesRepository;

    @Override
    public Boolean insertarRol(Rol rol) {
        return this.rolesRepository.insertarRol(rol);
    }

    @Override
    public Boolean actualizarRol(Rol rol) {
        return this.rolesRepository.actualizarRol(rol);
    }

    @Override
    public Boolean eliminarRol(Integer id) {
        return this.rolesRepository.eliminarRol(id);
    }

    @Override
    public Rol buscar(Integer id) {
        return this.rolesRepository.buscarRol(id);
    }

    @Override
    public List<Rol> buscarTodosRoles() {
        return this.rolesRepository.buscarTodosRoles();
    }
}
