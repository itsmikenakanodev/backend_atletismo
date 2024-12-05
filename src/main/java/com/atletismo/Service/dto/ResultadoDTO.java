package com.atletismo.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultadoDTO {
    private Integer id;
    private String marca;
    private BigDecimal distancia;
    private Integer posicion;
    private Integer puntaje;
    private BigDecimal viento;
    private Boolean registrado;
    private Integer competidorId;
    private String categoria;
    private Integer usuarioId;
    private String nombres;
    private String apellidos;
    private Integer numeroSocio;
    private String criterio;
} 