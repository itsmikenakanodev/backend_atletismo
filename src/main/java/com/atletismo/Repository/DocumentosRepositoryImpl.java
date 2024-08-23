package com.atletismo.Repository;

import com.atletismo.Repository.Modelo.Documentos;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class DocumentosRepositoryImpl implements IDocumentosRepo {

    @PersistenceContext
    private EntityManager em;


    @Override
    public Boolean insertarDocumentos(Documentos documentos) {
        try {
            this.em.persist(documentos);
            return true;
        } catch (Exception e) {
            // Log la excepción para depurar
            e.printStackTrace();
            // Podrías relanzar la excepción si es necesario
            throw e;
        }
    }

    @Override
    public Boolean actualizarDocumentos(Documentos documentos) {
        try {
            this.em.merge(documentos);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public Boolean eliminarDocumentos(Integer id) {
        try {
            this.em.remove(em.find(Documentos.class, id));
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public Documentos buscarDocumentos(Integer id) {
        return this.em.find(Documentos.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Documentos> buscarDocumentosDeUsuarioDadoId(Integer id) {
        try {
            String sql = "SELECT d FROM Documentos d WHERE d.usuario.id = :id";
            Query myQuery = this.em.createQuery(sql);
            myQuery.setParameter("id", id);
		    return myQuery.getResultList(); 
            
        } catch (Exception e) {
            //System.out.println("ERRORR- >>>"+e);
            return null;
        }
    }


}
