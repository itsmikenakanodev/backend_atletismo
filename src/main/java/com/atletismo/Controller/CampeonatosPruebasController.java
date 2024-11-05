package com.atletismo.Controller;

import com.atletismo.Repository.Modelo.CampeonatoPrueba;
import com.atletismo.Service.ICampeonatosPruebasService;
import com.atletismo.Service.dto.CampeonatoPruebaDTO;
import com.atletismo.Service.dto.CampeonatosPruebasDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(path = "/campeonatosPruebas")
public class CampeonatosPruebasController {

    @Autowired
    private ICampeonatosPruebasService campeonatosPruebasService;

    // POST
    @PostMapping(consumes = "application/json")
    public boolean insertar(@RequestBody CampeonatoPruebaDTO campeonatoPruebaDto) {
        CampeonatoPrueba campeonatoPrueba = new CampeonatoPrueba();
        campeonatoPrueba.setCampeonato(campeonatoPruebaDto.getCampeonato());
        campeonatoPrueba.setPrueba(campeonatoPruebaDto.getPrueba());
        return this.campeonatosPruebasService.insertar(campeonatoPrueba);
    }

    // GET
    @GetMapping(path = "/{id}", produces = "application/json")
    public CampeonatosPruebasDTO buscarPorId(@PathVariable Integer id) {
        CampeonatosPruebasDTO dto = this.campeonatosPruebasService.buscarPorIdDto(id);
       // dto.add(linkTo(methodOn(CampeonatosController.class).consultarCampeonatosIdDto(dto.getCampeonatoId())).withRel("campeonato"));
        //dto.add(linkTo(methodOn(PruebasController.class).consultarPrueba(dto.getPruebaId())).withRel("prueba"));
        return dto;
    }

    // PUT
    @PutMapping(path = "/{id}", consumes = "application/json")
    public Boolean actualizar(@RequestBody CampeonatoPrueba campeonatosPruebas, @PathVariable Integer id) {
        campeonatosPruebas.setId(id);
        return this.campeonatosPruebasService.actualizar(campeonatosPruebas);
    }

    // DELETE
    @DeleteMapping(path = "/{id}")
    public Boolean eliminar(@PathVariable Integer id) {
        return this.campeonatosPruebasService.eliminar(id);
    }

    //GETALL
    @GetMapping
    public ResponseEntity<List<CampeonatosPruebasDTO>> obtenerTodo(){
        List<CampeonatosPruebasDTO> dtos=this.campeonatosPruebasService.obtenerTodos();
        return ResponseEntity.of(Optional.ofNullable(dtos));
    }
    //Filtrar
    @GetMapping(path = "/{campeonatoId}/campeonato")
    public ResponseEntity<List<CampeonatosPruebasDTO>> filtrar(@PathVariable Integer campeonatoId)
    {
        List<CampeonatosPruebasDTO> dtos=this.campeonatosPruebasService.filtrarCampeonato(campeonatoId);
        dtos.forEach(dto -> {

           // dto.add(linkTo(methodOn(CampeonatosController.class).consultarCampeonatosIdDto(dto.getCampeonatoId())).withRel("campeonato"));
            //to.add(linkTo(methodOn(PruebasController.class).consultarPrueba(dto.getPruebaId())).withRel("prueba"));
        });

        return ResponseEntity.of(Optional.ofNullable(dtos));
    }


    @DeleteMapping("/{campeonatoId}/{pruebaId}")
    public ResponseEntity<String> eliminarCampeonatoPrueba(
            @PathVariable Integer campeonatoId,
            @PathVariable Integer pruebaId) {
        CampeonatoPrueba campeonatoPrueba = campeonatosPruebasService.findByCampeonatoIdAndPruebaId(campeonatoId, pruebaId);

        if (campeonatoPrueba != null) {
            campeonatosPruebasService.deleteByCampeonatoIdAndPruebaId(campeonatoId, pruebaId);
            return ResponseEntity.ok("Relación Campeonato-Prueba eliminada con éxito.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Relación Campeonato-Prueba no encontrada.");
        }
    }
}
