package com.atletismo.Repository;

import com.atletismo.Repository.Modelo.Resultado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ResultadosRepositoryImpl implements IResultadosRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Resultado buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Resultado.class, id);
	}

	@Override
	public Boolean insertar(Resultado resultados) {
		// TODO Auto-generated method stub
		try {
			this.entityManager.persist(resultados);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Boolean actualizar(Resultado resultados) {
		// TODO Auto-generated method stub
		try {
			this.entityManager.merge(resultados);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		try {
			this.entityManager.remove(this.buscarId(id));
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
