package com.atletismo.Controller;

import com.atletismo.Service.dto.ResultadoDTO;
import com.atletismo.Repository.Modelo.Resultado;
import com.atletismo.Service.IResultadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/resultados")
public class ResultadosController {

    @Autowired
    private IResultadosService resultadosService;

    @PostMapping//(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> insertarResultado(@RequestBody Resultado resultado){
        return new ResponseEntity<>(this.resultadosService.insertarResultado(resultado), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")//, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> actualizarResultado(@PathVariable Integer id, @RequestBody Resultado resultado){
        resultado.setId(id);
        boolean actualizado = this.resultadosService.actualizarResultado(resultado);
        return ResponseEntity.status(actualizado ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(actualizado);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> eliminarResultado(@PathVariable Integer id){
        boolean resultado = this.resultadosService.eliminarResultado(id);
        return ResponseEntity.status(resultado ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(resultado);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resultado> consultarResultado(@PathVariable Integer id){
        Resultado resultado = this.resultadosService.buscarResultado(id);
        return new ResponseEntity<>(resultado,null,200);
    }

    @GetMapping(path = "/campeonato/{idCampeonato}/prueba/{idPrueba}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ResultadoDTO>> buscarPorCampeonatoYPrueba(
            @PathVariable Integer idCampeonato,
            @PathVariable Integer idPrueba) {
        List<ResultadoDTO> resultados = this.resultadosService.buscarPorCampeonatoYPrueba(idCampeonato, idPrueba);
        return ResponseEntity.ok(resultados);
    }

}
