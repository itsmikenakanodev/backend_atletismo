package com.atletismo.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PruebasDTO {
	
	private Integer id;
    private String nombre;
    private Integer intentos;
    private String tipo;
    private String descripcion;
    private String categoria;
    
}
