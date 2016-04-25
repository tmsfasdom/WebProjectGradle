package br.com.tmsfasdom.signup;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import br.com.tmsfasdom.exceptions.UsernameAlreadyInUseException;
import br.com.tmsfasdom.message.Message;
import br.com.tmsfasdom.message.MessageType;
import br.com.tmsfasdom.signin.SignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import br.com.tmsfasdom.modelo.Role;
import br.com.tmsfasdom.modelo.Usuario;
import br.com.tmsfasdom.services.UsuarioService;


@Controller
public class SignupController {

	private UsuarioService usuarioService;
	private final ProviderSignInUtils providerSignInUtils;

	@Autowired
	public SignupController(UsuarioService usuarioService, 
		                    ConnectionFactoryLocator connectionFactoryLocator,
		                    UsersConnectionRepository connectionRepository) {
		this.usuarioService = usuarioService;
		this.providerSignInUtils = new ProviderSignInUtils(connectionFactoryLocator, connectionRepository);
	}

	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public SignupForm signupForm(WebRequest request) {
		Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);
		if (connection != null) {
			request.setAttribute("message", new Message(MessageType.INFO, "Your " + StringUtils.capitalize(connection.getKey().getProviderId()) + " account is not associated with a Spring Social Showcase account. If you're new, please sign up."), WebRequest.SCOPE_REQUEST);
			return SignupForm.fromProviderUser(connection.fetchUserProfile());
		} else {
			return new SignupForm();
		}
	}

	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@Valid SignupForm form, BindingResult formBinding, WebRequest request) {
		if (formBinding.hasErrors()) {
			return null;
		}
		Usuario account = createAccount(form, formBinding);
		if (account != null) {
			SignInUtils.signin(account.getUserName());
			providerSignInUtils.doPostSignUp(account.getUserName(), request);
			return "redirect:/";
		}
		return null;
	}

	// internal helpers
	
	private Usuario createAccount(SignupForm form, BindingResult formBinding) {
		try {
			Role role = new Role("ROLE_ADMIN");
			List<Role> lstRole = new ArrayList<Role>();
			lstRole.add(role);
			Usuario account = new Usuario(form.getUsername(), form.getPassword(), form.getFirstName(), form.getLastName(), lstRole);
			usuarioService.save(account);
			return account;
		} catch (UsernameAlreadyInUseException e) {
			formBinding.rejectValue("username", "user.duplicateUsername", "already in use");
			return null;
		}
	}

}