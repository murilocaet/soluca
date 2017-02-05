package br.com.solucao.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.solucao.models.Mapa;
import br.com.solucao.models.Rotas;

/**
 * Nome da Interface: SolucaoUtil.<br>
 * Descrição: Guarda a lista de mapas, rotas e melhorCaminhos utilizadas no sistema.<br><br>
 * 
 * Atributos:
 * <ul>
 * <li>mapas Map de String, Mapa
 * <li>rotas Map de String, Rotas
 * <li>melhorCaminho Lista de Rotas
 * </ul>
 * 
 * @author      Murilo Costa
 * @version     1.0
 * @since       1.0
 */
public class SolucaoUtil {
	/**
	 * Atributo mapas
	 */
	public static Map<String, Mapa> mapas = new HashMap<String, Mapa>();
	
	/**
	 * Atributo rotas
	 */
	public static Map<String, Rotas> rotas = new HashMap<String, Rotas>();
	
	/**
	 * Atributo melhorCaminho
	 */
	public static List<Rotas> melhorCaminho = new ArrayList<Rotas>();
}
