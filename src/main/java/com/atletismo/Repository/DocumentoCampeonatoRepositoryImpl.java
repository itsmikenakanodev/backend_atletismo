package com.atletismo.Repository;

import com.atletismo.Repository.Modelo.DocumentoCampeonato;
import com.atletismo.Repository.Modelo.Documentos;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class DocumentoCampeonatoRepositoryImpl implements IDocumentoCampeonatoRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Boolean insertarDocumentos(DocumentoCampeonato documento) {
        try {
            this.em.persist(documento);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Boolean actualizarDocumentos(DocumentoCampeonato documento) {
        try {
            this.em.merge(documento);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean eliminarDocumentos(Integer id) {
        try {
            this.em.remove(em.find(DocumentoCampeonato.class, id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public DocumentoCampeonato buscarDocumentos(Integer id) {
        return this.em.find(DocumentoCampeonato.class, id);
    }
}
