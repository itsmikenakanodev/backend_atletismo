package com.atletismo.Service;

import com.atletismo.Repository.Modelo.Usuario;
import com.atletismo.Service.dto.UsuarioDocumentoDTO;

import java.util.List;

public interface IUsuariosService {

    public Usuario insertar(Usuario usuario);
    public Usuario buscarPorId(Integer id);
    public Boolean actualizar(Usuario usuario);
    public Boolean eliminar(Integer id);

    public List<Usuario> buscarTodosUsuarios();
    
    public List<Usuario> buscarTodosUsuariosAdmin();
    
    public Boolean cambioEstado(Integer id) ;
    public Boolean cambioEstadoSocio(Integer id);
    public Boolean cambioEstado(Integer id,String nuevoEstado) ;

    public List<Usuario> listarCiudadPorEstadoReg(String provincia,Boolean estadoRegistro);

    public List<UsuarioDocumentoDTO> listarCiudadPorTipoDocumento(Boolean estado, String tipoDoc, String provincia);

}
