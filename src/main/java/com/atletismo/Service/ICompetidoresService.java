package com.atletismo.Service;

import com.atletismo.Repository.Modelo.Competidor;
import com.atletismo.Service.dto.CompetidoresDTO;
import com.atletismo.Service.dto.CompetidoresEstadoDTO;

import java.util.List;

public interface ICompetidoresService {
    
    public Boolean insertar(Competidor competidor);
    public Integer insertarId(Competidor competidor);
	public Boolean actualizar(Competidor competidor);
	public Boolean eliminar(Integer id);
	public Competidor buscarPorId(Integer id);
	public CompetidoresDTO buscarPorIdDto(Integer id);
	List<Competidor> listarCompetidores();
	List<CompetidoresDTO> listarCompetidoresDTO();
	public Boolean actualizarEstado(Integer id, String nuevoEstado);
	public List<CompetidoresEstadoDTO> listarCompetidoresPorEstadoYCiudad(Boolean estado, String estadoParticipacion, String ciudad);


}
