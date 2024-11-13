package com.atletismo.Repository.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Duration;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="competitor_results")
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "result_time")
    private Duration marca;

    @Column(name = "result_distance")
    private BigDecimal distancia;

    @Column(name = "result_position")
    private Integer posicion;

    @Column(name = "result_points")
    private Integer puntaje;

    @Column(name = "attempt")
    private Integer intento;

    @ManyToOne
    @JoinColumn(name = "competitor_id")
    private Competidor competidor;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Prueba prueba;

    @ManyToOne
    @JoinColumn(name = "championship_id")
    private Campeonato campeonato;

}
