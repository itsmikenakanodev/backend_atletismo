package com.atletismo.Repository.Modelo;

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
@Table(name="user_files")
public class Documentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String nombre;

    @Column(name = "file_url")
    private String link;

    @Column(name = "extension")
    private String extension;

    @Column(name = "type")
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "usua_id")
    private Usuario usuario;

}
