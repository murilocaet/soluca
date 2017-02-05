package br.com.solucao.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe: Malha.<br>
 * Descrição: Model.<br><br>
 * 
 * Atributos:
 * <ul>
 * <li>nome String
 * <li>rotas Lista de Rotas
 * </ul>
 * 
 * @author      Murilo Costa
 * @version     1.0
 * @since       1.0
 */
@XmlRootElement(name = "Malha")
public class Malha {

	/**
	 * Atributo nome
	 */
	private String nome;
	
	/**
	 * Atributo rotas
	 */
	private List<Rota> rotas = new ArrayList<Rota>();
	
	/**
    * Construtor da Classe.
    * 
    */
	public Malha() {
	}
	
	/**
    * Construtor da Classe.
    * 
    * @param nome String
    */
	public Malha(String nome) {
		this.nome = nome;
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
	 * Retorna as rotas.
	 * 
	 * @return the rotas
	 */
	@XmlElement
	public List<Rota> getRotas() {
		return rotas;
	}

	/**
	 * Seta as rotas.
	 * 
	 * @param rotas the rotas to set
	 */
	public void setRotas(List<Rota> rotas) {
		this.rotas = rotas;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String rotas = this.getRotas().toString();
		return "{\"nome\":\"" + this.nome + "\",\"rotas\":"+ rotas + "}";
	}
	
	
}
