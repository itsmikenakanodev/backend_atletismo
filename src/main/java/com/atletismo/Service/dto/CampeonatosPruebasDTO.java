package com.atletismo.Service.dto;

import com.atletismo.Repository.Modelo.Prueba;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CampeonatosPruebasDTO extends RepresentationModel<CampeonatosPruebasDTO> {
    private Integer id;
    //private CompetidoresPruebas competidor;
    private Prueba prueba;
}
