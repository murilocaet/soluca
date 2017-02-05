package br.com.solucao.models;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe: Localizacao.<br>
 * Descrição: Model.<br><br>
 * 
 * Atributos:
 * <ul>
 * <li>id int
 * <li>mapa Mapa
 * <li>nome String
 * <li>mapLocalizacao Map de Integer, Localizacao
 * <li>mapKm Map de Integer, Double
 * </ul>
 * 
 * @author      Murilo Costa
 * @version     1.0
 * @since       1.0
 */
@XmlRootElement(name = "Localizacao")
public class Localizacao {

	/**
	 * Atributo id
	 */
	private int id;
	
	/**
	 * Atributo mapa
	 */
	private Mapa mapa;
	
	/**
	 * Atributo nome
	 */
	private String nome;
	
	/**
	 * Atributo mapLocalizacao
	 */
	private Map<Integer, Localizacao> mapLocalizacao = new HashMap<Integer, Localizacao>();
	
	/**
	 * Atributo mapKm
	 */
	private Map<Integer, Double> mapKm = new HashMap<Integer, Double>();
	
	/**
    * Construtor da Classe.
    * 
    */
	public Localizacao() {
		super();
	}
	
	/**
    * Construtor da Classe.
    * 
    * @param mapa Mapa
    * @param nome String
    */
	public Localizacao(Mapa mapa, String nome) {
		this.mapa = mapa;
		this.nome = nome;
	}

	/**
	 * Retorna o id.
	 * 
	 * @return the id
	 */
	@XmlElement
	public int getId() {
		return id;
	}

	/**
	 * Seta o id.
	 * 
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Retorna o mapa.
	 * 
	 * @return the mapa
	 */
	@XmlElement
	public Mapa getMapa() {
		return mapa;
	}

	/**
	 * Seta o mapa.
	 * 
	 * @param mapa the mapa to set
	 */
	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

	/**
	 * Retorna o nome.
	 * 
	 * @return the nome
	 */
	@XmlElement
	public String getNome() {
		return nome;
	}

	/**
	 * seta o nome.
	 * 
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o mapLocalizacao.
	 * 
	 * @return the mapLocalizacao
	 */
	@XmlElement
	public Map<Integer, Localizacao> getMapLocalizacao() {
		return mapLocalizacao;
	}

	/**
	 * Seta o mapLocalizacao.
	 * 
	 * @param mapLocalizacao the mapLocalizacao to set
	 */
	public void setMapLocalizacao(Map<Integer, Localizacao> mapLocalizacao) {
		this.mapLocalizacao = mapLocalizacao;
	}

	/**
	 * Retorna o mapKm.
	 * 
	 * @return the mapKm
	 */
	@XmlElement
	public Map<Integer, Double> getMapKm() {
		return mapKm;
	}

	/**
	 * Seta o mapKm.
	 * 
	 * @param mapKm the mapKm to set
	 */
	public void setMapKm(Map<Integer, Double> mapKm) {
		this.mapKm = mapKm;
	}
}
