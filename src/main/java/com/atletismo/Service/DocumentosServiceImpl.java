package com.atletismo.Service;

import com.atletismo.Repository.IDocumentosRepo;
import com.atletismo.Repository.Modelo.Documentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentosServiceImpl implements IDocumetosService {

    @Autowired
    IDocumentosRepo documentosRepo;

    @Override
    public Boolean insertarDocumentos(Documentos documentosUsuarios) {
        return this.documentosRepo.insertarDocumentos(documentosUsuarios);
    }

    @Override
    public Boolean actualizarDocumentos(Documentos documentosUsuarios) {
        return this.documentosRepo.actualizarDocumentos(documentosUsuarios);
    }

    @Override
    public Boolean eliminarDocumentos(Integer id) {
        return this.documentosRepo.eliminarDocumentos(id);
    }

    @Override
    public Documentos buscarDocumentos(Integer id) {
        return this.documentosRepo.buscarDocumentos(id);
    }

    @Override
    public List<Documentos> buscarDocumentosDeUsuarioDadoId(Integer id) {
        return this.documentosRepo.buscarDocumentosDeUsuarioDadoId(id);
    }

}
