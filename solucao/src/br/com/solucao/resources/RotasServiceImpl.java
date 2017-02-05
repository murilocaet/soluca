package br.com.solucao.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.solucao.controler.RotaController;
import br.com.solucao.controler.RotaControllerImpl;
import br.com.solucao.models.Distribuicao;
import br.com.solucao.models.Malhas;

/**
 * Classe: RotasServiceImpl.<br>
 * Descrição: Classe responsável por implementar os serviços que manipulam as Rotas.<br><br>
 * 
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
@Path("/rotas")
public class RotasServiceImpl implements RotasService{

	/**
	 * Atributo rotaController
	 */
	private RotaController rotaController = new RotaControllerImpl();
	
	/* (non-Javadoc)
	 * @see br.com.solucao.resources.RotasService#obterRotas(br.com.solucao.models.Malhas)
	 */
	@Path("/obterRotas")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Distribuicao obterRotas(Malhas malhas) {
		return rotaController.processarDistribuicao(malhas);
	}
}
