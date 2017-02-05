package br.com.solucao.bo;

import br.com.solucao.models.Malha;

/**
 * Nome da Interface: MalhaBo.<br>
 * Descrição: Interface responsável por definir os métodos utilizados para intermediar as chamadas de persistências das Malhas.<br><br>
 * 
 * Métodos:
 * <ul>
 * <li>saveMalha(Malha malha)
 * <li>loadMalha(Malha malha)
 * </ul>
 * 
 * @author      Murilo Costa
 * @version     1.0
 * @since       1.0
 */
public interface MalhaBo {
	
	/**
	 * Salva o JSON da Malha no diretório padrão do servidor.
	 *
	 * @param malha the malha to save Malha.
	 */
	public void saveMalha(Malha malha);
	
	/**
	 * Lê o JSON da Malha se encontrar o arquivo no diretório padrão do servidor.
	 *
	 * @param malha the malha to load Malha.
	 */
	public Malha loadMalha(Malha malha);
}
