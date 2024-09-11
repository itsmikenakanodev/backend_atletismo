package com.atletismo.Repository.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="competitors")
public class Competidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "inscription_date")
    private Date fechaInscripcion;

    @Column(name = "status")
    private String estadoParticipacion;

    @Column(name = "category")
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "championship_id")
    private Campeonato campeonato;

    @OneToMany(mappedBy = "competidor",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Resultado> resultados;

}
