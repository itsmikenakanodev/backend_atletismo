package com.atletismo.Service;


import com.atletismo.Repository.Modelo.AuthResponse;
import com.atletismo.Repository.Modelo.LoginRequest;
import com.atletismo.Repository.Modelo.RegistroRequest;

public interface IAuthService {

    AuthResponse loginUsuario(LoginRequest loginRequest);
    Integer registroUsuarioAtleta(RegistroRequest registroRequest);
    Boolean cambiarContrasenia(String correoElectronico, String nuveaContrasenia);

}
