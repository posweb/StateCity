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
import br.imed.dao.CidadeDAO;
import br.imed.model.Cidade;

@Controller
@Path("/api/cidade")
public class ApiCidadeController {

	private static final int NAO_ENCONTRADO = 404;
	private static final int SUCESSO = 200;
	private static final String XML_FORMAT = "xml";
	private static final String JSON_FORMAT = "json";

	@Inject
	private Result result;
	@Inject
	private CidadeDAO dao;

	@Put("")
	@Consumes({ "application/json", "application/xml" })
	public void adicionar(Cidade cidade) {
		dao.salvar(cidade);
		retornarSucesso();
	}

	@Post("/{id}.{formato}")
	@Consumes({ "application/json", "application/xml" })
	public void editar(Long id, String formato, Cidade cidade) {
		Cidade cidadeEncontrado = dao.get(id);
		if(cidadeEncontrado == null){
			retornaCidadeNaoEncontrado();
		}
			
		dao.salvar(cidade);
		buscarPorId(id, formato);
	}

	@Delete("/{id}")
	public void deletar(Long id) {
		dao.deletar(id);
		retornarSucesso();
	}
	
	@Get("/lista.{formato}")
	public void buscarTodos(String formato){
		Collection<Cidade> cidades = dao.listar();
		switch (formato) {
		case JSON_FORMAT:
			result.use(Results.json()).from(cidades).serialize();
			break;
		case XML_FORMAT:
			result.use(Results.xml()).from(cidades).serialize();
			break;

		default:
			break;
		}
		retornarSucesso();
	}
	
	@Get("/{id}.{formato}")
	public void buscarPorId(Long id, String formato) {
		if(dao.get(id) == null){
			retornaCidadeNaoEncontrado();
			return;
		}
		retornCidade(id, formato);
		retornarSucesso();
	}

	private void retornCidade(Long id, String formato) {
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
	
	private void retornaCidadeNaoEncontrado() {
		result.use(Results.http()).setStatusCode(NAO_ENCONTRADO);
	}
}