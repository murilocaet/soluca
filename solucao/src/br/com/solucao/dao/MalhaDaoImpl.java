package br.com.solucao.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import br.com.solucao.models.Malha;

/**
 * Classe: MalhaDaoImpl.<br>
 * Descrição: Classe responsável por implementar os métodos que irá persistir as Malhas.<br><br>
 * 
 * 
 * Métodos:
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
public class MalhaDaoImpl implements MalhaDao{

	/** 
    * Construtor da Classe.
    * 
    */
	public MalhaDaoImpl() {
		
	}

	/* (non-Javadoc)
	 * @see br.com.solucao.dao.MalhaDao#saveMalha(br.com.solucao.models.Malha)
	 */
	public void saveMalha(Malha malha) {
		salvarJSON(malha);
	}
	
	/* (non-Javadoc)
	 * @see br.com.solucao.dao.MalhaDao#loadMalha(br.com.solucao.models.Malha)
	 */
	public Malha loadMalha(Malha malha) {
		return lerJSON(malha);
	}
	
	/* (non-Javadoc)
	 * @see br.com.solucao.dao.MalhaDao#salvarJSON(br.com.solucao.models.Malha)
	 */
	public void salvarJSON(Malha malha) {
		FileWriter writeFile = null;

		try {
			String nome = "solucao_malha_"+malha.getNome()+".json";
			
			writeFile = new FileWriter(new File(nome));
			writeFile.write(malha.toString());
			writeFile.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see br.com.solucao.dao.MalhaDao#lerJSON(br.com.solucao.models.Malha)
	 */
	public Malha lerJSON(Malha malha) {
		Malha nova = null;
		ObjectMapper mapper = new ObjectMapper();
		String nome = "solucao_malha_"+malha.getNome()+".json";
		try {
			File file = new File(nome);
			if(file.exists()) {
				nova = mapper.readValue(file, Malha.class);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return nova;
	}
}
