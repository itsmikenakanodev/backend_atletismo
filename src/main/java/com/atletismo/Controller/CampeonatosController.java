package com.atletismo.Controller;

import com.atletismo.Repository.Modelo.Campeonato;
import com.atletismo.Service.ICampeonatoService;
import com.atletismo.Service.dto.CampeonatosDTO;
import com.atletismo.Service.dto.PruebasDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/campeonatos")
public class CampeonatosController {
    
    @Autowired
    private ICampeonatoService campeonatosService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insertarCampeonato(@RequestBody Campeonato campeonato) {
        try{
            return new ResponseEntity<>(this.campeonatosService.guarCampeonatos(campeonato), null, HttpStatus.OK);
        }catch(RuntimeException ex){
            return ResponseEntity.badRequest().build();
        }
        
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Campeonato>> consultarCampeonatos() {
        try{
            return new ResponseEntity<>(this.campeonatosService.listarCampeonatos(), null, HttpStatus.OK);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
       
    }

    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Campeonato> consultarCampeonatosPorId(@PathVariable Integer id) {
        Campeonato campeonato =  this.campeonatosService.buscarPorId(id);

        return new ResponseEntity<>(campeonato, null, HttpStatus.OK);
    }

    @PutMapping(path = "/")
	public ResponseEntity<Boolean> actualizarCampeonato(@RequestBody Campeonato campeonato) {
        System.out.println(campeonato);
        //return new ResponseEntity<>(this.campeonatosService.actualizarCampeonatos(campeonatos), null, HttpStatus.OK);
        boolean actualizado = this.campeonatosService.actualizarCampeonatos(campeonato);
        return ResponseEntity.status(actualizado ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(actualizado);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Boolean> eliminarCampeonatoPorId(@PathVariable Integer id) {
        try{
            int resultado = this.campeonatosService.borrarCampenatos(id);
            boolean eliminado = resultado == 1;
            return ResponseEntity.status(eliminado ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(eliminado);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }  
    }
    
    
    /////////////////////////////////////////////////
    
    @GetMapping(path = "/dto",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CampeonatosDTO>> consultarCampeonatosDto() {
        try{
            return new ResponseEntity<>(this.campeonatosService.listarCampeonatosDto(), null, HttpStatus.OK);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping(path = "/filtrar",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CampeonatosDTO>> consultarCampeonatosDtoPorFecha(@RequestParam int anio, @RequestParam int mes) {
        try{
            LocalDate fecha = LocalDate.of(anio, mes,1);
            return new ResponseEntity<>(this.campeonatosService.listarCampeonatosDto(fecha), null, HttpStatus.OK);
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping(path = "/dto/ligero",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CampeonatosDTO>> consultarCampeonatosSinPruebasDto() {
        try{
            System.out.println("*-------------EJecutando el metodo");
            return new ResponseEntity<>(this.campeonatosService.listarSoloCampeonatosDto(), null, HttpStatus.OK);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }

    }
    @GetMapping(path = "/dto/id/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CampeonatosDTO> consultarCampeonatosIdDto(@PathVariable Integer id) {
        try{
            return new ResponseEntity<>(this.campeonatosService.buscarPorIdDto(id), null, HttpStatus.OK);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping(path = "/{idCampeonato}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> agregarPruebas(@PathVariable(name = "idCampeonato")Integer idCampeonato, @RequestBody List<PruebasDTO> listaIdsPrueba){
       for (PruebasDTO pruebasDTO : listaIdsPrueba) {
        System.out.println(pruebasDTO.getId());
       }
        return ResponseEntity.status(this.campeonatosService.agregarPruebas(idCampeonato, listaIdsPrueba)?HttpStatus.OK:HttpStatus.BAD_REQUEST).build();
    }

    //////////////////////filtrado/////////////////////////

    @GetMapping(path = "/dto/{provincia}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CampeonatosDTO>> consultarCampeonatosProvinciaDto(@PathVariable String provincia) {
        try{
            return new ResponseEntity<>(this.campeonatosService.listarCampeonatosProvincia(provincia), null, HttpStatus.OK);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
       
    }

    @GetMapping(path = "/dtoid/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CampeonatosDTO> consultarCampeonatosPruebasId(@PathVariable Integer id) {
        CampeonatosDTO c=this.campeonatosService.listarCampeonatosId(id);
        return new ResponseEntity<>(c, null, HttpStatus.OK);
    }

}
