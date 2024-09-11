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
    private Boolean estadoUsuario;
    private String tipo;
    private String estado;
    private String ciudad;
}
