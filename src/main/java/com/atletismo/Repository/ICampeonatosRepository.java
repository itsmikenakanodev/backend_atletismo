package com.atletismo.Repository;

import com.atletismo.Repository.Modelo.Campeonato;

import java.time.LocalDate;
import java.util.List;

public interface ICampeonatosRepository {

    Boolean guardarCampeonatos(Campeonato campeonato);

    List<Campeonato> listarCampeonatos();

    List<Campeonato> listarCampeonatosProvincia(String provincia);

    List<Campeonato> listarCampeonatosSinPruebas(LocalDate fecha);

    public List<Campeonato> listarCampeonatosPorMes(LocalDate fecha);

    Campeonato buscarPorId(Integer id);

    Boolean actualizarCampeonatos(Campeonato campeonato);

    int borrarCampenatos(Integer id);

}
