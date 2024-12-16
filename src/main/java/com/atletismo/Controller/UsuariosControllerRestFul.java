package com.atletismo.Controller;

import com.atletismo.Repository.Modelo.Documentos;
import com.atletismo.Repository.Modelo.Usuario;
import com.atletismo.Service.IDocumetosService;
import com.atletismo.Service.IRolesService;
import com.atletismo.Service.IUsuariosService;
import com.atletismo.Service.dto.ConsultaTipoDocDTO;
import com.atletismo.Service.dto.UsuarioDocumentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/usuarios")
public class UsuariosControllerRestFul {

    @Autowired
    private IUsuariosService usuariosService;

    @Autowired
    private IDocumetosService documentosService;
    
    @Autowired
    private IRolesService rolesService;

    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> consultarPorId(@PathVariable Integer id) {
        Usuario user =  this.usuariosService.buscarPorId(id);

        return new ResponseEntity<>(user, null, 200);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Usuario>> consultarTodos() {
        return new ResponseEntity<>(this.usuariosService.buscarTodosUsuarios(), null, 200);
    }


    @GetMapping(path="/{id}/documentos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Documentos>> consultarDocumentosPorId(@PathVariable Integer id) {

        List<Documentos> documentos = this.documentosService.buscarDocumentosDeUsuarioDadoId(id);

        return new ResponseEntity<>(documentos, null, 200);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> insertarUsuario(@RequestBody Usuario usuario) {
        var roles = this.rolesService.buscar(5);
        System.out.println(roles);
        if (usuario.getCedula() == null) {
            throw new IllegalArgumentException("Cédula no puede ser nula");
        }
       // usuario.setRoles(roles);
       // return new ResponseEntity<>(this.usuariosService.insertar(usuario), null, HttpStatus.OK);
       return null;
    }

	@PutMapping(path = "/{id}")
	public ResponseEntity<Boolean> actualizarPorId(@RequestBody Usuario usuario, @PathVariable Integer id) {
        usuario.setId(id);
        return new ResponseEntity<>(this.usuariosService.actualizar(usuario), null, HttpStatus.OK);
	}

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Boolean> eliminarPorId(@PathVariable Integer id) {
        return new ResponseEntity<>(this.usuariosService.eliminar(id), null, HttpStatus.OK);
       
    }

    @PutMapping(path = "/estado/{id}")
	public ResponseEntity<Boolean> actualizarEstado(@PathVariable Integer id) {
        return new ResponseEntity<>(this.usuariosService.cambioEstado(id), null, HttpStatus.OK);
	}
    @PutMapping(path = "/estadoSocio/{id}")
    public ResponseEntity<Boolean> actualizarEstadoSocio(@PathVariable Integer id) {
        return new ResponseEntity<>(this.usuariosService.cambioEstadoSocio(id), null, HttpStatus.OK);
    }

    @PutMapping(path = "/estado/valor/{id}")
    public ResponseEntity<Boolean> actualizarEstadoPorValor(@PathVariable Integer id,@RequestParam String valor) {
        return new ResponseEntity<>(this.usuariosService.cambioEstado(id,valor), null, HttpStatus.OK);
    }

    //metodo para filtrar los usuarios de una provincia
    @GetMapping(path = "/prov-reg/{provincia}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Usuario>> listarPorProvinciaEstadoRegTrue(@PathVariable(name="provincia")String provincia){
        return new ResponseEntity<>(this.usuariosService.listarCiudadPorEstadoReg(provincia, true),null,HttpStatus.OK);
    }

    @GetMapping(path = "/prov-noreg/{provincia}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Usuario>> listarPorProvinciaEstadoRegfalse(@PathVariable(name="provincia")String provincia){
        return new ResponseEntity<>(this.usuariosService.listarCiudadPorEstadoReg(provincia, false),null,HttpStatus.OK);
    }

    @PostMapping(path = "/tipoD",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsuarioDocumentoDTO>> listarPorProvinciaPorTipoDoc(@RequestBody ConsultaTipoDocDTO tipo){

        return new ResponseEntity<>(this.usuariosService.listarCiudadPorTipoDocumento(tipo.getEstadoUsuario(), tipo.getTipo(), tipo.getCiudad()),null,HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Usuario>> buscarUsuariosAprobados(
            @RequestParam(required = false) String apellido,
            @RequestParam(required = false) String cedula,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        if ((apellido == null || apellido.isEmpty()) && (cedula == null || cedula.isEmpty())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        List<Usuario> usuarios = this.usuariosService.buscarUsuariosAprobadosPorApellidoOCedula(apellido, cedula, page, size);
        
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        
        return ResponseEntity.ok(usuarios);
    }

    /////////////////////administradores//////////////////////
    @GetMapping(path = "/admins",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Usuario>> listarUsuariosAdmin(){
        return new ResponseEntity<>(this.usuariosService.buscarTodosUsuariosAdmin(),null,HttpStatus.OK);
    }



}
