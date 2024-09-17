package com.atletismo.Repository;

import com.atletismo.Repository.Modelo.DocumentoCampeonato;
import com.atletismo.Repository.Modelo.Documentos;

import java.util.List;

public interface IDocumentoCampeonatoRepository {

    public Boolean insertarDocumentos(DocumentoCampeonato documento);
    public Boolean actualizarDocumentos(DocumentoCampeonato documento);
    public Boolean eliminarDocumentos(Integer id);
    public DocumentoCampeonato buscarDocumentos(Integer id);

    // Método para obtener documentos por ID de campeonato
    List<DocumentoCampeonato> findByCampeonatoId(Integer campeonatoId);

}
