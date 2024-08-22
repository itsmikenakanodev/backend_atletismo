package com.atletismo.Service;

import com.atletismo.Repository.IPruebasRepository;
import com.atletismo.Repository.Modelo.Prueba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PruebaServiceImpl implements IPruebasService{

    @Autowired
    private IPruebasRepository pruebasRepository;

    @Override
    public Boolean insertar(Prueba pruebas) {
        // TODO Auto-generated method stub
        return this.pruebasRepository.insertar(pruebas);
    }

    @Override
    public Prueba buscarPorId(Integer id) {
        // TODO Auto-generated method stub
        return this.pruebasRepository.buscarPorId(id);
    }

    @Override
    public Boolean actualizar(Prueba pruebas) {
        // TODO Auto-generated method stub
        return this.pruebasRepository.actualizar(pruebas);
    }

    @Override
    public Boolean eliminar(Integer id) {
        // TODO Auto-generated method stub
        return this.pruebasRepository.eliminar(id);
    }

    @Override
    public List<Prueba> buscarTodas() {
        return this.pruebasRepository.buscarTodas();
    }

}
