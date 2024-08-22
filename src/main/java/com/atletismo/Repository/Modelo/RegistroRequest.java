package com.atletismo.Repository.Modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistroRequest implements Serializable{

    private static final long serialVersionUID =1L;

    private String nombres;
    private String apellidos;
    private String direccion;
    private String ciudad;
    private String email;
    private String telefono;
    private String contactoNombre;
    private String contactoTelefono;
    private String password;
    private Date fechaNacimiento;
    private Character sexo;
    private Boolean estado;
    private Boolean estadoRegistro;

}
