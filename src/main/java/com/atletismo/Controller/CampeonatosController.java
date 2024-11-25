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

import java.time.DateTimeException;
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
            return new ResponseEntity<>(this.campeonatosService.listarCampeonatosConPruebasDto(), null, HttpStatus.OK);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping(path = "/filtrar",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CampeonatosDTO>> consultarCampeonatosDtoPorFecha(@RequestParam int anio, @RequestParam int mes) {
        try{
            LocalDate fecha = LocalDate.of(anio, mes,1);
            return new ResponseEntity<>(this.campeonatosService.listarCampeonatosConPruebasDto(fecha), null, HttpStatus.OK);
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping(path = "/dto/ligero",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CampeonatosDTO>> consultarCampeonatosSinPruebasDto(@RequestParam int anio, @RequestParam int mes) {
        try{
            LocalDate fecha = LocalDate.of(anio, mes,1);
            return new ResponseEntity<>(this.campeonatosService.listarCampeonatosSinPruebasDto(fecha), null, HttpStatus.OK);
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

    @GetMapping(path = "/campeonatos-con-pruebas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CampeonatosDTO>> listarCampeonatosConPruebasPorMes(
            @RequestParam int anio,
            @RequestParam int mes) {
        try {
            if (mes < 1 || mes > 12) {
                return ResponseEntity.badRequest().build();
            }
            
            if (anio < 2000 || anio > 2100) {
                return ResponseEntity.badRequest().build();
            }

            LocalDate fecha = LocalDate.of(anio, mes, 1);
            List<CampeonatosDTO> campeonatos = this.campeonatosService.listarCampeonatosConPruebasDto(fecha);
            return ResponseEntity.ok(campeonatos); // Retornará lista vacía si no hay resultados
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(path = "/campeonatos-sin-pruebas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CampeonatosDTO>> listarCampeonatosSinPruebasPorMes(
            @RequestParam int anio,
            @RequestParam int mes) {
        try {
            if (mes < 1 || mes > 12) {
                return ResponseEntity.badRequest().build();
            }
            
            if (anio < 2000 || anio > 2100) {
                return ResponseEntity.badRequest().build();
            }

            LocalDate fecha = LocalDate.of(anio, mes, 1);
            List<CampeonatosDTO> campeonatos = this.campeonatosService.listarCampeonatosSinPruebasDto(fecha);
            return ResponseEntity.ok(campeonatos); // Retornará lista vacía si no hay resultados
            
        } catch (DateTimeException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
