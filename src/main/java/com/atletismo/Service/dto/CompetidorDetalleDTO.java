package com.atletismo.Service.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Duration;

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
    private Integer numeroCompetidor;
    private Duration marca;
    private BigDecimal distancia;
    private Integer posicion;
    private Integer puntaje;
}
