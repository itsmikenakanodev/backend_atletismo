package com.atletismo.Service;

import com.atletismo.Repository.IResultadosRepository;
import com.atletismo.Repository.Modelo.Resultado;
import com.atletismo.Service.dto.ResultadoDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultadosServiceImpl implements IResultadosService {
	
	@Autowired
	private IResultadosRepository resultadosRepository;

	@Override
	public Resultado buscarResultado(Integer id) {
		// TODO Auto-generated method stub
		return this.resultadosRepository.buscarId(id);
	}

	@Override
	public Boolean insertarResultado(Resultado resultados) {
		// TODO Auto-generated method stub
		return this.resultadosRepository.insertar(resultados);
	}

	@Override
	public Boolean actualizarResultado(Resultado resultados) {
		// TODO Auto-generated method stub
		return this.resultadosRepository.actualizar(resultados);
	}

	@Override
	public Boolean eliminarResultado(Integer id) {
		// TODO Auto-generated method stub
		return this.resultadosRepository.eliminar(id);
	}

	@Override
	public List<ResultadoDTO> buscarPorCampeonatoYPrueba(Integer idCampeonato, Integer idPrueba) {
		return this.resultadosRepository.buscarPorCampeonatoYPrueba(idCampeonato, idPrueba);
	}

}
