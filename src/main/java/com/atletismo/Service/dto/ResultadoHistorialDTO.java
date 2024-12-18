package com.atletismo.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultadoHistorialDTO {
    private Integer id;
    private String marca;
    private BigDecimal distancia;
    private Integer posicion;
    private Integer puntaje;
    private BigDecimal viento;
    private Boolean registrado;
    private String categoriaCompetidor;
    private Integer numeroSocio;
    private String criterioPrueba;
    private String nombrePrueba;
    private String nombreCampeonato;
} 