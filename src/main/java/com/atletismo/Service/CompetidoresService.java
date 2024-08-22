package com.atletismo.Service;

import com.atletismo.Repository.ICompetidoresRepository;
import com.atletismo.Repository.Modelo.Competidor;
import com.atletismo.Service.dto.CompetidoresDTO;
import com.atletismo.Service.dto.utils.Converter;
import com.atletismo.Service.dto.CompetidoresEstadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetidoresService implements ICompetidoresService{
    
    @Autowired
	private ICompetidoresRepository competidoresRepository;
    @Autowired
    private Converter converter;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean insertar(Competidor competidor) {
        return competidoresRepository.insertar(competidor);
    }

    @Override
    public Integer insertarId(Competidor competidor) {
        competidoresRepository.insertar(competidor);
        Integer a=competidor.getId();
        return a;
    }

    @Override
    public Boolean actualizar(Competidor competidores) {
        return competidoresRepository.actualizar(competidores);
    }

    @Override
    public Boolean eliminar(Integer id) {
        return competidoresRepository.eliminar(id);
    }

    @Override
    public Competidor buscarPorId(Integer id) {
        return competidoresRepository.buscarPorId(id);
    }

    @Override
    public CompetidoresDTO buscarPorIdDto(Integer id) {
        Competidor comp=this.buscarPorId(id);
        if(comp!=null){
            CompetidoresDTO dto=new CompetidoresDTO();
            dto.setId(comp.getId());
            dto.setFechaInscripcion(comp.getFechaInscripcion());
            dto.setCuentaBancaria(comp.getEstadoParticipacion());
            dto.setUsuarios(converter.covertToDto(comp.getUsuario()));
            return dto;
        }
        return null;
    }

    @Override
	public List<Competidor> listarCompetidores() {
		return competidoresRepository.listarCompetidores();
	}

    @Override
    public List<CompetidoresDTO> listarCompetidoresDTO() {
        List<Competidor> competidores = this.listarCompetidores();
        List<CompetidoresDTO> competidoresDTOS = competidores.stream().map(x -> converter.covertToDto(x)).collect(Collectors.toList());

        return competidoresDTOS;
    }

    @Override
    public Boolean actualizarEstado(Integer id, String nuevoEstado) {
        Competidor competidor=this.competidoresRepository.buscarPorId(id);
        competidor.setEstadoParticipacion(nuevoEstado);
        return this.competidoresRepository.actualizar(competidor);
    }

    @Override
    public List<CompetidoresEstadoDTO> listarCompetidoresPorEstadoYCiudad(Boolean estado, String estadoParticipacion, String ciudad) {
        return  this.competidoresRepository.listarCompetidoresPorEstadoYCiudad(estado,estadoParticipacion, ciudad);
    }


}
