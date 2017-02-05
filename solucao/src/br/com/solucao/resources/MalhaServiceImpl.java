package br.com.solucao.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.solucao.controler.MalhaController;
import br.com.solucao.controler.MalhaControllerImpl;
import br.com.solucao.models.Malhas;

/**
 * Classe: MalhaServiceImpl.<br>
 * Descri��o: Classe respons�vel por implementar os servi�os que manipulam as Malhas.<br><br>
 * 
 * 
 * M�todos:
 * <ul>
 * <li>carregarMalhas(Malhas malhas)
 * </ul>
 * 
 * @author      Murilo Costa
 * @version     1.0
 * @since       1.0
 */
@Path("/malhas")
public class MalhaServiceImpl implements MalhaService{

	/**
	 * Atributo malhaController
	 */
	private MalhaController malhaController = new MalhaControllerImpl();
	
	/* (non-Javadoc)
	 * @see br.com.solucao.resources.MalhaService#carregarMalhas(br.com.solucao.models.Malhas)
	 */
	@Path("/carregarMalhas")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Malhas carregarMalhas(Malhas malhas) {
		return malhaController.processarMalhas(malhas);
	}
}
