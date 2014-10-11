package br.imed.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.util.test.MockResult;
import br.imed.dao.CidadeDAO;
import br.imed.model.Cidade;

public class CidadeControllerTest {

	private static final long ID_DE_CIDADE_VALIDO = 99L;
	@Mock
	CidadeDAO dao;
	private CidadeController controller;
	private MockResult result;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.result = new MockResult();
		this.controller = new CidadeController(result, dao);
	}
	
	@Test
	public void deveAdicionar_comSucesso_umNovoCidade_preenchidoCorretamente() {
		this.controller.salvar(new Cidade());
		assertTrue("Deveria ter adicionado com sucesso!", this.result
				.included().containsKey("sucesso"));
	}
	
	@Test
	public void deveDeletar_comSucesso_umCidade_UsandoOIdDoCidade() {
		this.controller.deletar(ID_DE_CIDADE_VALIDO);
		assertTrue("Deveria ter removido a cidade com sucesso!", this.result
				.included().containsKey("sucesso"));
	}
	
	@Test
	public void deveListar_comSucesso_todosOsCidadesExistente(){
		controller.listar();
		assertTrue(result.included().containsKey("cidades"));
	}

}
