package br.com.tmsfasdom.services;

import java.util.List;

import br.com.tmsfasdom.modelo.Usuario;

public interface UsuarioService {
	public void save(Usuario usuario);
	public void update(Usuario usuario);
	public void delete(int userId);
	public Usuario getUsuario(int userId);
	public List<Usuario> getAllUsuario();
	boolean verificaUsuario(Usuario user);
	public Usuario recuperaUsuarioPorLogin(String login);
}
