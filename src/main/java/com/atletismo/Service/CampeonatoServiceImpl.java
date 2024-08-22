package com.atletismo.Service;

import com.atletismo.Repository.ICampeonatosRepository;
import com.atletismo.Repository.IPruebasRepository;
import com.atletismo.Repository.Modelo.Campeonato;
import com.atletismo.Repository.Modelo.CampeonatoPrueba;
import com.atletismo.Service.dto.CampeonatosDTO;
import com.atletismo.Service.dto.PruebasDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CampeonatoServiceImpl implements ICampeonatoService{

    @Autowired
    private ICampeonatosRepository campeonatosRepo;

    @Autowired
    private IPruebasRepository pruebasRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean actualizarCampeonatos(Campeonato campeonato) {
        return this.campeonatosRepo.actualizarCampeonatos(campeonato);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int borrarCampenatos(Integer id) {
        return this.campeonatosRepo.borrarCampenatos(id);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Campeonato buscarPorId(Integer id) {
        return this.campeonatosRepo.buscarPorId(id);
    }

    @Override
    public CampeonatosDTO buscarPorIdDto(Integer id) {
        return this.convertToDto(this.campeonatosRepo.buscarPorId(id));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean guarCampeonatos(Campeonato campeonato) {
        return this.campeonatosRepo.guardarCampeonatos(campeonato);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<Campeonato> listarCampeonatos() {
        return this.campeonatosRepo.listarCampeonatos();
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<CampeonatosDTO> listarCampeonatosDto() {
        // TODO Auto-generated method stub
        return campeonatosRepo.listarCampeonatos().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public Boolean agregarPruebas(Integer idCampeonato, List<PruebasDTO> pruebasDTO) {
        Boolean flag = false;

        if (idCampeonato != null && !pruebasDTO.isEmpty()) {
            Campeonato campeonato = this.campeonatosRepo.buscarPorId(idCampeonato);

            List<CampeonatoPrueba> existingPruebas = campeonato.getCampeonatoPruebas();

            Set<Integer> existingPruebaIds = existingPruebas.stream()
                    .map(cp -> cp.getPrueba().getId())
                    .collect(Collectors.toSet());

            List<CampeonatoPrueba> listCamP = new ArrayList<>();
            CampeonatoPrueba campP;

            for (PruebasDTO p : pruebasDTO) {
                // Verificar si la prueba ya está asignada
                if (!existingPruebaIds.contains(p.getId())) {
                    campP = new CampeonatoPrueba();
                    campP.setCampeonato(campeonato);
                    campP.setPrueba(this.pruebasRepository.buscarPorId(p.getId()));
                    listCamP.add(campP);
                }
            }

            if (!listCamP.isEmpty()) {
                campeonato.setCampeonatoPruebas(listCamP);
                this.campeonatosRepo.actualizarCampeonatos(campeonato);
                flag = true;
            }
        }
        return flag;
    }

    private CampeonatosDTO convertToDto(Campeonato campeonato) {

        List<PruebasDTO> pruebas = campeonato.getCampeonatoPruebas().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());


        return CampeonatosDTO.builder()
                .id(campeonato.getId())
                .nombre(campeonato.getNombre())
                .organizador(campeonato.getOrganizador())
                .sede(campeonato.getSede())
                .fechaInicio(campeonato.getFechaInicio())
                .fechaFin(campeonato.getFechaFin())
                .inscripcionInicio(campeonato.getInscripcionInicio())
                .inscripcionFin(campeonato.getInscripcionFin())
                .pruebas(pruebas)
                .build();


    }

    private PruebasDTO convertToDto(CampeonatoPrueba campeonatoPruebas) {
        PruebasDTO dto = new PruebasDTO();
        //verificar
        dto.setId(campeonatoPruebas.getPrueba().getId());
        dto.setNombre(campeonatoPruebas.getPrueba().getNombre());
        dto.setDescripcion(campeonatoPruebas.getPrueba().getDescripcion());
        dto.setTipo(campeonatoPruebas.getPrueba().getTipo());
        return dto;
    }

    @Override
    public List<CampeonatosDTO> listarCampeonatosProvincia(String provincia) {
        return campeonatosRepo.listarCampeonatosProvincia(provincia).stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public CampeonatosDTO listarCampeonatosId(Integer id) {
        var a= campeonatosRepo.buscarPorId(id);
        CampeonatosDTO b=this.convertToDto(a);
        return b;
    }

    @Override
    public List<CampeonatosDTO> listarSoloCampeonatosDto() {
        return campeonatosRepo.listarCampeonatos().stream().map(this::convertToDtoSinPruebas).collect(Collectors.toList());
    }

    private CampeonatosDTO convertToDtoSinPruebas(Campeonato campeonato) {
        return CampeonatosDTO.builder()
                .id(campeonato.getId())
                .nombre(campeonato.getNombre())
                .organizador(campeonato.getOrganizador())
                .sede(campeonato.getSede())
                .fechaInicio(campeonato.getFechaInicio())
                .fechaFin(campeonato.getFechaFin())
                .inscripcionInicio(campeonato.getInscripcionInicio())
                .inscripcionFin(campeonato.getInscripcionFin())
                .build();
    }
}
