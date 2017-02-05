package br.com.solucao.bo;

import br.com.solucao.models.Malha;

/**
 * Nome da Interface: MalhaBo.<br>
 * Descri��o: Interface respons�vel por definir os m�todos utilizados para intermediar as chamadas de persist�ncias das Malhas.<br><br>
 * 
 * M�todos:
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
	 * Salva o JSON da Malha no diret�rio padr�o do servidor.
	 *
	 * @param malha the malha to save Malha.
	 */
	public void saveMalha(Malha malha);
	
	/**
	 * L� o JSON da Malha se encontrar o arquivo no diret�rio padr�o do servidor.
	 *
	 * @param malha the malha to load Malha.
	 */
	public Malha loadMalha(Malha malha);
}
