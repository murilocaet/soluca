package br.com.solucao.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe: Erro.<br>
 * Descrição: Model.<br><br>
 * 
 * Atributos:
 * <ul>
 * <li>mensagem String
 * <li>mapa Mapa
 * <li>rotas Rotas
 * </ul>
 * 
 * @author      Murilo Costa
 * @version     1.0
 * @since       1.0
 */
@XmlRootElement(name = "Erro")
public class Erro {

	/**
	 * Atributo mensagem
	 */
	private String mensagem = "";
	
	/**
	 * Atributo mapa
	 */
	private Mapa mapa;
	
	/**
	 * Atributo rotas
	 */
	private Rotas rotas;
	
	/**
    * Construtor da Classe.
    * 
    */
	public Erro() {
		
	}
	
	/**
    * Construtor da Classe.
    * 
    * @param mapa Mapa
    * @param mensagem String
    */
	public Erro(Mapa mapa, String mensagem) {
		super();
		this.mapa = mapa;
		this.mensagem = mensagem;
		this.rotas = new Rotas(mapa,"-","-");
	}
	
	/**
    * Construtor da Classe.
    * 
    * @param rotas Rotas
    * @param mensagem String
    */
	public Erro(Rotas rotas, String mensagem) {
		super();
		this.mapa = rotas.getMapa();
		this.mensagem = mensagem;
		this.rotas = rotas;
	}

	/**
	 * Retorna a mensagem.
	 * 
	 * @return the mensagem
	 */
	@XmlElement
	public String getMensagem() {
		return mensagem;
	}

	/**
	 * Seta a mensagem.
	 * 
	 * @param mensagem the mensagem to set
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	/**
	 * Retorna o mapa
	 * 
	 * @return the mapa
	 */
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
	 * Retorna a rota.
	 * 
	 * @return the rotas
	 */
	public Rotas getRotas() {
		return rotas;
	}

	/**
	 * Seta a rota
	 * @param rotas the rotas to set
	 */
	public void setRotas(Rotas rotas) {
		this.rotas = rotas;
	}
}
