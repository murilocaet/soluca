package br.com.solucao.dao;

import br.com.solucao.models.Malha;

/**
 * Nome da Interface: MalhaDao.<br>
 * Descri��o: Interface respons�vel por definir os m�todos utilizados para persistir as Malhas.<br><br>
 * 
 * M�todos:
 * <ul>
 * <li>saveMalha(Malha malha)
 * <li>loadMalha(Malha malha)
 * <li>salvarJSON(Malha malha)
 * <li>lerJSON(Malha malha)
 * </ul>
 * 
 * @author      Murilo Costa
 * @version     1.0
 * @since       1.0
 */
public interface MalhaDao {

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
	
	/**
	 * Salva o JSON da Malha no diret�rio padr�o do servidor.
	 *
	 * @param malha the malha to save Malha.
	 */
	public void salvarJSON(Malha malha);
	
	/**
	 * L� o JSON da Malha se encontrar o arquivo no diret�rio padr�o do servidor.
	 *
	 * @param malha the malha to load Malha.
	 */
	public Malha lerJSON(Malha malha);
}
