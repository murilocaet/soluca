package br.com.solucao.resources;

import br.com.solucao.models.Malhas;

/**
 * Nome da Interface: MalhaService.<br>
 * Descrição: Interface responsável por definir os serviços que manipulam as Malhas.<br><br>
 * 
 * Métodos:
 * <ul>
 * <li>carregarMalhas(Malhas malhas)
 * </ul>
 * 
 * @author      Murilo Costa
 * @version     1.0
 * @since       1.0
 */
public interface MalhaService {

	/**
	 * Carrega as malhas no sistema.
	 *
	 * @param malhas the malhas to save Malhas.
	 */
	public Malhas carregarMalhas(Malhas malhas);
}
