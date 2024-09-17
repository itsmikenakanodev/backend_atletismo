package com.atletismo.Service;

import com.atletismo.Repository.IDocumentoCampeonatoRepository;
import com.atletismo.Repository.Modelo.Campeonato;
import com.atletismo.Repository.Modelo.DocumentoCampeonato;
import com.atletismo.Service.dto.DocumentoCampeonatoDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoCampeonatoServiceImpl implements IDocumentoCampeonatoService{

    @Autowired
    private IDocumentoCampeonatoRepository documentoCampeonatoRepository;

    @Override
    public Boolean insertarDocumentos(DocumentoCampeonatoDTO documento) {
        return this.documentoCampeonatoRepository.insertarDocumentos(this.convertirDto(documento));
    }

    @Override
    public Boolean actualizarDocumentos(DocumentoCampeonato documento) {
        return this.documentoCampeonatoRepository.actualizarDocumentos(documento);
    }

    @Override
    public Boolean eliminarDocumentos(Integer id) {
        return this.documentoCampeonatoRepository.eliminarDocumentos(id);
    }

    @Override
    public DocumentoCampeonato buscarDocumentos(Integer id) {
        return this.documentoCampeonatoRepository.buscarDocumentos(id);
    }

    private DocumentoCampeonato convertirDto(DocumentoCampeonatoDTO dto) {
        Campeonato campeonato = Campeonato.builder()
                .id(dto.getIdCampeonato())
                .build();
        DocumentoCampeonato documento = DocumentoCampeonato.builder()
                .nombre(dto.getNombre())
                .link(dto.getLink())
                .extension(dto.getExtension())
                .campeonato(campeonato)
                .build();
        return documento;

    }

    @Override
    public List<DocumentoCampeonato> obtenerDocumentosPorCampeonato(Integer id) {
        return this.documentoCampeonatoRepository.findByCampeonatoId(id);
    }
}
