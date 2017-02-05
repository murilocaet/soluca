package br.com.solucao.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.solucao.constantes.Constantes;
import br.com.solucao.models.Distribuicao;
import br.com.solucao.models.Erro;
import br.com.solucao.models.Localizacao;
import br.com.solucao.models.Malha;
import br.com.solucao.models.Malhas;
import br.com.solucao.models.Mapa;
import br.com.solucao.models.Rota;
import br.com.solucao.models.Rotas;
import br.com.solucao.util.SolucaoUtil;

/**
 * Classe: RotaControllerImpl.<br>
 * Descrição: Classe responsável por implementar os métodos que controlam as Rotas.<br><br>
 * 
 * Métodos:
 * <ul>
 * <li>salvarRoteito(Rotas rotas)
 * <li>calcularCustoMedio(Distribuicao distribuicao)
 * <li>processarDistribuicao(Malhas malhas)
 * <li>processar(Malha malha, Distribuicao distribuicao)
 * <li>processarRotas(Malha malha)
 * <li>calcularRotaMaisCurta(Rotas rotas)
 * <li>encontrarDestino(Localizacao localizacao, Rotas rotas)
 * <li>compararCaminhos()
 * </ul>
 * 
 * @author      Murilo Costa
 * @version     1.0
 * @since       1.0
 */
public class RotaControllerImpl implements RotaController{
	
	/** 
    * Construtor da Classe.
    * 
    */
	public RotaControllerImpl() {
		
	}
	
	/* (non-Javadoc)
	 * @see br.com.solucao.controler.RotaController#salvarRoteito(br.com.solucao.models.Rotas)
	 */
	public void salvarRoteito(Rotas rotas) {
		SolucaoUtil.melhorCaminho.add(rotas);
	}
	
	/* (non-Javadoc)
	 * @see br.com.solucao.controler.RotaController#calcularCustoMedio(br.com.solucao.models.Distribuicao)
	 */
	public void calcularCustoMedio(Distribuicao distribuicao) {
		for (Rotas rotas : distribuicao.getRotas()) {
			rotas.setDescricao(rotas.getRoteiro().toString());
			rotas.setCustoMedio(rotas.calcularCustoMedio());
		}
	}
	
	/* (non-Javadoc)
	 * @see br.com.solucao.controler.RotaController#processarDistribuicao(br.com.solucao.models.Malhas)
	 */
	public Distribuicao processarDistribuicao(Malhas malhas) {
		Distribuicao distribuicao = new Distribuicao();
		for (Malha m : malhas.getMalhas()) {
			processar(m, distribuicao);
		}
		
		calcularCustoMedio(distribuicao);
		
		return distribuicao;
	}
	
	/* (non-Javadoc)
	 * @see br.com.solucao.controler.RotaController#processar(br.com.solucao.models.Malha, br.com.solucao.models.Distribuicao)
	 */
	public void processar(Malha malha, Distribuicao distribuicao) {
		Mapa mapa = null;
		List<Erro> erros = null;
		Rotas rotaMaisCurta = null;
		
		mapa =  SolucaoUtil.mapas.get(malha.getNome());
		if(mapa == null) {
			new MalhaControllerImpl().loadMalha(malha);
		}

		SolucaoUtil.rotas.clear();
		
		erros = processarRotas(malha);
		
		distribuicao.getErros().addAll(erros);
		
		for (Rotas rotas : SolucaoUtil.rotas.values()) {
			rotaMaisCurta = calcularRotaMaisCurta(rotas);
			distribuicao.getRotas().add(rotaMaisCurta);
			SolucaoUtil.melhorCaminho.clear();
		}
	}
	
