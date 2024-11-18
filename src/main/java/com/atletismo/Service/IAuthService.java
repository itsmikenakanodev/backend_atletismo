package com.atletismo.Service;


import com.atletismo.Repository.Modelo.AuthResponse;
import com.atletismo.Repository.Modelo.LoginRequest;
import com.atletismo.Repository.Modelo.RegistroRequest;

public interface IAuthService {

    AuthResponse loginUsuario(LoginRequest loginRequest);
    Integer registroUsuarioAtleta(RegistroRequest registroRequest);
    Boolean cambiarContrasenia(String correoElectronico, String nuveaContrasenia);

    /**
     * Método específico para el login de administradores en la aplicación móvil Android.
     * Solo permite acceso a usuarios con roles de administrador (ID 1 o 6).
     * 
     * @param loginRequest Objeto que contiene las credenciales (email y password)
     * @return AuthResponse con datos básicos del administrador si el login es exitoso
     * @throws RuntimeException si el usuario no tiene permisos de administrador
     */
    AuthResponse loginAdmin(LoginRequest loginRequest);

}
