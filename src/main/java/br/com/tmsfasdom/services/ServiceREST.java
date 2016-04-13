package br.com.tmsfasdom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

//import br.com.tmsfasdom.dao.impl.ProcessoDaoImpl;
//import br.com.tmsfasdom.modelo.Chaves;
//import br.com.tmsfasdom.modelo.Processo;
import br.com.tmsfasdom.modelo.Student;
//import br.com.tmsfasdom.modelo.Valores;

@RestController
@RequestMapping("/rest/")
public class ServiceREST {

	@Autowired
	private StudentService studentService;
	//@Autowired
	///ProcessoDaoImpl prdao;
	
	
	
	@RequestMapping(value = "/sayhello", method = RequestMethod.GET)
	@Transactional
	public String sayHello() {
		
		/*Chaves ch = new Chaves("Nome", "Aberta");
		Processo pr = new Processo(1,"testeProcesso", "teste");
		List<Valores> valores = new ArrayList<Valores>();
		Valores vl1 = new Valores("Fernando");
		vl1.setChaves(ch);
		vl1.setProcesso(pr); 
		valores.add(vl1);
		Valores vl2 = new Valores("Lindo");
		vl2.setChaves(ch);
		vl2.setProcesso(pr);
		valores.add(vl2);
		pr.setValores(valores);
		prdao.save(pr);
		*/
		Gson gson = new Gson();
		return gson.toJson("Fernando Lindo");
	}

	@RequestMapping(value = "/somar", method = RequestMethod.GET)
	public String somar() {
		Student stud = studentService.getStudent(28);
		Gson gson = new Gson();
		return gson.toJson(stud);
	}

}
