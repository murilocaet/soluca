package br.com.solucao.controler;

import br.com.solucao.bo.MalhaBo;
import br.com.solucao.bo.MalhaBoImpl;
import br.com.solucao.models.Localizacao;
import br.com.solucao.models.Malha;
import br.com.solucao.models.Malhas;
import br.com.solucao.models.Mapa;
import br.com.solucao.models.Rota;
import br.com.solucao.util.SolucaoUtil;

/**
 * Classe: MalhaControllerImpl.<br>
 * Descrição: Classe responsável por implementar os métodos que controlam as Malhas.<br><br>
 * 
 * Atributos:
 * <ul>
 * <li>malhaBo MalhaBo
 * </ul>
 * 
 * Métodos:
 * <ul>
 * <li>saveMalha(Malha malha)
 * <li>loadMalha(Malha malha)
 * <li>processarMalhas(Malhas malhas)
 * <li>processar(Malha malha)
 * </ul>
 * 
 * @author      Murilo Costa
 * @version     1.0
 * @since       1.0
 */
public class MalhaControllerImpl implements MalhaController {
	
	/**
	 * Atributo malhaBo
	 */
	MalhaBo malhaBo = new MalhaBoImpl();
	
	/** 
    * Construtor da Classe.
    * 
    */
	public MalhaControllerImpl() {
		
	}
	
	/* (non-Javadoc)
	 * @see br.com.solucao.controler.MalhaController#saveMalha(br.com.solucao.models.Malha)
	 */
	public void saveMalha(Malha malha) {
		malhaBo.saveMalha(malha);
	}
	
	/* (non-Javadoc)
	 * @see br.com.solucao.controler.MalhaController#loadMalha(br.com.solucao.models.Malha)
	 */
	public void loadMalha(Malha malha) {
		processar(malhaBo.loadMalha(malha));
	}
	
	/* (non-Javadoc)
	 * @see br.com.solucao.controler.MalhaController#processarMalhas(br.com.solucao.models.Malhas)
	 */
	public Malhas processarMalhas(Malhas malhas) {
		for (Malha m : malhas.getMalhas()) {
			processar(m);
			saveMalha(m);
		}
		
		return malhas;
	}
	
	/* (non-Javadoc)
	 * @see br.com.solucao.controler.MalhaController#processar(br.com.solucao.models.Malha)
	 */
	public Malha processar(Malha malha) {
		Mapa mapa = null;
		Localizacao localizacaoOrigem = null;
		Localizacao localizacaoDestino = null;
		
		if(malha != null) {
			mapa = SolucaoUtil.mapas.get(malha.getNome());
			if(mapa == null) {
				mapa = new Mapa(SolucaoUtil.mapas.size()+1, malha.getNome());
				SolucaoUtil.mapas.put(malha.getNome(), mapa);
			}else {
				mapa.getLocalizacoes().clear();
			}
	
			for (Rota rota : malha.getRotas()) {
				localizacaoOrigem = mapa.getLocalizacoes().get(rota.getOrigem());
				localizacaoDestino = mapa.getLocalizacoes().get(rota.getDestino());
				
				if(localizacaoOrigem == null) {
					localizacaoOrigem = new Localizacao(mapa, rota.getOrigem());
					localizacaoOrigem.setId(mapa.getLocalizacoes().size()+1);
					mapa.getLocalizacoes().put(localizacaoOrigem.getNome(), localizacaoOrigem);
				}
				if(localizacaoDestino == null) {
					localizacaoDestino = new Localizacao(mapa, rota.getDestino());
					localizacaoDestino.setId(mapa.getLocalizacoes().size()+1);
					mapa.getLocalizacoes().put(localizacaoDestino.getNome(), localizacaoDestino);
				}
	
				if( (localizacaoOrigem.getMapLocalizacao().isEmpty()) ||
					(localizacaoOrigem.getMapLocalizacao().size() > 0 && localizacaoOrigem.getMapLocalizacao().get(localizacaoDestino.getNome()) == null)) {
					localizacaoOrigem.getMapLocalizacao().put(localizacaoDestino.getId(), localizacaoDestino);
					localizacaoOrigem.getMapKm().put(localizacaoDestino.getId(), rota.getKm());
				}
				
				if( (localizacaoDestino.getMapLocalizacao().isEmpty()) ||
					(localizacaoDestino.getMapLocalizacao().size() > 0 && localizacaoDestino.getMapLocalizacao().get(localizacaoOrigem.getNome()) == null)) {
					localizacaoDestino.getMapLocalizacao().put(localizacaoOrigem.getId(), localizacaoOrigem);
					localizacaoDestino.getMapKm().put(localizacaoOrigem.getId(), rota.getKm());
				}
			}
		}
		
		return malha;
	}
}
