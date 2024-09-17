package com.atletismo.Repository;

import com.atletismo.Repository.Modelo.Mensaje;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class MensajeRepositoryImpl implements IMensajeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Boolean insertarMensaje(Mensaje mensaje) {
        try {
            entityManager.persist(mensaje);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean actualizarMensaje(Mensaje mensaje) {
        try {
            entityManager.merge(mensaje);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean eliminarMensaje(Integer id) {
        try {
            Mensaje mensaje = entityManager.find(Mensaje.class, id);
            if (mensaje != null) {
                entityManager.remove(mensaje);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Mensaje buscarMensaje(Integer id) {
        return entityManager.find(Mensaje.class, id);
    }

    @Override
    public List<Mensaje> buscarMensajesPorEmail(String email) {
        return entityManager.createQuery("SELECT m FROM Mensaje m WHERE m.email = :email", Mensaje.class)
                .setParameter("email", email)
                .getResultList();
    }

    @Override
    public List<Mensaje> obtenerTodosMensajes() {
        return entityManager.createQuery("SELECT m FROM Mensaje m", Mensaje.class).getResultList();
    }
}
