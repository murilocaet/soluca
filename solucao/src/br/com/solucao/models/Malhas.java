package br.com.solucao.models;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe: Malhas.<br>
 * Descrição: Model.<br><br>
 * 
 * Atributos:
 * <ul>
 * <li>malhas Lista de Malhas
 * </ul>
 * 
 * @author      Murilo Costa
 * @version     1.0
 * @since       1.0
 */
@XmlRootElement(name = "Malhas")
public class Malhas {

	/**
	 * Atributo malhas
	 */
	private List<Malha> malhas;
	
	/**
    * Construtor da Classe.
    * 
    */
	public Malhas() {
		super();
	}

	/**
	 * Retorna as malhas.
	 * 
	 * @return the malhas
	 */
	@XmlElement
	public List<Malha> getMalhas() {
		return malhas;
	}

	/**
	 * Seta as malhas.
	 * 
	 * @param malhas the malhas to set
	 */
	public void setMalhas(List<Malha> malhas) {
		this.malhas = malhas;
	}

}
