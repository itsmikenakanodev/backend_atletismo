package com.atletismo.Controller;

import com.atletismo.Repository.Modelo.DocumentoCampeonato;
import com.atletismo.Service.IDocumentoCampeonatoService;
import com.atletismo.Service.dto.DocumentoCampeonatoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/documentos/campeonatos")
public class DocumentoCampeonatoController {

    @Autowired
    private IDocumentoCampeonatoService documentosService;

    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DocumentoCampeonato> buscarDocumentosId(@PathVariable Integer id) {
        return new ResponseEntity<>(this.documentosService.buscarDocumentos(id),null,200);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> insertarDocumento(@RequestBody DocumentoCampeonatoDTO documento) {
        System.out.println("Insertar document: " + documento.getIdCampeonato());
        return new ResponseEntity<>(this.documentosService.insertarDocumentos(documento), null, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> actualizarDocumento(@PathVariable Integer id, @RequestBody DocumentoCampeonato documento) {
        documento.setId(id);
        boolean actualizado = this.documentosService.actualizarDocumentos(documento);
        return ResponseEntity.status(actualizado ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(actualizado);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Boolean> eliminarDocumentoPorId(@PathVariable Integer id) {
        boolean resultado = this.documentosService.eliminarDocumentos(id);
        return ResponseEntity.status(resultado ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(resultado);
    }

    @GetMapping(path = "/campeonato/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DocumentoCampeonato>> obtenerDocumentosPorCampeonato(@PathVariable Integer id) {
        try {
            List<DocumentoCampeonato> documentos = this.documentosService.obtenerDocumentosPorCampeonato(id);
            return new ResponseEntity<>(documentos, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
