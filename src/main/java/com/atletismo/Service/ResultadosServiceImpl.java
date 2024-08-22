package com.atletismo.Service;

import com.atletismo.Repository.IResultadosRepository;
import com.atletismo.Repository.Modelo.Resultado;
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
	public void insertarResultado(Resultado resultados) {
		// TODO Auto-generated method stub
		this.resultadosRepository.insertar(resultados);
	}

	@Override
	public void actualizarResultado(Resultado resultados) {
		// TODO Auto-generated method stub
		this.resultadosRepository.actualizar(resultados);
	}

	@Override
	public void eliminarResultado(Integer id) {
		// TODO Auto-generated method stub
		this.resultadosRepository.eliminar(id);
	}

}
