package br.com.tmsfasdom.services;

import java.util.List;

import br.com.tmsfasdom.modelo.Usuario;

public interface UsuarioService {
	public void saveOrUpdate(Usuario usuario);
	public void delete(int userId);
	public Usuario getUsuario(int userId);
	public List<Usuario> getAllUsuario();
	public boolean verificaUsuario(Usuario user);
}
