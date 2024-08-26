package com.atletismo.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoCompetidorCountDTO {
    private String eventName;
    private Long maleCompetitors;
    private Long femaleCompetitors;
}
