package com.atletismo.Repository.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="championships")
public class Campeonato {


    @Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "champ_id_seq")
	@SequenceGenerator(name = "champ_id_seq", sequenceName = "champ_id_seq", allocationSize = 1)
	private Integer id;

    @Column(name = "name")
    private String nombre;
    @Column(name = "organizer")
	private String  organizador;
	@Column(name = "location")
	private String sede;
	@Column(name = "start_date")
	private LocalDate fechaInicio;
    @Column(name = "end_date")
    private LocalDate fechaFin;
	@Column(name = "registration_start_date")
	private LocalDate inscripcionInicio;
	@Column(name = "registration_end_date")
	private LocalDate inscripcionFin;

	@OneToMany(mappedBy = "campeonato")
	private List<CampeonatoPrueba> campeonatoPruebas;

	@OneToMany(mappedBy = "campeonato")
	private List<Competidor> competidores;

	@OneToMany(mappedBy = "campeonato")
	private List<Resultado> resultados;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getOrganizador() {
		return organizador;
	}

	public void setOrganizador(String organizador) {
		this.organizador = organizador;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public LocalDate getInscripcionInicio() {
		return inscripcionInicio;
	}

	public void setInscripcionInicio(LocalDate inscripcionInicio) {
		this.inscripcionInicio = inscripcionInicio;
	}

	public LocalDate getInscripcionFin() {
		return inscripcionFin;
	}

	public void setInscripcionFin(LocalDate inscripcionFin) {
		this.inscripcionFin = inscripcionFin;
	}

	public List<CampeonatoPrueba> getCampeonatoPruebas() {
		return campeonatoPruebas;
	}

	public void setCampeonatoPruebas(List<CampeonatoPrueba> campeonatoPruebas) {
		this.campeonatoPruebas = campeonatoPruebas;
	}

	public List<Competidor> getCompetidores() {
		return competidores;
	}

	public void setCompetidores(List<Competidor> competidores) {
		this.competidores = competidores;
	}

	public List<Resultado> getResultados() {
		return resultados;
	}

	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
	}
}
