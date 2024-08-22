package com.atletismo.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsultaTipoDocDTO {
    private String tipo;
    private Boolean estado;
    private String ciudad;
}
