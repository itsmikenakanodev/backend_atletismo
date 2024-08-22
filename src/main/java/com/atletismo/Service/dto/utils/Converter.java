package com.atletismo.Service.dto.utils;

import com.atletismo.Repository.Modelo.Campeonato;
import com.atletismo.Repository.Modelo.CampeonatoPrueba;
import com.atletismo.Repository.Modelo.Competidor;
import com.atletismo.Repository.Modelo.Usuario;
import com.atletismo.Service.dto.CampeonatosDTO;
import com.atletismo.Service.dto.CampeonatosPruebasDTO;
import com.atletismo.Service.dto.CompetidoresDTO;
import com.atletismo.Service.dto.PruebasDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Converter {

    public CampeonatosDTO convertToDto(Campeonato campeonato) {

        List<PruebasDTO> pruebas = campeonato.getCampeonatoPruebas().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());


        return CampeonatosDTO.builder()
                .id(campeonato.getId())
                .nombre(campeonato.getNombre())
                .organizador(campeonato.getOrganizador())
                .sede(campeonato.getSede())
                .fechaInicio(campeonato.getFechaInicio())
                .inscripcionInicio(campeonato.getInscripcionInicio())
                .inscripcionFin(campeonato.getInscripcionFin())
                .pruebas(pruebas)
                .build();


    }

    public PruebasDTO convertToDto(CampeonatoPrueba campeonatosPruebas) {
        PruebasDTO dto = new PruebasDTO();
        dto.setId(campeonatosPruebas.getPrueba().getId());
        dto.setNombre(campeonatosPruebas.getPrueba().getNombre());
        dto.setTipo(campeonatosPruebas.getPrueba().getTipo());
        return dto;
    }
    public CompetidoresDTO covertToDto(Competidor competidor){
        CompetidoresDTO dto=new CompetidoresDTO();
        if(competidor!=null){
            dto.setId(competidor.getId());
            //dto.setFechaInscripcion(competidor.getFechaInscripcion());
            //dto.setCuentaBancaria(competidor.getEstadoParticipacion());
            dto.setUsuarios(this.covertToDto(competidor.getUsuario()));
            //dto.setAsociacionesDeportivas(competidores.getAsociacionesDeportivas());
           // dto.setUsuarios(competidores.getUsuarios());
        }


        return dto;
    }
    public UsuarioDTO covertToDto(Usuario usuario){
        UsuarioDTO dto=new UsuarioDTO();
        if(usuario!=null){
            dto.setId(usuario.getId());
            dto.setNombres(usuario.getNombres());
            dto.setApellidos(usuario.getApellidos());
            dto.setCiudad(usuario.getCiudad());
            dto.setEmail(usuario.getEmail());
            dto.setTelefono(usuario.getTelefono());
            dto.setFechaNacimiento(usuario.getFechaNacimiento());
            dto.setSexo(usuario.getSexo());
            dto.setEstado(usuario.getEstado());
            dto.setFechaSuscripción(usuario.getFechaSuscripción());
            dto.setDocumento(usuario.getDocumentos());
        }


        return dto;
    }
    public CampeonatosPruebasDTO covertToDto(CampeonatoPrueba campeonatoPrueba){
        CampeonatosPruebasDTO dto=new CampeonatosPruebasDTO();
        if(campeonatoPrueba!=null){
            dto.setId(campeonatoPrueba.getId());
            dto.setPrueba(campeonatoPrueba.getPrueba());
            //dto.setCampeonatoId(campeonatosPruebas.getCampeonatos().getId());
            //dto.setPruebaId(campeonatosPruebas.getPruebas().getId());
        }
        return dto;
    }
}