	/* (non-Javadoc)
	 * @see br.com.solucao.controler.RotaController#processarRotas(br.com.solucao.models.Malha)
	 */
	public List<Erro> processarRotas(Malha malha) {
		Rotas rotas = null;
		Mapa mapa = null;
		List<Erro> erros = new ArrayList<Erro>();
		Erro erro = null;
		Boolean rotaValida = Boolean.TRUE;
		StringBuilder chaveRota = null;
		
		mapa =  SolucaoUtil.mapas.get(malha.getNome());
		if(mapa == null) {
			erro = new Erro(new Mapa(malha.getNome()), Constantes.MAPA_NAO_ENCONTRADO);
			erros.add(erro);
			rotaValida = Boolean.FALSE;
		}else {
			
			SolucaoUtil.rotas.clear();
			
			for (Rota rota : malha.getRotas()) {
				chaveRota = new StringBuilder();
				chaveRota.append(mapa.getNome());
				chaveRota.append("-");
				
				rotaValida = Boolean.TRUE;
				if(mapa.getLocalizacoes().get(rota.getOrigem()) == null) {
					erro = new Erro(new Rotas(mapa,rota.getOrigem(),rota.getDestino()), Constantes.LOCALIZAÇÃO_ORIGEM_NAO_ENCONTRADO);
					erros.add(erro);
					rotaValida = Boolean.FALSE;
				}
				if(mapa.getLocalizacoes().get(rota.getDestino()) == null) {
					erro = new Erro(new Rotas(mapa,rota.getOrigem(),rota.getDestino()), Constantes.LOCALIZAÇÃO_DESTINO_NAO_ENCONTRADO);
					erros.add(erro);
					rotaValida = Boolean.FALSE;
				}
				
				if(rotaValida) {
					chaveRota.append(rota.getOrigem());
					chaveRota.append(rota.getDestino());
					rotas = new Rotas(mapa, rota.getOrigem(), rota.getDestino(), rota.getKm(), rota.getCustoMedio());
					SolucaoUtil.rotas.put(chaveRota.toString(), rotas);
				}
			}
		}
		
		return erros;
	}
	
	/* (non-Javadoc)
	 * @see br.com.solucao.controler.RotaController#calcularRotaMaisCurta(br.com.solucao.models.Rotas)
	 */
	public Rotas calcularRotaMaisCurta(Rotas rotas) {
		Mapa mapa = SolucaoUtil.mapas.get(rotas.getMapa().getNome());
		Map<String, Localizacao> localizacoes = mapa.getLocalizacoes();
		Localizacao localizacao = localizacoes.get(rotas.getOrigem());
		Rotas copy = null;
		
		rotas.setRoteiro(new StringBuilder(rotas.getOrigem()));
		
		Mapa mapaNovo = new Mapa();
		mapaNovo.setId(rotas.getMapa().getId());
		mapaNovo.setNome(rotas.getMapa().getNome());
		rotas.setMapa(mapaNovo);
		
		if(localizacao.getMapLocalizacao().size() > 0) {
			for (Localizacao l : localizacao.getMapLocalizacao().values()) {
				copy = rotas.clonar();
				copy.addRoteiro(l.getNome());
				copy.somaKm(localizacao.getMapKm().get(l.getId()));
				
				if(l.getNome().equalsIgnoreCase(rotas.getDestino())) {
					salvarRoteito(copy);
				}else {
					encontrarDestino(l, copy);
				}
			}
		}

		return compararCaminhos();
	}
	
	/* (non-Javadoc)
	 * @see br.com.solucao.controler.RotaController#encontrarDestino(br.com.solucao.models.Localizacao, br.com.solucao.models.Rotas)
	 */
	public void encontrarDestino(Localizacao localizacao, Rotas rotas) {
		Rotas copy = null;
		for (Localizacao l : localizacao.getMapLocalizacao().values()) {
			if(!rotas.getCaminho().contains(l.getNome())) {
				if(!rotas.getCaminho().contains(localizacao.getNome())) {
					rotas.getCaminho().add(localizacao.getNome());
				}
				copy = rotas.clonar();
				copy.addRoteiro(l.getNome());
				copy.somaKm(localizacao.getMapKm().get(l.getId()));
				
				if(l.getNome().equalsIgnoreCase(rotas.getDestino())) {
					salvarRoteito(copy);
				}
				else {
					encontrarDestino(l, copy);
				}
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see br.com.solucao.controler.RotaController#compararCaminhos()
	 */
	public Rotas compararCaminhos() {
		Double distancia = 0d;
		Rotas maisCurta = null;
		int cont = 0;
		for (Rotas rotas : SolucaoUtil.melhorCaminho) {
			if(cont == 0) {
				distancia = rotas.getKm();
				maisCurta = rotas;
				cont++;
			}else {
				if(rotas.getKm() <= distancia) {
					distancia = rotas.getKm();
					maisCurta = rotas;
				}
			}
		}
		
		return maisCurta;
	}
}
