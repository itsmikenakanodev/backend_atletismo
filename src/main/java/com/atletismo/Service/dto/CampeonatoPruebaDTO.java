package com.atletismo.Service.dto;

import com.atletismo.Repository.Modelo.Campeonato;
import com.atletismo.Repository.Modelo.Prueba;
import lombok.Data;

@Data
public class CampeonatoPruebaDTO {

    private Campeonato campeonato;

    private Prueba prueba;

}
