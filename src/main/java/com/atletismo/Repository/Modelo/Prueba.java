package com.atletismo.Repository.Modelo;

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
@Table(name="championship_events")
public class Prueba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String nombre;

    @Column(name = "type")
    private String tipo;

    @Column(name = "description")
    private String descripcion;

    @OneToMany(mappedBy = "prueba")
    private List<CampeonatoPrueba> campeonatoPruebas;

    @OneToMany(mappedBy = "prueba")
    private List<Resultado> resultados;
}
