package com.atletismo.Service;

import com.atletismo.Repository.IReportesRepository;
import com.atletismo.Service.dto.CampeonatoCompetidorCountDTO;
import com.atletismo.Service.dto.CompetidorDetalleDTO;
import com.atletismo.Service.dto.EventoCompetidorCountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportesServiceImpl implements IReportesService{

    @Autowired
    private IReportesRepository iReportesRepository;

    @Override
    public CampeonatoCompetidorCountDTO contarCompetidoresPorCampeonato(Integer idCampeonato) {
        return this.iReportesRepository.contarCompetidoresPorCampeonato(idCampeonato);
    }

    @Override
    public List<EventoCompetidorCountDTO> contarCompetidoresPorEvento(Integer idCampeonato) {
        return this.iReportesRepository.contarCompetidoresPorEvento(idCampeonato);
    }

    @Override
    public List<CompetidorDetalleDTO> obtenerDetalleCompetidoresPorCampeonato(Integer idCampeonato) {
        return this.iReportesRepository.obtenerDetalleCompetidoresPorCampeonato(idCampeonato);
    }

}
