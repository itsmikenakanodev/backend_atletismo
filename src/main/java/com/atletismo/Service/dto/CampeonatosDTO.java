package com.atletismo.Service.dto;


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
public class CampeonatosDTO {

	
	private Integer id;
    private String nombre;
    private String organizador;
    private String sede;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private LocalDate inscripcionInicio;
    private LocalDate inscripcionFin;
    private List<PruebasDTO> pruebas;  

}
