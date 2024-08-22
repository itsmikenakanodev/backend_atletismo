package com.atletismo.Repository;

import com.atletismo.Repository.Modelo.CampeonatoPrueba;
import jakarta.persistence.EntityManager;
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
		}	}

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
			TypedQuery<CampeonatoPrueba> myQ = this.entityManager.createQuery("SELECT c FROM CampeonatosPruebas c WHERE c.campeonatos.id = :idCampeonato", CampeonatoPrueba.class);
			myQ.setParameter("idCampeonato", idCampeonato);
			return myQ.getResultList();
	}

	@Override
	public List<CampeonatoPrueba> obtenerTodos() {
		// TODO Auto-generated method stub
		TypedQuery<CampeonatoPrueba> myQ = this.entityManager.createQuery("SELECT c FROM CampeonatosPruebas c",CampeonatoPrueba.class);
		return myQ.getResultList();
	}

}
