package br.com.solucao.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe: Rotas.<br>
 * Descrição: Model.<br><br>
 * 
 * Atributos:
 * <ul>
 * <li>id int
 * <li>mapa Mapa
 * <li>origem String
 * <li>destino String
 * <li>km Double
 * <li>autonomia Double
 * <li>custoMedio Double
 * <li>descricao String
 * <li>caminho List String
 * <li>roteiro StringBuilder
 * </ul>
 * 
 * @author      Murilo Costa
 * @version     1.0
 * @since       1.0
 */
@XmlRootElement(name = "Rotas")
public class Rotas {

	/**
	 * Atributo id
	 */
	private int id;
	
	/**
	 * Atributo mapa
	 */
	private Mapa mapa;
	
	/**
	 * Atributo origem
	 */
	private String origem;
	
	/**
	 * Atributo destino
	 */
	private String destino;
	
	/**
	 * Atributo km
	 */
	private Double km = 0d;
	
	/**
	 * Atributo autonomia
	 */
	private Double autonomia = 0d;
	
	/**
	 * Atributo custoMedio
	 */
	private Double custoMedio = 0d;
	
	/**
	 * Atributo descricao
	 */
	private String descricao = "";
	
	/**
	 * Atributo caminho
	 */
	private List<String> caminho = new ArrayList<String>();
	
	/**
	 * Atributo roteiro
	 */
	private StringBuilder roteiro = new StringBuilder();
	
	
	/**
	 * Construtor da Classe.
	 * 
	 */
	public Rotas() {

	}
	
	/**
	 * Construtor da Classe.
	 * 
	 * @param mapa
	 * @param origem
	 * @param destino
	 */
	public Rotas(Mapa mapa, String origem, String destino) {
		super();
		this.mapa = mapa;
		this.origem = origem;
		this.destino = destino;
		this.getCaminho().add(origem);
	}
	
	/**
	 * Construtor da Classe.
	 * 
	 * @param mapa
	 * @param origem
	 * @param destino
	 * @param autonomia
	 * @param custoMedio
	 */
	public Rotas(Mapa mapa, String origem, String destino, Double autonomia, Double custoMedio) {
		super();
		this.mapa = mapa;
		this.origem = origem;
		this.destino = destino;
		this.autonomia = autonomia;
		this.custoMedio = custoMedio;
		this.getCaminho().add(origem);
	}
	
	/**
	 * Construtor da Classe.
	 * 
	 * @param mapa
	 * @param origem
	 * @param destino
	 * @param km
	 */
	public Rotas(Mapa mapa, String origem, String destino, Double km) {
		super();
		this.mapa = mapa;
		this.origem = origem;
		this.destino = destino;
		this.km = km;
		this.getCaminho().add(origem);
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
	 * Retorna a origem.
	 * 
	 * @return the origem
	 */
	@XmlElement
	public String getOrigem() {
		return origem;
	}

	/**
	 * Seta a origem.
	 * 
	 * @param origem the origem to set
	 */
	public void setOrigem(String origem) {
		this.origem = origem;
	}

	/**
	 * Retorna o destino.
	 * 
	 * @return the destino
	 */
	@XmlElement
	public String getDestino() {
		return destino;
	}

	/**
	 * Seta o destino.
	 * 
	 * @param destino the destino to set
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}

	/**
	 * Retorna o km.
	 * 
	 * @return the km
	 */
	@XmlElement
	public Double getKm() {
		return km;
	}

	/**
	 * Seta o km.
	 * 
	 * @param km the km to set
	 */
	public void setKm(Double km) {
		this.km = km;
	}
	
	/**
	 * Incrementa um valor ao km.
	 * 
	 * @param km
	 */
	public void somaKm(Double km) {
		this.km += km;
	}

	/**
	 * Retorna autonomia.
	 * 
	 * @return the autonomia
	 */
	@XmlElement
	public Double getAutonomia() {
		return autonomia;
	}

	/**
	 * Seta autonomia.
	 * 
	 * @param autonomia the autonomia to set
	 */
	public void setAutonomia(Double autonomia) {
		this.autonomia = autonomia;
	}

	/**
	 * Retorna custoMedio.
	 * 
	 * @return the custoMedio
	 */
	@XmlElement
	public Double getCustoMedio() {
		return custoMedio;
	}

	/**
	 * Seta custoMedio.
	 * 
	 * @param custoMedio the custoMedio to set
	 */
	public void setCustoMedio(Double custoMedio) {
		this.custoMedio = custoMedio;
	}
	
	/**
	 * Calcula o custoMedio da Rota.
	 *  
	 * @return Double
	 */
	public Double calcularCustoMedio() {
		return (this.custoMedio*this.km)/this.autonomia;
	}

	/**
	 * Retorna descricao.
	 * 
	 * @return the descricao
	 */
	@XmlElement
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Seta a descricao.
	 * 
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Retorna o roteiro.
	 * 
	 * @return the roteiro
	 */
	public StringBuilder getRoteiro() {
		return roteiro;
	}

	/**
	 * Seta o roteiro.
	 * 
	 * @param roteiro the roteiro to set
	 */
	public void setRoteiro(StringBuilder roteiro) {
		this.roteiro = roteiro;
	}
	
	/**
	 * Adiciona nova localizacao ao roteiro.
	 * 
	 * @param localizacao
	 */
	public void addRoteiro(String localizacao) {
		this.roteiro.append(" ");
		this.roteiro.append(localizacao);
	}
	
	

	/**
	 * Retorna o caminho.
	 * 
	 * @return the caminho
	 */
	public List<String> getCaminho() {
		return caminho;
	}

	/**
	 * Seta o caminho.
	 * 
	 * @param caminho the caminho to set
	 */
	public void setCaminho(List<String> caminho) {
		this.caminho = caminho;
	}

	/**
	 * Clona uma Rota.
	 * 
	 * @return Rotas
	 */
	public Rotas clonar() {
		Rotas novaRotas = new Rotas();
		novaRotas.setId(this.getId());
		novaRotas.setOrigem(this.getOrigem());
		novaRotas.setDestino(this.getDestino());
		novaRotas.setKm(new Double(this.getKm()));
		novaRotas.setAutonomia(this.getAutonomia());
		novaRotas.setCustoMedio(this.getCustoMedio());
		novaRotas.setMapa(this.getMapa());
		novaRotas.setDescricao(this.getDescricao());
		novaRotas.getCaminho().addAll(this.getCaminho());
		novaRotas.setRoteiro(new StringBuilder(this.getRoteiro().toString()));
		
		return novaRotas;
	}
}
