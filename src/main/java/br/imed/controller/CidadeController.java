package br.imed.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.imed.dao.CidadeDAO;
import br.imed.model.Cidade;

@Controller
@Path("/cidade")
public class CidadeController {


	private Result result;
	private CidadeDAO dao;

	public CidadeController() {
	}

	@Inject
	public CidadeController(Result result, CidadeDAO dao) {
		this.result = result;
		this.dao = dao;
	}
	
	@Get("")
	public void listar() {
		result.include("cidades", dao.listar());
	}
	
	@Get("/adicionar")
	public void adicionar() {
		result.forwardTo(this).formulario(new Cidade());
	}
	
	@Get("/editar/{id}")
	public void editar(Long id) {
		Cidade cidade = dao.get(id);
		result.forwardTo(this).formulario(cidade);
	}
	
	public void formulario(Cidade cidade) {
		result.include("cidade", cidade);
	}

	@Post("/salvar")
	public void salvar(Cidade cidade) {
		dao.salvar(cidade);
		result.include("sucesso", true);
		result.redirectTo(this).listar();
	}
	
	@Get("/deletar/{id}")
	public void deletar(Long id) {
		dao.deletar(id);
		result.include("sucesso", true);
		result.redirectTo(this).listar();
	}
}
