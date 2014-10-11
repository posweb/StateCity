package br.imed.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.imed.dao.EstadoDAO;
import br.imed.model.Estado;

@Controller
@Path("/estado")
public class EstadoController {


	private Result result;
	private EstadoDAO dao;

	public EstadoController() {
	}

	@Inject
	public EstadoController(Result result, EstadoDAO dao) {
		this.result = result;
		this.dao = dao;
	}
	
	@Get("")
	public void listar() {
		result.include("estados", dao.listar());
	}
	
	@Get("/adicionar")
	public void adicionar() {
		result.forwardTo(this).formulario(new Estado());
	}
	
	@Get("/editar/{id}")
	public void editar(Long id) {
		Estado estado = dao.get(id);
		result.forwardTo(this).formulario(estado);
	}
	
	public void formulario(Estado estado) {
		result.include("estado", estado);
	}

	@Post("/salvar")
	public void salvar(Estado estado) {
		dao.salvar(estado);
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
