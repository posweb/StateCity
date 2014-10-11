package br.imed.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.imed.model.Estado;

public class EstadoDAO {
	
	private static Map<Long, Estado> lista = new HashMap<Long, Estado>();

	public Collection<Estado> listar() {
		return lista.values();
	}

	public Estado get(Long id) {
		return lista.get(id);
	}

	public void salvar(Estado estado) {
		Long id = estado.getCodigo();
		lista.put(id, estado);
	}

	public void deletar(Long id) {
		lista.remove(id);		
	}

}
