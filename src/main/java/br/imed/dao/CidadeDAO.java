package br.imed.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.imed.model.Cidade;

public class CidadeDAO {
	
	private static Map<Long, Cidade> lista = new HashMap<Long, Cidade>();

	public Collection<Cidade> listar() {
		return lista.values();
	}

	public Cidade get(Long id) {
		return lista.get(id);
	}

	public void salvar(Cidade cidade) {
		Long id = cidade.getCodigo();
		lista.put(id, cidade);
	}

	public void deletar(Long id) {
		lista.remove(id);		
	}

}
