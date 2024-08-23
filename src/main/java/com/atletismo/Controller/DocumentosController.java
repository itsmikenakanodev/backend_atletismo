package com.atletismo.Controller;


import com.atletismo.Repository.Modelo.Documentos;
import com.atletismo.Service.IDocumetosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/documentos")
public class DocumentosController {

	@Autowired
	private IDocumetosService documetosService;
	
	@GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Documentos>buscarDocumentosId(@PathVariable Integer id) {
		return new ResponseEntity<>(this.documetosService.buscarDocumentos(id),null,200);
	}
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> insertarDocumento(@RequestBody Documentos documentos) {
        return new ResponseEntity<>(this.documetosService.insertarDocumentos(documentos), null, HttpStatus.OK);
    }


	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> actualizarDocumento(@PathVariable Integer id, @RequestBody Documentos documento) {
		documento.setId(id);
		boolean actualizado = this.documetosService.actualizarDocumentos(documento);
		return ResponseEntity.status(actualizado ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(actualizado);
	}




	@DeleteMapping(path="/{id}")
    public ResponseEntity<Boolean> eliminarDocumentoPorId(@PathVariable Integer id) {
        boolean resultado = this.documetosService.eliminarDocumentos(id);
        return ResponseEntity.status(resultado ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(resultado);
    }
    
    @GetMapping(path="usuarios/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Documentos>>buscarDocumentosPorUsuarioId(@PathVariable Integer id) {
		return new ResponseEntity<>(this.documetosService.buscarDocumentosDeUsuarioDadoId(id),null,200);
	}
	
}
