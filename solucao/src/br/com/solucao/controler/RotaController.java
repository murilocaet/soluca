package br.com.solucao.controler;

import java.util.List;

import br.com.solucao.models.Distribuicao;
import br.com.solucao.models.Erro;
import br.com.solucao.models.Localizacao;
import br.com.solucao.models.Malha;
import br.com.solucao.models.Malhas;
import br.com.solucao.models.Rotas;

/**
 * Nome da Interface: RotaController.<br>
 * Descrição: Interface responsável por definir os métodos utilizados no controle das Rotas.<br><br>
 * 
 * Métodos:
 * <ul>
 * <li>salvarRoteito(Rotas rotas)
 * <li>calcularCustoMedio(Distribuicao distribuicao)
 * <li>processarDistribuicao(Malhas malhas)
 * <li>processar(Malha malha, Distribuicao distribuicao)
 * <li>processarRotas(Malha malha)
 * <li>calcularRotaMaisCurta(Rotas rotas)
 * <li>encontrarDestino(Localizacao localizacao, Rotas rotas)
 * <li>compararCaminhos()
 * </ul>
 * 
 * @author      Murilo Costa
 * @version     1.0
 * @since       1.0
 */
public interface RotaController {

	/**
	 * Salva a melhor rota processada no Roteiro.
	 *
	 * @param rotas the rotas to save Rotas.
	 */
	public void salvarRoteito(Rotas rotas);
	
	/**
	 * Calcula o custoMedio de cada Rota existente na Distribuicao.
	 *
	 * @param distribuicao the distribuicao to save Distribuicao.
	 */
	public void calcularCustoMedio(Distribuicao distribuicao);
	
	/**
	 * Processa uma lista de malhas criando suas melhores Rotas e salva na Distribuicao.
	 *
	 * @param malhas the malhas to load Malhas.
	 */
	public Distribuicao processarDistribuicao(Malhas malhas);
	
	/**
	 * Processa a malha criando sua melhor Rota e salva na Distribuicao.
	 *
	 * @param malha the malha to load Malha.
	 * @param distribuicao the distribuicao to load Distribuicao.
	 */
	public void processar(Malha malha, Distribuicao distribuicao);
	
	/**
	 * Processa a malha criando uma lista de Destinos para futuro processamento da melhor Rota.
	 *
	 * @param malha the malha to load Malha.
	 */
	public List<Erro> processarRotas(Malha malha);
	
	/**
	 * Processa todos os destino e retorna todas as rotas possíveis.
	 *
	 * @param malha the malha to load Malha.
	 */
	public Rotas calcularRotaMaisCurta(Rotas rotas);
	
	/**
	 * Processa todos os destino e retorna todas as rotas possíveis.
	 *
	 * @param malha the malha to load Malha.
	 * @param rotas the rotas to load Rotas.
	 */
	public void encontrarDestino(Localizacao localizacao, Rotas rotas);
	
	/**
	 * Processa todas as rotas possíveis e retorna a melhor rota de cada destino.
	 *
	 */
	public Rotas compararCaminhos();
}
