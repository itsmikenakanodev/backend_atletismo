package com.atletismo.Repository;

import com.atletismo.Service.dto.CampeonatoCompetidorCountDTO;
import com.atletismo.Service.dto.EventoCompetidorCountDTO;

import java.util.List;

public interface IReportesRepository {

    CampeonatoCompetidorCountDTO contarCompetidoresPorCampeonato(Integer idCampeonato);
    List<EventoCompetidorCountDTO> contarCompetidoresPorEvento(Integer idCampeonato);
}
