package com.atletismo.Repository;

import com.atletismo.Repository.Modelo.Rol;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class RolesRepositoryImpl implements IRolesRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Boolean insertarRol(Rol rol) {

        try {
            this.em.persist(rol);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean actualizarRol(Rol rol) {
        try {
            this.em.merge(rol);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean eliminarRol(Integer id) {
        try {
            this.em.remove(em.find(Rol.class, id));
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public Rol buscarRol(Integer id) {

        return this.em.find(Rol.class, id);

    }

    @Override
    public List<Rol> buscarTodosRoles() {
        try {
            TypedQuery<Rol> myQuery = this.em.createQuery("SELECT r FROM Rol r ",
                    Rol.class);
            return myQuery.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
