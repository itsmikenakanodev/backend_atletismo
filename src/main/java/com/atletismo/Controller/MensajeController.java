package com.atletismo.Controller;

import com.atletismo.Service.IMensajeService;
import com.atletismo.Service.dto.MensajeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/mensajes")
public class MensajeController {

    @Autowired
    private IMensajeService mensajeService;

    @PostMapping
    public Boolean insertarMensaje(@RequestBody MensajeDTO mensajeDTO) {
        return mensajeService.insertarMensaje(mensajeDTO);
    }

    @PutMapping
    public Boolean actualizarMensaje(@RequestBody MensajeDTO mensajeDTO) {
        return mensajeService.actualizarMensaje(mensajeDTO);
    }

    @DeleteMapping("/{id}")
    public Boolean eliminarMensaje(@PathVariable Integer id) {
        return mensajeService.eliminarMensaje(id);
    }

    @GetMapping("/{id}")
    public MensajeDTO buscarMensaje(@PathVariable Integer id) {
        return mensajeService.buscarMensajeDto(id);
    }

    @GetMapping("/email/{email}")
    public List<MensajeDTO> buscarMensajesPorEmail(@PathVariable String email) {
        return mensajeService.buscarMensajesPorEmailDto(email);
    }

    @GetMapping
    public List<MensajeDTO> obtenerTodosLosMensajes() {
        return mensajeService.obtenerTodosLosMensajes();
    }
}
