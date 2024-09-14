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
@Table(name="championship_files")
public class DocumentoCampeonato {

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "championship_id")
    private Campeonato campeonato;

}
