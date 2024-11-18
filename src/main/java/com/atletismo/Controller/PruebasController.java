package com.atletismo.Controller;

import com.atletismo.Service.IPruebasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.atletismo.Repository.Modelo.Prueba;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/pruebas")
public class PruebasController {

    @Autowired
    private IPruebasService pruebasService;

    @PostMapping//(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> insertarPruebas(@RequestBody Prueba pruebas){
        return new ResponseEntity<>(this.pruebasService.insertar(pruebas), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")//, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> actualizarPruebas(@PathVariable Integer id, @RequestBody Prueba pruebas){
        pruebas.setId(id);
        boolean actualizado = this.pruebasService.actualizar(pruebas);
        return ResponseEntity.status(actualizado ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(actualizado);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> eliminarPrueba(@PathVariable Integer id){
        boolean resultado = this.pruebasService.eliminar(id);
        return ResponseEntity.status(resultado ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(resultado);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Prueba> consultarPrueba(@PathVariable Integer id){
        Prueba pruebas = this.pruebasService.buscarPorId(id);
        return new ResponseEntity<>(pruebas,null,200);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Prueba>> listarPruebas(){
        List<Prueba> pruebas = this.pruebasService.buscarTodas();
        return new ResponseEntity<>(pruebas,null,200);
    }

}
