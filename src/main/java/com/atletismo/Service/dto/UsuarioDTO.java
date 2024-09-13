package com.atletismo.Service.dto;

import com.atletismo.Repository.Modelo.Documentos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTO {
    private  Integer id;
    private String nombres;
    private String apellidos;
    private String ciudad;
    private String email;
    private String telefono;
    private Date fechaNacimiento;
    private Character sexo;
    private Boolean estado;
    private Date fechaSuscripción;
    private List<Documentos> documento;
    private String cedula;

}
