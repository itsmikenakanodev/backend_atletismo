package com.atletismo.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetidorDetalleDTO {

    private String nombreEvento;
    private String nombres;
    private String apellidos;
    private String provincia;
    private Character sexo;
    private String categoria;
    private boolean esMiembro;
}
