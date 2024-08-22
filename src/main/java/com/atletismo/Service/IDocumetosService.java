package com.atletismo.Service;

import com.atletismo.Repository.Modelo.Documentos;

import java.util.List;

public interface IDocumetosService {

    public Boolean insertarDocumentos(Documentos documentos);
    public Boolean actualizarDocumentos(Documentos documentos);
    public Boolean eliminarDocumentos(Integer id);
    public Documentos buscarDocumentos(Integer id);

    public List<Documentos> buscarDocumentosDeUsuarioDadoId(Integer id);


}
