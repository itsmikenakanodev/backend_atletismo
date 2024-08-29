package com.atletismo.Controller;

import com.atletismo.Service.IReportesService;
import com.atletismo.Service.dto.CampeonatoCompetidorCountDTO;
import com.atletismo.Service.dto.CompetidorDetalleDTO;
import com.atletismo.Service.dto.EventoCompetidorCountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reportes")
@CrossOrigin
public class ReportesController {

    @Autowired
    private IReportesService reportesService;

    @GetMapping("/campeonatos/{idCampeonato}")
    public ResponseEntity<CampeonatoCompetidorCountDTO> obtenerCompetidoresPorCampeonato(@PathVariable Integer idCampeonato) {
        CampeonatoCompetidorCountDTO resultado = this.reportesService.contarCompetidoresPorCampeonato(idCampeonato);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/campeonatos/{idCampeonato}/pruebas")
    public ResponseEntity<List<EventoCompetidorCountDTO>> obtenerCompetidoresPorEvento(@PathVariable Integer idCampeonato) {
        List<EventoCompetidorCountDTO> resultados = reportesService.contarCompetidoresPorEvento(idCampeonato);
        return ResponseEntity.ok(resultados);
    }

    @GetMapping("/campeonatos/{idCampeonato}/competidores-detalle")
    public List<CompetidorDetalleDTO> obtenerDetalleCompetidoresPorCampeonato(@PathVariable Integer idCampeonato) {
        return reportesService.obtenerDetalleCompetidoresPorCampeonato(idCampeonato);
    }
}
