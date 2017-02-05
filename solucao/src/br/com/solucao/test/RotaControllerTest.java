package br.com.solucao.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.solucao.controler.MalhaController;
import br.com.solucao.controler.MalhaControllerImpl;
import br.com.solucao.controler.RotaController;
import br.com.solucao.controler.RotaControllerImpl;
import br.com.solucao.models.Distribuicao;
import br.com.solucao.models.Malha;
import br.com.solucao.models.Malhas;
import br.com.solucao.models.Rota;
import br.com.solucao.util.SolucaoUtil;


public class RotaControllerTest {
	
	private MalhaController malhaController = new MalhaControllerImpl();
	private RotaController rotaController = new RotaControllerImpl();
	private static Malha malha = null;
	private static Malhas malhas1 = null;
	private static Malhas malhasN = null;
	private static Malha malhaR = null;
	private static Malha malhaR_BD = null;
	private static Rota rota = null;
	private static Malhas malhasRotas = null;
	private static Malhas malhasRotas_BD = null;
	
	static {
		
		malhas1 = new Malhas();
		malhasN = new Malhas();
		malhasRotas = new Malhas();
		malhasRotas_BD = new Malhas();
		malhaR = new Malha("BA");
		malhaR_BD = new Malha("BA");
		
		malha = new Malha();
		malha.setNome("BA");
		
		Rota r = new Rota();
		r.setOrigem("A");
		r.setDestino("B");
		r.setKm(10.0);
		
		malha.getRotas().add(r);

		r = new Rota();
		r.setOrigem("B");
		r.setDestino("D");
		r.setKm(15.0);

		malha.getRotas().add(r);

		r = new Rota();
		r.setOrigem("A");
		r.setDestino("C");
		r.setKm(20.0);

		malha.getRotas().add(r);

		r = new Rota();
		r.setOrigem("C");
		r.setDestino("D");
		r.setKm(30.0);

		malha.getRotas().add(r);

		r = new Rota();
		r.setOrigem("B");
		r.setDestino("E");
		r.setKm(50.0);

		malha.getRotas().add(r);

		r = new Rota();
		r.setOrigem("D");
		r.setDestino("E");
		r.setKm(30.0);

		malha.getRotas().add(r);

		malhas1.getMalhas().add(malha);
		malhasN.getMalhas().add(malha);
		
		
		malha = new Malha();
		malha.setNome("SP");
		
		r = new Rota();
		r.setOrigem("A");
		r.setDestino("B");
		r.setKm(10.0);
		
		malha.getRotas().add(r);

		r = new Rota();
		r.setOrigem("B");
		r.setDestino("D");
		r.setKm(15.0);

		malha.getRotas().add(r);

		r = new Rota();
		r.setOrigem("A");
		r.setDestino("C");
		r.setKm(20.0);

		malha.getRotas().add(r);

		r = new Rota();
		r.setOrigem("C");
		r.setDestino("D");
		r.setKm(30.0);

		malha.getRotas().add(r);

		r = new Rota();
		r.setOrigem("B");
		r.setDestino("E");
		r.setKm(50.0);

		malha.getRotas().add(r);

		r = new Rota();
		r.setOrigem("D");
		r.setDestino("E");
		r.setKm(30.0);

		malha.getRotas().add(r);

		malhasN.getMalhas().add(malha);
		
		
		rota = new Rota("A","B",10.0, 2.5);
		malhaR.getRotas().add(rota);
		
		rota = new Rota("A","B",10.0, 2.5);
		malhaR.getRotas().add(rota);
		
		rota = new Rota("A","C",10.0, 2.5);
		malhaR.getRotas().add(rota);
		
		rota = new Rota("A","D",10.0, 2.5);
		malhaR.getRotas().add(rota);
		malhaR_BD.getRotas().add(rota);
		
		malhasRotas.getMalhas().add(malhaR);
		malhasRotas_BD.getMalhas().add(malhaR_BD);
		
	}

	
	@Test
	public void processar_Rotas_NotNull() {
		SolucaoUtil.mapas.clear();
		SolucaoUtil.rotas.clear();
		malhaController.processar(RotaControllerTest.malha);
		rotaController.processarRotas(RotaControllerTest.malhaR);
		assertNotNull(SolucaoUtil.rotas);
	}
	
	@Test
	public void processar_Rotas_Qtd_MaiorZero() {
		SolucaoUtil.mapas.clear();
		SolucaoUtil.rotas.clear();
		malhaController.processar(RotaControllerTest.malhasN.getMalhas().get(0));
		rotaController.processarRotas(RotaControllerTest.malhaR);
		assertTrue(SolucaoUtil.rotas.size() > 0);
	}
	
	@Test
	public void processar_Rotas_Mais_Curta_NotNull() {
		Distribuicao distribuicao = null;
		SolucaoUtil.mapas.clear();
		SolucaoUtil.rotas.clear();
		malhaController.processar(RotaControllerTest.malhasN.getMalhas().get(0));
		distribuicao = rotaController.processarDistribuicao(RotaControllerTest.malhasRotas);
		assertNotNull(distribuicao);
	}
	
	@Test
	public void processar_Rotas_Mais_Curta_BD() {
		Distribuicao distribuicao = null;
		SolucaoUtil.mapas.clear();
		SolucaoUtil.rotas.clear();
		malhaController.processar(RotaControllerTest.malhasN.getMalhas().get(0));
		distribuicao = rotaController.processarDistribuicao(RotaControllerTest.malhasRotas_BD);
		assertEquals(new Double(6.25), distribuicao.getRotas().get(0).getCustoMedio());
	}
}