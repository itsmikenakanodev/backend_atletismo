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

    @OneToMany(mappedBy = "prueba")
    private List<CampeonatoPrueba> campeonatoPruebas;

    @OneToMany(mappedBy = "prueba")
    private List<Resultado> resultados;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<CampeonatoPrueba> getCampeonatoPruebas() {
        return campeonatoPruebas;
    }

    public void setCampeonatoPruebas(List<CampeonatoPrueba> campeonatoPruebas) {
        this.campeonatoPruebas = campeonatoPruebas;
    }

    public List<Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }
}
