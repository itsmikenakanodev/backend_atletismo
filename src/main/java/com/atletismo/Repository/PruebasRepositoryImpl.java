package com.atletismo.Repository;

import com.atletismo.Repository.Modelo.Prueba;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class PruebasRepositoryImpl implements IPruebasRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Boolean insertar(Prueba pruebas) {
        // TODO Auto-generated method stub
        try {
            this.entityManager.persist(pruebas);
            return true;
        }catch (Exception e) {
            // TODO: handle exception
            return false;
        }

    }

    @Override
    public Prueba buscarPorId(Integer id) {
        // TODO Auto-generated method stub
        return this.entityManager.find(Prueba.class, id);

    }

    @Override
    public Boolean actualizar(Prueba pruebas) {
        // TODO Auto-generated method stub
        try {
            this.entityManager.merge(pruebas);
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
            this.entityManager.remove(this.buscarPorId(id));
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    @Override
    public List<Prueba> buscarTodas() {
        TypedQuery<Prueba> myQ = this.entityManager.createQuery("SELECT p FROM Prueba p",Prueba.class);
        return myQ.getResultList();
    }
}
