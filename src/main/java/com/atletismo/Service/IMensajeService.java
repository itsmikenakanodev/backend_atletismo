package com.atletismo.Service;

import com.atletismo.Service.dto.MensajeDTO;

import java.util.List;

public interface IMensajeService {

    Boolean insertarMensaje(MensajeDTO mensajeDTO);
    Boolean actualizarMensaje(MensajeDTO mensajeDTO);
    Boolean eliminarMensaje(Integer id);
    MensajeDTO buscarMensajeDto(Integer id);
    List<MensajeDTO> buscarMensajesPorEmailDto(String email);
    List<MensajeDTO> obtenerTodosLosMensajes();
}
