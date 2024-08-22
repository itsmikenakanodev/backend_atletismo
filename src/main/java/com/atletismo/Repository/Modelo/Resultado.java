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
    private Integer puntos;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Duration getMarca() {
        return marca;
    }

    public void setMarca(Duration marca) {
        this.marca = marca;
    }

    public BigDecimal getDistancia() {
        return distancia;
    }

    public void setDistancia(BigDecimal distancia) {
        this.distancia = distancia;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Integer getIntento() {
        return intento;
    }

    public void setIntento(Integer intento) {
        this.intento = intento;
    }

    public Competidor getCompetidor() {
        return competidor;
    }

    public void setCompetidor(Competidor competidor) {
        this.competidor = competidor;
    }

    public Prueba getPrueba() {
        return prueba;
    }

    public void setPrueba(Prueba prueba) {
        this.prueba = prueba;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }
}
