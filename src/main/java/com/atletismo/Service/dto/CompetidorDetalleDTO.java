package com.atletismo.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetidorDetalleDTO {

    private String nombreEvento;
    private String criterio;
    private String nombres;
    private String apellidos;
    private String provincia;
    private Character sexo;
    private String categoria;
    private Integer numeroCompetidor;
    private String marca;
    private BigDecimal distancia;
    private Integer posicion;
    private Integer puntaje;
    private BigDecimal viento;
}
