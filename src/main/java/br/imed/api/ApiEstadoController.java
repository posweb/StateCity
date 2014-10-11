package br.imed.api;

import java.util.Collection;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.imed.dao.EstadoDAO;
import br.imed.model.Estado;

@Controller
@Path("/api/estado")
public class ApiEstadoController {

	private static final int NAO_ENCONTRADO = 404;
	private static final int SUCESSO = 200;
	private static final String XML_FORMAT = "xml";
	private static final String JSON_FORMAT = "json";

	@Inject
	private Result result;
	@Inject
	private EstadoDAO dao;

	@Put("")
	@Consumes({ "application/json", "application/xml" })
	public void adicionar(Estado estado) {
		dao.salvar(estado);
		retornarSucesso();
	}

	@Post("/{id}.{formato}")
	@Consumes({ "application/json", "application/xml" })
	public void editar(Long id, String formato, Estado estado) {
		Estado estadoEncontrado = dao.get(id);
		if(estadoEncontrado == null){
			retornaEstadoNaoEncontrado();
		}
			
		dao.salvar(estado);
		buscarPorId(id, formato);
	}

	@Delete("/{id}")
	public void deletar(Long id) {
		dao.deletar(id);
		retornarSucesso();
	}
	
	@Get("/lista.{formato}")
	public void buscarTodos(String formato){
		Collection<Estado> estados = dao.listar();
		switch (formato) {
		case JSON_FORMAT:
			result.use(Results.json()).from(estados).serialize();
			break;
		case XML_FORMAT:
			result.use(Results.xml()).from(estados).serialize();
			break;

		default:
			break;
		}
		retornarSucesso();
	}
	
	@Get("/{id}.{formato}")
	public void buscarPorId(Long id, String formato) {
		if(dao.get(id) == null){
			retornaEstadoNaoEncontrado();
			return;
		}
		retornEstado(id, formato);
		retornarSucesso();
	}

	private void retornEstado(Long id, String formato) {
		switch (formato) {
		case JSON_FORMAT:
			result.use(Results.json()).from(dao.get(id)).serialize();
			break;
		case XML_FORMAT:
			result.use(Results.xml()).from(dao.get(id)).serialize();
			break;

		default:
			break;
		}
	}

	private void retornarSucesso() {
		result.use(Results.http()).setStatusCode(SUCESSO);
	}
	
	private void retornaEstadoNaoEncontrado() {
		result.use(Results.http()).setStatusCode(NAO_ENCONTRADO);
	}
}