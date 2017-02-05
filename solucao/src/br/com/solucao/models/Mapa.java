package br.com.solucao.models;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe: Mapa.<br>
 * Descrição: Model.<br><br>
 * 
 * Atributos:
 * <ul>
 * <li>id int
 * <li>nome String
 * <li>localizacoes Map de String, Localizacao
 * </ul>
 * 
 * @author      Murilo Costa
 * @version     1.0
 * @since       1.0
 */
@XmlRootElement(name = "Mapa")
public class Mapa {

	/**
	 * Atributo id
	 */
	private int id;
	
	/**
	 * Atributo nome
	 */
	private String nome;
	
	/**
	 * Atributo localizacoes
	 */
	private Map<String, Localizacao> localizacoes = new HashMap<String, Localizacao>();
	
	
	/**
    * Construtor da Classe.
    * 
    */
	public Mapa() {
		super();
	}
	
	/**
     * Construtor da Classe.
     * 
	 * @param nome
	 */
	public Mapa(String nome) {
		super();
		this.nome = nome;
	}
	
	/**
     * Construtor da Classe.
     * 
	 * @param id
	 * @param nome
	 */
	public Mapa(int id, String nome) {
		super();
		this.id = id;
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
	 * Retorna o nome.
	 * 
	 * @return the nome
	 */
	@XmlElement
	public String getNome() {
		return nome;
	}
	
	/**
	 * Seta o nome.
	 * 
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna as localizacoes.
	 * 
	 * @return the localizacoes
	 */
	@XmlElement
	public Map<String, Localizacao> getLocalizacoes() {
		return localizacoes;
	}

	/**
	 * Seta as localizacoes.
	 * 
	 * @param localizacoes the localizacoes to set
	 */
	public void setLocalizacoes(Map<String, Localizacao> localizacoes) {
		this.localizacoes = localizacoes;
	}
	
}
