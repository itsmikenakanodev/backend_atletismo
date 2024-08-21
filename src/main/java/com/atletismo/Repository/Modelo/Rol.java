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
@Table(name="roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description",nullable = false)
    private String descripcion;

    @Column(name = "name",nullable = false)
    private String codigo;

    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuarios;
}
