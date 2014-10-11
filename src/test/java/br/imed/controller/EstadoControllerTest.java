package br.imed.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.util.test.MockResult;
import br.imed.dao.EstadoDAO;
import br.imed.model.Estado;

public class EstadoControllerTest {

	private static final long ID_DE_ESTADO_VALIDO = 99L;
	@Mock
	EstadoDAO dao;
	private EstadoController controller;
	private MockResult result;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.result = new MockResult();
		this.controller = new EstadoController(result, dao);
	}
	
	@Test
	public void deveAdicionar_comSucesso_umNovoEstado_preenchidoCorretamente() {
		this.controller.salvar(new Estado());
		assertTrue("Deveria ter adicionado com sucesso!", this.result
				.included().containsKey("sucesso"));
	}
	
	@Test
	public void deveDeletar_comSucesso_umEstado_UsandoOIdDoEstado() {
		this.controller.deletar(ID_DE_ESTADO_VALIDO);
		assertTrue("Deveria ter removido o estado com sucesso!", this.result
				.included().containsKey("sucesso"));
	}
	
	@Test
	public void deveListar_comSucesso_todosOsEstadosExistente(){
		controller.listar();
		assertTrue(result.included().containsKey("estados"));
	}

}
