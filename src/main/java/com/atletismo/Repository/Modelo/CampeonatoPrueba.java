package com.atletismo.Repository.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="championship_events")
public class CampeonatoPrueba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "championship_id")
    @JsonIgnore
    private Campeonato campeonato;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Prueba prueba;

}
