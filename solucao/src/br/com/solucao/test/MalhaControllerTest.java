package br.com.solucao.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.solucao.controler.MalhaController;
import br.com.solucao.controler.MalhaControllerImpl;
import br.com.solucao.models.Malha;
import br.com.solucao.models.Malhas;
import br.com.solucao.models.Rota;
import br.com.solucao.util.SolucaoUtil;


public class MalhaControllerTest {
	
	private MalhaController malhaController = new MalhaControllerImpl();
	private static Malha malha = null;
	private static Malhas malhas1 = null;
	private static Malhas malhasN = null;
	
	static {
		
		malhas1 = new Malhas();
		malhasN = new Malhas();
		
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
	}

	
	@Test
	public void processar_Uma_Malha_NotNull() {
		SolucaoUtil.mapas.clear();
		malhaController.processar(MalhaControllerTest.malha);
		assertNotNull(SolucaoUtil.mapas.get(MalhaControllerTest.malha.getNome()));
	}
	
	@Test
	public void processar_Nome_Malha_NotNull() {
		SolucaoUtil.mapas.clear();
		malhaController.processar(MalhaControllerTest.malha);
		assertNotNull(SolucaoUtil.mapas.get(MalhaControllerTest.malha.getNome()).getNome());
	}
	
	@Test
	public void processar_Localizacoes_Malha_NotNull() {
		SolucaoUtil.mapas.clear();
		malhaController.processar(MalhaControllerTest.malha);
		assertNotNull(SolucaoUtil.mapas.get(MalhaControllerTest.malha.getNome()).getLocalizacoes());
	}
	
	@Test
	public void processar_Localizacoes_Malha_QTD_MaiorZero() {
		SolucaoUtil.mapas.clear();
		malhaController.processar(MalhaControllerTest.malha);
		assertTrue(SolucaoUtil.mapas.get(MalhaControllerTest.malha.getNome()).getLocalizacoes().size() > 0);
	}
	
	@Test
	public void processarMalhas_Uma_Malhas_NotNull() {
		SolucaoUtil.mapas.clear();
		malhaController.processarMalhas(MalhaControllerTest.malhas1);
		assertNotNull(SolucaoUtil.mapas.get(MalhaControllerTest.malhasN.getMalhas().get(0).getNome()));
	}
	
	@Test
	public void processarMalhas_N_Malhas_NotNull() {
		SolucaoUtil.mapas.clear();
		malhaController.processarMalhas(MalhaControllerTest.malhasN);
		assertNotNull(SolucaoUtil.mapas.get(MalhaControllerTest.malhasN.getMalhas().get(0).getNome()));
		assertNotNull(SolucaoUtil.mapas.get(MalhaControllerTest.malhasN.getMalhas().get(1).getNome()));
	}
	
	@Test
	public void processar_N_Malhas_Nome_Malha_NotNull() {
		SolucaoUtil.mapas.clear();
		malhaController.processarMalhas(MalhaControllerTest.malhasN);
		assertNotNull(SolucaoUtil.mapas.get(MalhaControllerTest.malhasN.getMalhas().get(0).getNome()).getNome());
		assertNotNull(SolucaoUtil.mapas.get(MalhaControllerTest.malhasN.getMalhas().get(1).getNome()).getNome());
	}
	
	@Test
	public void processar_N_Malhas_Localizacoes_Malha_NotNull() {
		SolucaoUtil.mapas.clear();
		malhaController.processarMalhas(MalhaControllerTest.malhasN);
		assertNotNull(SolucaoUtil.mapas.get(MalhaControllerTest.malhasN.getMalhas().get(0).getNome()).getLocalizacoes());
		assertNotNull(SolucaoUtil.mapas.get(MalhaControllerTest.malhasN.getMalhas().get(1).getNome()).getLocalizacoes());
	}
	
	@Test
	public void processar_N_Malhas_Localizacoes_Malha_QTD_MaiorZero() {
		SolucaoUtil.mapas.clear();
		malhaController.processarMalhas(MalhaControllerTest.malhasN);
		assertTrue(SolucaoUtil.mapas.get(MalhaControllerTest.malhasN.getMalhas().get(0).getNome()).getLocalizacoes().size() > 0);
		assertTrue(SolucaoUtil.mapas.get(MalhaControllerTest.malhasN.getMalhas().get(1).getNome()).getLocalizacoes().size() > 0);
	}
}