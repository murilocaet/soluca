package br.com.solucao.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe: Rota.<br>
 * Descrição: Model.<br><br>
 * 
 * Atributos:
 * <ul>
 * <li>origem String
 * <li>destino String
 * <li>km Double
 * <li>custoMedio Double
 * </ul>
 * 
 * @author      Murilo Costa
 * @version     1.0
 * @since       1.0
 */
@XmlRootElement(name = "Rota")
public class Rota {

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
	 * Atributo custoMedio
	 */
	private Double custoMedio = 0d;
	
	/**
	 * Construtor da Classe.
	 * 
	 */
	public Rota() {
	}

	/**
	 * Construtor da Classe.
	 * 
	 * @param origem
	 * @param destino
	 * @param km
	 * @param custoMedio
	 */
	public Rota(String origem, String destino, Double km, Double custoMedio) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.km = km;
		this.custoMedio = custoMedio;
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
	 * Retorna o custoMedio.
	 * 
	 * @return the custoMedio
	 */
	@XmlElement
	public Double getCustoMedio() {
		return custoMedio;
	}

	/**
	 * Seta o custoMedio.
	 * 
	 * @param custoMedio the custoMedio to set
	 */
	public void setCustoMedio(Double custoMedio) {
		this.custoMedio = custoMedio;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{\"origem\":\""+this.origem + "\",\"destino\":\""+this.destino + "\",\"km\":\""+this.km + "\",\"custoMedio\":\""+this.custoMedio +"\"}";
	}
	
	
}
