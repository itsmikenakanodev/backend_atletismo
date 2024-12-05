package com.atletismo.Repository.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
    private String marca;

    @Column(name = "result_distance")
    private BigDecimal distancia;

    @Column(name = "result_position")
    private Integer posicion;

    @Column(name = "result_points")
    private Integer puntaje;

    @Column(name = "attempt")
    private Integer intento;

    @Column(name = "wind")
    private BigDecimal viento;
    
    @Column(name = "registered")
    private Boolean registrado;

    @ManyToOne
    @JoinColumn(name = "competitor_id")
    private Competidor competidor;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Prueba prueba;

    @ManyToOne
    @JoinColumn(name = "championship_id")
    private Campeonato campeonato;

    public Resultado(Integer id, String marca, BigDecimal distancia, 
                    Integer posicion, Integer puntaje, Integer intento,
                    Competidor competidor) {
        this.id = id;
        this.marca = marca;
        this.distancia = distancia;
        this.posicion = posicion;
        this.puntaje = puntaje;
        this.intento = intento;
        this.competidor = competidor;
    }

}
