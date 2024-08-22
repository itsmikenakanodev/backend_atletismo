package com.atletismo.Repository;

import com.atletismo.Repository.Modelo.Campeonato;

import java.util.List;

public interface ICampeonatosRepository {

    Boolean guardarCampeonatos(Campeonato campeonato);

    List<Campeonato> listarCampeonatos();

    List<Campeonato> listarCampeonatosProvincia(String provincia);

    Campeonato buscarPorId(Integer id);

    Boolean actualizarCampeonatos(Campeonato campeonato);

    int borrarCampenatos(Integer id);

}
