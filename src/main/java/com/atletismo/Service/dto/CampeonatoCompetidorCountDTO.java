package com.atletismo.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampeonatoCompetidorCountDTO {

    private String championshipName;
    private Long maleCompetitors;
    private Long femaleCompetitors;
}
