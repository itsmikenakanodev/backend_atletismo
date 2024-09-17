package com.atletismo.Service;

import com.atletismo.Repository.Modelo.DocumentoCampeonato;
import com.atletismo.Repository.Modelo.Documentos;
import com.atletismo.Service.dto.DocumentoCampeonatoDTO;

import java.util.List;

public interface IDocumentoCampeonatoService {

    public Boolean insertarDocumentos(DocumentoCampeonatoDTO documento);
    public Boolean actualizarDocumentos(DocumentoCampeonato documento);
    public Boolean eliminarDocumentos(Integer id);
    public DocumentoCampeonato buscarDocumentos(Integer id);
    List<DocumentoCampeonato> obtenerDocumentosPorCampeonato(Integer id);

}
