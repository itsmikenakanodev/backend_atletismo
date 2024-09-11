package com.atletismo.Service;

import com.atletismo.Repository.Modelo.Usuario;
import com.atletismo.Repository.IUsuariosRepository;
import com.atletismo.Service.dto.UsuarioDocumentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class UsuariosServiceImpl implements IUsuariosService{

    @Autowired
    IUsuariosRepository usuariosRepository;

    @Override
    public Boolean actualizar(Usuario usuario) {
        return this.usuariosRepository.actualizar(usuario);
    }

    @Override
    public Usuario buscarPorId(Integer id) {
        return this.usuariosRepository.buscarPorId(id);
    }

    @Override
    public Boolean eliminar(Integer id) {
        return this.usuariosRepository.eliminar(id);
    }

    @Override
    public Usuario insertar(Usuario usuario) {
        return this.usuariosRepository.insertar(usuario);
    }

    @Override
    public List<Usuario> buscarTodosUsuarios() {
        return this.usuariosRepository.buscarTodosUsuarios();
    }

    @Override
    public List<Usuario> buscarTodosUsuariosAdmin() {
        return this.usuariosRepository.buscarTodosUsuariosAdmin();
    }

	@Override
	public Boolean cambioEstado(Integer id) {
        Usuario usuario= this.usuariosRepository.buscarPorId(id);
		
		usuario.setEstadoRegistro(!usuario.getEstadoRegistro());
		
		return this.usuariosRepository.actualizar(usuario);
				
	}

    public Boolean cambioEstadoSocio(Integer id) {
        Usuario usuario= this.usuariosRepository.buscarPorId(id);

        usuario.setEstado(!usuario.getEstado());
        // Agregar un año a la fecha actual
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaEnUnAno = fechaActual.plus(1, ChronoUnit.YEARS);

        // Convertir LocalDate a Date
        Date fechaSuscripcion = java.sql.Date.valueOf(fechaEnUnAno);

        usuario.setFechaSuscripción(fechaSuscripcion);

        return this.usuariosRepository.actualizar(usuario);

    }

    @Override
    public Boolean cambioEstado(Integer id, String nuevoEstado) {
        Usuario usuario= this.usuariosRepository.buscarPorId(id);
        System.out.println(Boolean.parseBoolean(nuevoEstado));
        usuario.setEstadoRegistro(Boolean.parseBoolean(nuevoEstado));
        System.out.println(usuario);
        return this.usuariosRepository.actualizar(usuario);
    }

    @Override
    public List<Usuario> listarCiudadPorEstadoReg(String provincia, Boolean estadoRegistro) {
        return this.usuariosRepository.listarCiudadPorEstadoReg(provincia, estadoRegistro);
    }


    @Override
    public List<UsuarioDocumentoDTO> listarCiudadPorTipoDocumento(Boolean estado, String tipoDoc, String provincia) {
        return this.usuariosRepository.listarCiudadPorTipoDocumento(estado, tipoDoc, provincia);
    }

    public List<Usuario> buscarUsuariosAprobadosPorApellidoOCedula(String apellido, String cedula) {
        if ((apellido == null || apellido.isEmpty()) && (cedula == null || cedula.isEmpty())) {
            throw new IllegalArgumentException("Debe proporcionar al menos un apellido o una cédula.");
        }

        return usuariosRepository.buscarUsuariosAprobadosPorApellidoOCedula(apellido, cedula);
    }


}
