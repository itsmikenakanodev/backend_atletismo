package com.atletismo.Repository;

import com.atletismo.Repository.Modelo.Usuario;
import com.atletismo.Service.dto.UsuarioDocumentoDTO;

import java.util.List;

public interface IUsuariosRepository {

    public Usuario insertar(Usuario usuarios);
    public Usuario buscarPorId(Integer id);
    public Boolean actualizar(Usuario usuarios);
    public Boolean eliminar(Integer id);
    public List<Usuario> buscarTodosUsuarios();

    public List<Usuario> buscarTodosUsuariosAdmin();

    public Usuario buscarPorEmail(String email);

    public boolean existeUsuarioConEmail(String email) ;

    public List<Usuario> listarCiudadPorEstadoReg(String provincia,Boolean estadoRegistro);

    public List<UsuarioDocumentoDTO> listarCiudadPorTipoDocumento(Boolean estado, String tipoDoc, String provincia);

    public List<Usuario> buscarUsuariosAprobadosPorApellidoOCedula(String apellido, String cedula, int page, int size);

}
