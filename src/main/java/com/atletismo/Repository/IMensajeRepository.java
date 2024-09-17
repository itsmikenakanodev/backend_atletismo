package com.atletismo.Repository;

import com.atletismo.Repository.Modelo.Mensaje;
import java.util.List;

public interface IMensajeRepository {
    Boolean insertarMensaje(Mensaje mensaje);
    Boolean actualizarMensaje(Mensaje mensaje);
    Boolean eliminarMensaje(Integer id);
    Mensaje buscarMensaje(Integer id);
    List<Mensaje> buscarMensajesPorEmail(String email);
    List<Mensaje> obtenerTodosMensajes();
}
