package com.atletismo.Repository.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="events")
public class Prueba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String nombre;

    @Column(name = "type")
    private String tipo;

    @Column(name = "description")
    private String descripcion;

    @Column(name = "criterion")
    private String criterio;

    @OneToMany(mappedBy = "prueba")
    @JsonIgnore
    private List<CampeonatoPrueba> campeonatoPruebas;

    @OneToMany(mappedBy = "prueba")
    @JsonIgnore
    private List<Resultado> resultados;

}
