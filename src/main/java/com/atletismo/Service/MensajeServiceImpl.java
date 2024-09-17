package com.atletismo.Service;

import com.atletismo.Repository.IMensajeRepository;
import com.atletismo.Repository.Modelo.Mensaje;
import com.atletismo.Service.dto.MensajeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class MensajeServiceImpl implements IMensajeService {

    @Autowired
    private IMensajeRepository mensajeRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean insertarMensaje(MensajeDTO mensajeDTO) {
        Mensaje mensaje = convertToEntity(mensajeDTO);
        return mensajeRepository.insertarMensaje(mensaje);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean actualizarMensaje(MensajeDTO mensajeDTO) {
        Mensaje mensaje = convertToEntity(mensajeDTO);
        return mensajeRepository.actualizarMensaje(mensaje);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean eliminarMensaje(Integer id) {
        return mensajeRepository.eliminarMensaje(id);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public MensajeDTO buscarMensajeDto(Integer id) {
        Mensaje mensaje = mensajeRepository.buscarMensaje(id);
        return convertToDTO(mensaje);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<MensajeDTO> buscarMensajesPorEmailDto(String email) {
        List<Mensaje> mensajes = mensajeRepository.buscarMensajesPorEmail(email);
        return mensajes.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<MensajeDTO> obtenerTodosLosMensajes() {
        List<Mensaje> mensajes = mensajeRepository.obtenerTodosMensajes();
        return mensajes.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private MensajeDTO convertToDTO(Mensaje mensaje) {
        if (mensaje == null) {
            return null;
        }
        MensajeDTO mensajeDTO = new MensajeDTO();
        mensajeDTO.setId(mensaje.getId());
        mensajeDTO.setEmail(mensaje.getEmail());
        mensajeDTO.setMensaje(mensaje.getMensaje());
        mensajeDTO.setFechaEnvio(mensaje.getFechaEnvio());
        return mensajeDTO;
    }

    private Mensaje convertToEntity(MensajeDTO mensajeDTO) {
        if (mensajeDTO == null) {
            return null;
        }
        Mensaje mensaje = new Mensaje();
        mensaje.setId(mensajeDTO.getId());
        mensaje.setEmail(mensajeDTO.getEmail());
        mensaje.setMensaje(mensajeDTO.getMensaje());
        mensaje.setFechaEnvio(mensajeDTO.getFechaEnvio());
        return mensaje;
    }
}
