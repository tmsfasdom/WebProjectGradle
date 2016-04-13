package br.com.tmsfasdom.business;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import br.com.tmsfasdom.modelo.Usuario;
import br.com.tmsfasdom.services.UsuarioService;

@Component
public class ProvedorAutenticacao implements AuthenticationProvider {

	@Autowired
	private UsuarioService userService;

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();

		Usuario user = userService.recuperaUsuarioPorLogin(username);

		if (user == null || !user.getUserName().equalsIgnoreCase(username)) {
			throw new BadCredentialsException("Username not found.");
		}

		if (!password.equals(user.getPassword())) {
			throw new BadCredentialsException("Wrong password.");
		}

		Collection<? extends GrantedAuthority> authorities = user.getRoles();

		return new UsernamePasswordAuthenticationToken(user, password, authorities);
	}

	public boolean supports(Class<?> arg0) {
		return true;
	}

}
