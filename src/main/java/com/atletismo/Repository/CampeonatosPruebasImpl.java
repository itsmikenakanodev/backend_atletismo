package com.atletismo.Repository;

import com.atletismo.Repository.Modelo.CampeonatoPrueba;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CampeonatosPruebasImpl implements ICampeonatosPruebas {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Boolean insertar(CampeonatoPrueba campeonatoPrueba) {
		// TODO Auto-generated method stub
		try {
			this.entityManager.persist(campeonatoPrueba);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Boolean actualizar(CampeonatoPrueba campeonatoPrueba) {
		// TODO Auto-generated method stub
		try {
			this.entityManager.merge(campeonatoPrueba);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		try {
			this.entityManager.remove(buscarPorId(id));
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public CampeonatoPrueba buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CampeonatoPrueba.class, id);
	}

	@Override
	public List<CampeonatoPrueba> buscarPorIdCampeonatos(Integer idCampeonato) {
			// TODO Auto-generated method stub
			TypedQuery<CampeonatoPrueba> myQ = this.entityManager.createQuery("SELECT c FROM CampeonatoPrueba c WHERE c.campeonato.id = :idCampeonato", CampeonatoPrueba.class);
			myQ.setParameter("idCampeonato", idCampeonato);
			return myQ.getResultList();
	}

	@Override
	public List<CampeonatoPrueba> obtenerTodos() {
		// TODO Auto-generated method stub
		TypedQuery<CampeonatoPrueba> myQ = this.entityManager.createQuery("SELECT c FROM CampeonatoPrueba c",CampeonatoPrueba.class);
		return myQ.getResultList();
	}

	@Override
	public CampeonatoPrueba findByCampeonatoIdAndPruebaId(Integer campeonatoId, Integer pruebaId) {
		TypedQuery<CampeonatoPrueba> query = entityManager.createQuery(
				"SELECT cp FROM CampeonatoPrueba cp WHERE cp.campeonato.id = :campeonatoId AND cp.prueba.id = :pruebaId",
				CampeonatoPrueba.class
		);
		query.setParameter("campeonatoId", campeonatoId);
		query.setParameter("pruebaId", pruebaId);

		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null; // Retorna null si no se encuentra el resultado
		}
	}

	@Override
	@Transactional
	public void deleteByCampeonatoIdAndPruebaId(Integer campeonatoId, Integer pruebaId) {
		CampeonatoPrueba campeonatoPrueba = findByCampeonatoIdAndPruebaId(campeonatoId, pruebaId);
		if (campeonatoPrueba != null) {
			entityManager.remove(campeonatoPrueba);
		}
	}

}
