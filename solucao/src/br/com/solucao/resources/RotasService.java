package br.com.solucao.resources;

import br.com.solucao.models.Distribuicao;
import br.com.solucao.models.Malhas;

/**
 * Nome da Interface: RotasService.<br>
 * Descrição: Interface responsável por definir os serviços que manipulam as Rotas.<br><br>
 * 
 * Métodos:
 * <ul>
 * <li>obterRotas(Malhas malhas)
 * </ul>
 * 
 * @author      Murilo Costa
 * @version     1.0
 * @since       1.0
 */
public interface RotasService {

	/**
	 * Carrega as rotas no sistema e retorna as melhores rotas encontradas para cada destino.
	 *
	 * @param malhas the malhas to save Malhas.
	 */
	public Distribuicao obterRotas(Malhas malhas);
}
