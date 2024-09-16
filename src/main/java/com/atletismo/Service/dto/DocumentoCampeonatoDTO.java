package com.atletismo.Service.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentoCampeonatoDTO {

    private String nombre;

    private String link;

    private String extension;

    private String tipo;

    private Integer idCampeonato;

}
