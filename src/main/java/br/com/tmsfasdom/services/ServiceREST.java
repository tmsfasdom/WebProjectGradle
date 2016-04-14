package br.com.tmsfasdom.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.tmsfasdom.dao.impl.ProcessoDaoImpl;
import br.com.tmsfasdom.dao.impl.UsuarioDaoImpl;
import br.com.tmsfasdom.modelo.Chaves;
import br.com.tmsfasdom.modelo.Processo;
import br.com.tmsfasdom.modelo.Role;
//import br.com.tmsfasdom.dao.impl.ProcessoDaoImpl;
//import br.com.tmsfasdom.modelo.Chaves;
//import br.com.tmsfasdom.modelo.Processo;
import br.com.tmsfasdom.modelo.Student;
import br.com.tmsfasdom.modelo.Usuario;
import br.com.tmsfasdom.modelo.Valores;

@RestController
@RequestMapping("/rest/")
public class ServiceREST {

	@Autowired
	private StudentService studentService;
	@Autowired
	private ProcessoDaoImpl prdao;
	@Autowired
	private UsuarioDaoImpl userdao;
	
	
	
	@RequestMapping(value = "/sayhello", method = RequestMethod.GET)
	@Transactional
	public String sayHello() {
				
		Gson gson = new Gson();
		return gson.toJson("Fernando Lindo");
	}
	
	
	@RequestMapping(value = "/criaProcesso", method = RequestMethod.GET)
	@Transactional
	public String criaProcesso() {
		
		Chaves ch = new Chaves("Nome", "Aberta");
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
		
		Gson gson = new Gson();
		return gson.toJson("Um processo com Chave e valores criado com sucesso");
	}
	
	@RequestMapping(value = "/criaUsuarioAdmin", method = RequestMethod.GET)
	@Transactional
	public String criaUsuarioAdmin() {
		
		Usuario user = new Usuario();
		user.setUserName("usuario");
		user.setPassword("usuario");
		List<Role> roles = new ArrayList<Role>();
		roles.add(new Role("ROLE_ADMIN"));
		user.setRoles(roles);
		userdao.save(user);
		
		Gson gson = new Gson();
		return gson.toJson("Usuario admin criado com sucesso");
	}
	@RequestMapping(value = "/somar", method = RequestMethod.GET)
	public String somar() {
		Student stud = studentService.getStudent(28);
		Gson gson = new Gson();
		return gson.toJson(stud);
	}

}
