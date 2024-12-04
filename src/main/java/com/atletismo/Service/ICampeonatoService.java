package com.atletismo.Service;

import com.atletismo.Repository.Modelo.Campeonato;
import com.atletismo.Service.dto.CampeonatosDTO;
import com.atletismo.Service.dto.PruebasDTO;

import java.time.LocalDate;
import java.util.List;

public interface ICampeonatoService {

    Boolean guarCampeonatos(Campeonato campeonato);

    List<Campeonato> listarCampeonatos();

    Campeonato buscarPorId(Integer id);

    CampeonatosDTO buscarPorIdDto(Integer id);

    Boolean actualizarCampeonatos(Campeonato campeonato);

    int borrarCampenatos(Integer id);

    List<CampeonatosDTO> listarCampeonatosSinPruebasDto(LocalDate fecha);

    List<CampeonatosDTO> listarCampeonatosConPruebasDto(LocalDate fecha);

    List<CampeonatosDTO> listarCampeonatosProvincia(String provincia);

    Boolean agregarPruebas(Integer idCampeonato, List<PruebasDTO> pruebasDTO);

    public CampeonatosDTO listarCampeonatosId(Integer id);

    List<Campeonato> obtenerCampeonatosFuturos();

}
