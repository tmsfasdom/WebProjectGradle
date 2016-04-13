package br.com.tmsfasdom.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.User;

import br.com.tmsfasdom.modelo.Role;
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

		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

		List<Role> listRoles = user.getRoles();
		for (Role r : listRoles) {
			authorities.add(new SimpleGrantedAuthority(r.getName()));
		}
		User us = new User(user.getUserName(), user.getPassword(), authorities);
		return new UsernamePasswordAuthenticationToken(us, password, authorities);
	}

	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
