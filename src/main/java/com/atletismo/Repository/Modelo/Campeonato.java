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

}
