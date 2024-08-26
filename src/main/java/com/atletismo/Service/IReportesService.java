package com.atletismo.Service;

import com.atletismo.Service.dto.CampeonatoCompetidorCountDTO;
import com.atletismo.Service.dto.CompetidorDetalleDTO;
import com.atletismo.Service.dto.EventoCompetidorCountDTO;

import java.util.List;

public interface IReportesService {

    CampeonatoCompetidorCountDTO contarCompetidoresPorCampeonato(Integer idCampeonato);
    List<EventoCompetidorCountDTO> contarCompetidoresPorEvento(Integer idCampeonato);
    List<CompetidorDetalleDTO> obtenerDetalleCompetidoresPorCampeonato(Integer idCampeonato);
}
