package com.atletismo.Controller;

import com.atletismo.Repository.Modelo.Competidor;
import com.atletismo.Service.ICompetidoresService;
import com.atletismo.Service.dto.CompetidoresDTO;
import com.atletismo.Service.dto.CompetidoresEstadoDTO;
import com.atletismo.Service.dto.ConsultaTipoDocDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/competidores")
public class CompetidoresController {
	
	@Autowired
	private ICompetidoresService competidoresService;
	
	
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> insertarCompetidor(@RequestBody Competidor competidor) {
        return new ResponseEntity<>(this.competidoresService.insertar(competidor), null, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "/id")
    public ResponseEntity<Integer> insertarCompetidorId(@RequestBody Competidor competidor) {
        return new ResponseEntity<>(this.competidoresService.insertarId(competidor), null, HttpStatus.OK);
    }
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> actualizarCompetidor(@PathVariable Integer id, @RequestBody Competidor Competidor) {
        Competidor.setId(id);
        boolean actualizado = this.competidoresService.actualizar(Competidor);
        return ResponseEntity.status(actualizado ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(actualizado);
    }

    //---------------------------
    @PutMapping(path = "/cambiarEstado/{id}")
    public ResponseEntity<Boolean> actualizarCompetidorEstado(@PathVariable Integer id, @RequestParam String nuevoEstado) {
        boolean actualizado = this.competidoresService.actualizarEstado(id, nuevoEstado);
        return ResponseEntity.status(actualizado ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(actualizado);
    }

    @PostMapping(path = "/tipoCompetidor",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CompetidoresEstadoDTO>> listarCompetidores(@RequestBody ConsultaTipoDocDTO tipo){

        return new ResponseEntity<>(this.competidoresService.listarCompetidoresPorEstadoYCiudad(tipo.getTipo(), tipo.getCiudad()),null,HttpStatus.OK);
    }

    
    
    @DeleteMapping(path="/{id}")
    public ResponseEntity<Boolean> eliminarCompetidorPorId(@PathVariable Integer id) {
        boolean resultado = this.competidoresService.eliminar(id);
        return ResponseEntity.status(resultado ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(resultado);
    }
    
    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompetidoresDTO> consultarCompetidorPorId(@PathVariable Integer id) {
        CompetidoresDTO competidor =  this.competidoresService.buscarPorIdDto(id);

        return new ResponseEntity<>(competidor, null, 200);
    }

    
   @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Competidor>> consultarCampeonatos() {
       return new ResponseEntity<>(this.competidoresService.listarCompetidores(), null, 200);
    }
    

}
