package br.com.solucao.bo;

import br.com.solucao.dao.MalhaDao;
import br.com.solucao.dao.MalhaDaoImpl;
import br.com.solucao.models.Malha;


/**
 * Classe: MalhaBoImpl.<br>
 * Descrição: Classe responsável por implementar os métodos que irá intermediar as chamadas de persistências das Malhas.<br><br>
 * 
 * Atributos:
 * <ul>
 * <li>malhaDao MalhaDao
 * </ul>
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
public class MalhaBoImpl implements MalhaBo {

	/**
	 * Atributo malhaDao
	 */
	private MalhaDao malhaDao = new MalhaDaoImpl();
	
	/** 
    * Construtor da Classe.
    * 
    */
	public MalhaBoImpl() {
	}
	
	/* (non-Javadoc)
	 * @see br.com.solucao.bo.MalhaBo#saveMalha(br.com.solucao.models.Malha)
	 */
	public void saveMalha(Malha malha) {
		malhaDao.saveMalha(malha);
	}
	
	/* (non-Javadoc)
	 * @see br.com.solucao.bo.MalhaBo#loadMalha(br.com.solucao.models.Malha)
	 */
	public Malha loadMalha(Malha malha) {
		return malhaDao.loadMalha(malha);
	}
}
