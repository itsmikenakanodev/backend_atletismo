package com.atletismo.Controller;

import com.atletismo.Repository.Modelo.Rol;
import com.atletismo.Service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private IRolesService rolesService;

    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rol> consultarPorId(@PathVariable Integer id) {
        Rol roles =  this.rolesService.buscar(id);

        return new ResponseEntity<>(roles, null, 200);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Rol>> consultarTodos() {
        return new ResponseEntity<>(this.rolesService.buscarTodosRoles(), null, 200);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> insertarRol(@RequestBody Rol roles) {
        return new ResponseEntity<>(this.rolesService.insertarRol(roles), null, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Boolean> actualizarPorId(@RequestBody Rol roles, @PathVariable Integer id) {
        roles.setId(id);
        return new ResponseEntity<>(this.rolesService.actualizarRol(roles), null, HttpStatus.OK);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Boolean> eliminarPorId(@PathVariable Integer id) {
        return new ResponseEntity<>(this.rolesService.eliminarRol(id), null, HttpStatus.OK);

    }
}
