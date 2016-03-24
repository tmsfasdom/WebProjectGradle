package br.com.tmsfasdom.dao;

import java.util.List;
import br.com.tmsfasdom.modelo.Usuario;

public interface UsuarioDao {
	public void saveOrUpdate(Usuario usuario);
	public void delete(int userId);
	public Usuario getUsuario(int userId);
	public List<Usuario> getAllUsuario();
}
