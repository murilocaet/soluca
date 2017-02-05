package br.com.solucao.controler;

import br.com.solucao.models.Malha;
import br.com.solucao.models.Malhas;

/**
 * Nome da Interface: MalhaController.<br>
 * Descrição: Interface responsável por definir os métodos utilizados no controle das Malhas.<br><br>
 * 
 * Métodos:
 * <ul>
 * <li>saveMalha(Malha malha)
 * <li>loadMalha(Malha malha)
 * <li>processarMalhas(Malhas malhas)
 * <li>processar(Malha malha)
 * </ul>
 * 
 * @author      Murilo Costa
 * @version     1.0
 * @since       1.0
 */
public interface MalhaController {

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
	public void loadMalha(Malha malha);
	
	/**
	 * Processa uma lista de malhas criando um Map com todos os mapas e suas Localizacoes.
	 *
	 * @param malhas the malhas to load Malhas.
	 */
	public Malhas processarMalhas(Malhas malhas);
	
	/**
	 * Processa a malha criando um Map de mapas e suas Localizacoes.
	 *
	 * @param malha the malha to load Malha.
	 */
	public Malha processar(Malha malha);
}
