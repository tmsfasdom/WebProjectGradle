package br.com.tmsfasdom.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.tmsfasdom.modelo.Usuario;
import br.com.tmsfasdom.services.UsuarioService;

@Controller
public class loginController {
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(Usuario usuario, HttpSession session) {
		if (usuarioService.verificaUsuario(usuario)) {
			session.setAttribute("usuarioLogado", usuario);
			return "menu";
		}
		//Usuario user = new Usuario();
		//user.setUserName("fernando");
		//user.setPassword("fernando");
		//usuarioService.saveOrUpdate(user);
		return "redirect:login";
	}
}
