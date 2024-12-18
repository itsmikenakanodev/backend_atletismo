package com.atletismo.Service;


import com.atletismo.Repository.IUsuariosRepository;
import com.atletismo.Repository.Modelo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService{

    @Autowired
    private IUsuariosRepository usuariosRepository;

    @Autowired
    private IEncriptionService encriptionService;


    @Override
    public AuthResponse loginUsuario(LoginRequest loginRequest) {
        Usuario usua = this.usuariosRepository.buscarPorEmail(loginRequest.getEmail());
        if(usua!=null && this.encriptionService.verificarEncriptedText(usua.getPassword(),loginRequest.getPassword())){

            if(usua.getEstadoRegistro()==true){

                return AuthResponse.builder()
                .id(usua.getId())
                .nombres(usua.getNombres())
                .apellidos(usua.getApellidos())
                .email(usua.getEmail())
                .estado(usua.getEstado())
                .estadoRegistro(usua.getEstadoRegistro())
                .fechaNacimiento(usua.getFechaNacimiento())
                .ciudad(usua.getCiudad())
                .contactoNombre(usua.getContactoNombre())
                .contactoTelefono(usua.getContactoTelefono())
                .direccion(usua.getDireccion())
                .rol(usua.getRol())
                .fechaSuscripcion(usua.getFechaSuscripción())
                .sexo(usua.getSexo())
                .telefono(usua.getTelefono())
                .build();

            }else{

                throw new RuntimeException("El registro del usuario es falso.");

            }

        }

        return null;
        //throw new RuntimeException("Usuario no encontrado o credenciales inválidas.");
    }

    @Override
    public Integer registroUsuarioAtleta(RegistroRequest registroRequest) {
        var flag=0;
        if(registroRequest.getEmail()!=null && !registroRequest.getEmail().isEmpty()
         && registroRequest.getPassword()!=null && !registroRequest.getPassword().isEmpty()){
               if(!this.usuariosRepository.existeUsuarioConEmail(registroRequest.getEmail())){
                try{
                    Rol rol=new Rol();
                    rol.setId(5);
                    Usuario usua = Usuario.builder()
                        .nombres(registroRequest.getNombres())
                        .apellidos(registroRequest.getApellidos())
                        .email(registroRequest.getEmail())
                        .password(this.encriptionService.encriptPass(registroRequest.getPassword()))
                        .estado(registroRequest.getEstado())
                        .estadoRegistro(registroRequest.getEstadoRegistro())
                        .fechaNacimiento(registroRequest.getFechaNacimiento())
                        .ciudad(registroRequest.getCiudad())
                        .contactoNombre(registroRequest.getContactoNombre())
                        .contactoTelefono(registroRequest.getContactoTelefono())
                        .direccion(registroRequest.getDireccion())
                        .rol(rol)//provisional
                        //.roles(Set.of(new Roles("Atleta",ERol.ATL)))
                        .sexo(registroRequest.getSexo())
                        .telefono(registroRequest.getTelefono())
                        .estado(registroRequest.getEstado())
                        .estadoRegistro(registroRequest.getEstadoRegistro())
                        .cedula(registroRequest.getCedula())
                    .build();
                    this.usuariosRepository.insertar(usua);
                    flag=usua.getId();
                }catch(Exception ex){
                   ex.printStackTrace();
                }
               }
        }
        return flag;
    }

    @Override
    public Boolean cambiarContrasenia(String correoElectronico, String nuevaContrasenia) {

        try {
            Usuario usuario=this.usuariosRepository.buscarPorEmail(correoElectronico);
            usuario.setPassword(this.encriptionService.encriptPass(nuevaContrasenia));
            this.usuariosRepository.actualizar(usuario);
            return true;
        }catch (Exception exception){
            return false;
        }

    }

    /**
     * Implementación del login para administradores en la app Android.
     * Valida las credenciales y el rol del usuario.
     * 
     * @param loginRequest Credenciales del usuario
     * @return AuthResponse con datos básicos si es exitoso, null si las credenciales son inválidas
     * @throws RuntimeException con mensaje "Acceso denegado" si el rol no es administrador (1 o 6)
     */
    @Override
    public AuthResponse loginAdmin(LoginRequest loginRequest) {
        Usuario usua = this.usuariosRepository.buscarPorEmail(loginRequest.getEmail());
        if(usua != null && this.encriptionService.verificarEncriptedText(usua.getPassword(), loginRequest.getPassword())) {
            // Validar que sea un usuario admin (rol 1 o 2)
            if(usua.getRol().getId() == 1 || usua.getRol().getId() == 6) {
                return AuthResponse.builder()
                    .id(usua.getId())
                    .nombres(usua.getNombres())
                    .apellidos(usua.getApellidos())
                    .email(usua.getEmail())
                    .estado(usua.getEstado())
                    .estadoRegistro(usua.getEstadoRegistro())
                    .rol(usua.getRol())
                    .build();
            } else {
                throw new RuntimeException("Acceso denegado: Se requieren permisos de administrador");
            }
        }
        return null;
    }

}
