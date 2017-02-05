package br.com.solucao.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe: Distribuicao.<br>
 * Descrição: Model.<br><br>
 * 
 * Atributos:
 * <ul>
 * <li>erros Lista de Erros
 * <li>rotas Lista de Rotas
 * </ul>
 * 
 * @author      Murilo Costa
 * @version     1.0
 * @since       1.0
 */
@XmlRootElement(name = "Distribuicao")
public class Distribuicao {

	/**
	 * Atributo erros
	 */
	List<Erro> erros = new ArrayList<Erro>();
	
	/**
	 * Atributo rotas
	 */
	private List<Rotas> rotas = new ArrayList<Rotas>();
	
	/**
    * Construtor da Classe.
    * 
    */
	public Distribuicao(){
		
	}
	
	/**
	 * Retorna os erros.
	 * 
	 * @return the list of erros
	 */
	@XmlElement
	public List<Erro> getErros() {
		return erros;
	}
	
	/**
	 * Seta os erros.
	 * 
	 * @param erros the erros to set
	 */
	public void setErros(List<Erro> erros) {
		this.erros = erros;
	}
	
	/**
	 * Retorna as rotas.
	 * 
	 * @return the list of rotas
	 */
	@XmlElement
	public List<Rotas> getRotas() {
		return rotas;
	}
	
	/**
	 * Seta as rotas.
	 * 
	 * @param rotas the rotas to set
	 */
	public void setRotas(List<Rotas> rotas) {
		this.rotas = rotas;
	}
}
