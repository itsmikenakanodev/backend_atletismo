package com.atletismo.Service;

import com.atletismo.Repository.Modelo.CampeonatoPrueba;
import com.atletismo.Repository.ICampeonatosPruebas;
import com.atletismo.Service.dto.CampeonatosPruebasDTO;
import com.atletismo.Service.dto.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampeonatosPruebasServiceImpl implements ICampeonatosPruebasService{

    @Autowired
    private ICampeonatosPruebas campeonatosPruebasRepository;
    @Autowired
    private Converter converter;


    @Override
    public Boolean insertar(CampeonatoPrueba campeonatoPrueba) {
        return this.campeonatosPruebasRepository.insertar(campeonatoPrueba);
    }

    @Override
    public CampeonatoPrueba buscarPorId(Integer id) {
        return this.campeonatosPruebasRepository.buscarPorId(id);
    }

    @Override
    public CampeonatosPruebasDTO buscarPorIdDto(Integer id) {
        CampeonatoPrueba campeonatoPrueba=this.buscarPorId(id);

        return converter.covertToDto(campeonatoPrueba);
    }

    @Override
    public List<CampeonatosPruebasDTO> filtrarCampeonato(Integer idCampeonato) {
        // TODO Auto-generated method stub
        List<CampeonatoPrueba> campeonatosPruebas = this.campeonatosPruebasRepository.buscarPorIdCampeonatos(idCampeonato);
        List<CampeonatosPruebasDTO> campeonatosPruebasDTOS=campeonatosPruebas.stream().map(x -> converter.covertToDto(x)).collect(Collectors.toList());
        return campeonatosPruebasDTOS;
    }

    @Override
    public Boolean actualizar(CampeonatoPrueba campeonatosPruebas) {
        return this.campeonatosPruebasRepository.actualizar(campeonatosPruebas);
    }

    @Override
    public Boolean eliminar(Integer id) {
        return this.campeonatosPruebasRepository.eliminar(id);
    }

    @Override
    public List<CampeonatosPruebasDTO> obtenerTodos() {
        return null;
       // return this.campeonatosPruebasRepository.obtenerTodos().stream().map(this::converter.).collect(Collectors.toList());
    }

    public void deleteByCampeonatoIdAndPruebaId(Integer campeonatoId, Integer pruebaId) {
        campeonatosPruebasRepository.deleteByCampeonatoIdAndPruebaId(campeonatoId, pruebaId);
    }

    public CampeonatoPrueba findByCampeonatoIdAndPruebaId(Integer campeonatoId, Integer pruebaId) {
        return campeonatosPruebasRepository.findByCampeonatoIdAndPruebaId(campeonatoId, pruebaId);
    }

}
