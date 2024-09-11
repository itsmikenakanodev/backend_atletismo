package com.atletismo.Repository;

import com.atletismo.Repository.Modelo.Competidor;
import com.atletismo.Service.dto.CompetidoresEstadoDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CompetidoresRepository implements ICompetidoresRepository{
    
    @PersistenceContext
	private EntityManager entityManager;

    @Override
    public Boolean insertar(Competidor competidor) {
        try {
            this.entityManager.persist(competidor);
            System.out.println("Insertado");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());

            System.out.println("Meko");
            return false;
        }
    }

    @Override
    public Boolean actualizar(Competidor competidor) {
        try {
            this.entityManager.merge(competidor);
			return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean eliminar(Integer id) {
        try {
            this.entityManager.remove(buscarPorId(id));
			return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Competidor buscarPorId(Integer id) {
        return this.entityManager.find(Competidor.class, id);
    }

	@Override
	public List<Competidor> listarCompetidores() {
        TypedQuery<Competidor> myQuery = this.entityManager.createQuery("SELECT c FROM Competidor c",Competidor.class);
        return myQuery.getResultList();
	}


    @Override
    public List<CompetidoresEstadoDTO> listarCompetidoresPorEstadoYCiudad(String estadoParticipacion, String ciudad) {
        try {
            String sql = "SELECT new CompetidoresEstadoDTO(c.id, c.fechaInscripcion, c.estadoParticipacion, u.id, u.nombres, u.apellidos, u.ciudad, u.email, u.telefono, u.fechaNacimiento, u.sexo, d) " +
                    "FROM Competidor c " +
                    "JOIN c.usuario u " +
                    "LEFT JOIN Documentos d ON d.usuario.id = u.id " +
                    "WHERE d.tipo = :tipoDoc AND c.estadoParticipacion = :estadoParticipacion AND u.ciudad = :ciudad";

            TypedQuery<CompetidoresEstadoDTO> query = entityManager.createQuery(sql, CompetidoresEstadoDTO.class);
            query.setParameter("estadoParticipacion", estadoParticipacion);
            query.setParameter("ciudad", ciudad);
            query.setParameter("tipoDoc", "Inscripcion");
            return query.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}
