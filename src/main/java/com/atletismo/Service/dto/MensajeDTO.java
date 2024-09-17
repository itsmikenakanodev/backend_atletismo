package com.atletismo.Service.dto;

import lombok.Data;

@Data
public class MensajeDTO {
    private Integer id;
    private String email;
    private String mensaje;
    private String fechaEnvio;
}
