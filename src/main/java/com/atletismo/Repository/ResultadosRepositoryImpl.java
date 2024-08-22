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
	public void insertar(Resultado resultados) {
		// TODO Auto-generated method stub
		this.entityManager.persist(resultados);
	}

	@Override
	public void actualizar(Resultado resultados) {
		// TODO Auto-generated method stub
		this.entityManager.merge(resultados);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarId(id));
	}

}
