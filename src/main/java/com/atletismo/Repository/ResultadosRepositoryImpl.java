package com.atletismo.Repository;

import com.atletismo.Repository.Modelo.Resultado;
import com.atletismo.Service.dto.ResultadoDTO;
import com.atletismo.Service.dto.ResultadoHistorialDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ResultadosRepositoryImpl implements IResultadosRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Resultado buscarId(Integer id) {
		return this.entityManager.find(Resultado.class, id);
	}

	@Override
	public Boolean insertar(Resultado resultados) {
		try {
			this.entityManager.persist(resultados);
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	@Override
	public Boolean actualizar(Resultado resultados) {
		try {
			this.entityManager.merge(resultados);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		try {
			this.entityManager.remove(this.buscarId(id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Busca y retorna una lista de resultados para un campeonato y prueba
	 * específicos.
	 * Este método se utiliza principalmente para mostrar los resultados en la
	 * aplicación Android,
	 * permitiendo visualizar el rendimiento de los competidores en cada prueba del
	 * campeonato.
	 *
	 * @param idCampeonato el ID del campeonato del cual se quieren obtener los
	 *                     resultados
	 * @param idPrueba     el ID de la prueba específica dentro del campeonato
	 * @return Lista de ResultadoDTO con la información de los resultados,
	 *         incluyendo datos del competidor y usuario
	 */
	@Override
	public List<ResultadoDTO> buscarPorCampeonatoYPrueba(Integer idCampeonato, Integer idPrueba) {
		String jpql = "SELECT new com.atletismo.Service.dto.ResultadoDTO(" +
				"r.id, r.marca, r.distancia, r.posicion, r.puntaje, r.viento, r.registrado, " +
				"c.id, c.categoria, " +
				"u.id, u.nombres, u.apellidos, u.numeroSocio, " +
				"p.criterio) " +
				"FROM Resultado r " +
				"JOIN r.competidor c " +
				"JOIN c.usuario u " +
				"JOIN r.prueba p " +
				"WHERE r.campeonato.id = :idCampeonato " +
				"AND r.prueba.id = :idPrueba " +
				"ORDER BY r.registrado ASC";

		return this.entityManager.createQuery(jpql, ResultadoDTO.class)
				.setParameter("idCampeonato", idCampeonato)
				.setParameter("idPrueba", idPrueba)
				.getResultList();
	}

	@Override
	public List<ResultadoHistorialDTO> buscarResultadosAprobadosPorCedulaUsuario(String cedula) {
		String jpql = "SELECT new com.atletismo.Service.dto.ResultadoHistorialDTO(" +
				"r.id, r.marca, r.distancia, r.posicion, r.puntaje, r.viento, r.registrado, " +
				"c.categoria, " +
				"u.numeroSocio, " +
				"p.criterio, p.nombre, " +
				"camp.nombre) " +
				"FROM Resultado r " +
				"JOIN r.competidor c " +
				"JOIN c.usuario u " +
				"JOIN r.prueba p " +
				"JOIN r.campeonato camp " +
				"WHERE r.registrado = true AND c.estadoParticipacion = 'Confirmado' AND u.cedula = :cedula " +
				"ORDER BY p.nombre, r.id DESC";

		return this.entityManager.createQuery(jpql, ResultadoHistorialDTO.class)
				.setParameter("cedula", cedula)
				.getResultList();
	}

}
