package com.atletismo.Repository;

import com.atletismo.Repository.Modelo.Competidor;
import com.atletismo.Service.dto.CompetidoresEstadoDTO;
import java.util.List;

public interface ICompetidoresRepository {

    public Boolean insertar(Competidor competidor);
	public Boolean actualizar(Competidor competidor);
	public Boolean eliminar(Integer id);
	public Competidor buscarPorId(Integer id);
	
	List<Competidor> listarCompetidores();

	public List<CompetidoresEstadoDTO> listarCompetidoresPorEstadoYCiudad(String estadoParticipacion, String ciudad);
}
