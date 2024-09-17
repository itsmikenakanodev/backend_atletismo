package com.atletismo.Repository;

import com.atletismo.Repository.Modelo.Campeonato;
import com.atletismo.Repository.Modelo.DocumentoCampeonato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CampeonatoRepositoryImpl implements ICampeonatosRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Boolean actualizarCampeonatos(Campeonato campeonato) {
        try{
            Campeonato camp = this.buscarPorId(campeonato.getId());
            camp.setNombre(campeonato.getNombre());
            camp.setFechaFin(campeonato.getFechaFin());
            camp.setFechaInicio(campeonato.getFechaInicio());
            camp.setInscripcionInicio(campeonato.getInscripcionInicio());
            camp.setInscripcionFin(campeonato.getInscripcionFin());
            this.em.merge(camp);
            return true;
        }catch(Exception e){
            e.getMessage();
            return false;
        }

    }

    @Override
    public int borrarCampenatos(Integer id) {
        int flag = 0;
        try{
            Campeonato camp = this.em.find(Campeonato.class, id);
            this.em.remove(camp);
            flag=1;
        }catch(NoResultException exception){
            throw new NoResultException("Campeonato no encontrado para el id ingresado");
        }
        return flag;
    }

    @Override
    public Campeonato buscarPorId(Integer id) {
        Campeonato camp ;
        try{
            camp = this.em.find(Campeonato.class, id);

        }catch(NoResultException exception){
            throw new NoResultException("Campeonato no encontrado para el id ingresado");
        }
        return camp;
    }

    @Override
    public Boolean guardarCampeonatos(Campeonato campeonato) {
        try {
            this.em.persist(campeonato);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Campeonato> listarCampeonatos() {
        TypedQuery<Campeonato> myQ = this.em.createQuery("SELECT c FROM Campeonato c",Campeonato.class);
        return myQ.getResultList();
    }

    @Override
    public List<Campeonato> listarCampeonatosProvincia(String provincia) {
        TypedQuery<Campeonato> myQ = this.em.createQuery("SELECT c FROM Campeonato c WHERE c.sede = :provincia", Campeonato.class);
        myQ.setParameter("provincia", provincia);
        return myQ.getResultList();
    }
}
