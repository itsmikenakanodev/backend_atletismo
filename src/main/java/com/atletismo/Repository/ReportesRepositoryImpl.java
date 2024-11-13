package com.atletismo.Repository;

import com.atletismo.Service.dto.CampeonatoCompetidorCountDTO;
import com.atletismo.Service.dto.CompetidorDetalleDTO;
import com.atletismo.Service.dto.EventoCompetidorCountDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ReportesRepositoryImpl implements IReportesRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CampeonatoCompetidorCountDTO contarCompetidoresPorCampeonato(Integer idCampeonato) {
        String sql = "SELECT new com.atletismo.Service.dto.CampeonatoCompetidorCountDTO(" +
                "c.nombre, " +
                "SUM(CASE WHEN u.sexo = 'M' AND comp.estadoParticipacion = 'Confirmado' THEN 1 ELSE 0 END), " +
                "SUM(CASE WHEN u.sexo = 'F' AND comp.estadoParticipacion = 'Confirmado' THEN 1 ELSE 0 END)) " +
                "FROM Campeonato c " +
                "JOIN Competidor comp ON comp.campeonato.id = c.id " +
                "JOIN Usuario u ON comp.usuario.id = u.id " +
                "WHERE c.id= :campeonatoId " +
                "GROUP BY c.nombre " +
                "ORDER BY c.nombre";

        TypedQuery<CampeonatoCompetidorCountDTO> query = entityManager.createQuery(sql, CampeonatoCompetidorCountDTO.class);
        query.setParameter("campeonatoId", idCampeonato);
        return query.getSingleResult();
    }

    @Override
    public List<EventoCompetidorCountDTO> contarCompetidoresPorEvento(Integer idCampeonato) {
        String sql = "SELECT new com.atletismo.Service.dto.EventoCompetidorCountDTO(" +
                "e.nombre, " +
                "COUNT(DISTINCT CASE WHEN u.sexo = 'M' AND comp.estadoParticipacion = 'Confirmado' THEN comp.id ELSE NULL END), " +
                "COUNT(DISTINCT CASE WHEN u.sexo = 'F' AND comp.estadoParticipacion = 'Confirmado' THEN comp.id ELSE NULL END)) " +
                "FROM Campeonato c " +
                "JOIN CampeonatoPrueba cp ON cp.campeonato.id = c.id "+
                "JOIN Prueba e ON cp.prueba.id = e.id "+
                "LEFT JOIN Resultado cr ON cr.prueba.id = e.id "+
                "LEFT JOIN Competidor comp ON comp.id = cr.competidor.id "+
                "LEFT JOIN Usuario u ON comp.usuario.id = u.id "+
                "WHERE c.id = :campeonatoId "+
                "GROUP BY c.nombre, e.nombre " +
                "ORDER BY c.nombre, e.nombre";

        TypedQuery<EventoCompetidorCountDTO> query = entityManager.createQuery(sql, EventoCompetidorCountDTO.class);
        query.setParameter("campeonatoId", idCampeonato);
        return query.getResultList();
    }

    @Override
    public List<CompetidorDetalleDTO> obtenerDetalleCompetidoresPorCampeonato(Integer idCampeonato) {
        String sql = "SELECT new com.atletismo.Service.dto.CompetidorDetalleDTO(" +
                "e.nombre, " +
                "u.nombres, " +
                "u.apellidos, " +
                "u.ciudad, " +
                "u.sexo, " +
                "comp.categoria, " +
                "u.numeroSocio, " +
                "cr.marca, " +
                "cr.distancia, " +
                "cr.posicion, " +
                "cr.puntaje) " +
                "FROM Campeonato c " +
                "JOIN Competidor comp ON c.id = comp.campeonato.id " +
                "JOIN Usuario u ON comp.usuario.id = u.id " +
                "JOIN Resultado cr ON comp.id = cr.competidor.id " +
                "JOIN Prueba e ON cr.prueba.id = e.id " +
                "WHERE comp.estadoParticipacion = 'Confirmado' AND c.id = :idCampeonato " +
                "ORDER BY e.nombre, u.sexo, comp.categoria";

        TypedQuery<CompetidorDetalleDTO> query = entityManager.createQuery(sql, CompetidorDetalleDTO.class);
        query.setParameter("idCampeonato", idCampeonato);
        return query.getResultList();
    }
}
