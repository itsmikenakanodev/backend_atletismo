package com.atletismo.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.Duration;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultadoDTO {
    private Integer id;
    private Duration marca;
    private BigDecimal distancia;
    private Integer posicion;
    private Integer puntaje;
    private BigDecimal viento;
    private Integer competidorId;
    private String categoria;
    private Integer usuarioId;
    private String nombres;
    private String apellidos;
    private Integer numeroSocio;
} 