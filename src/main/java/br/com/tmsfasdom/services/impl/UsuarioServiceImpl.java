package br.com.tmsfasdom.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.tmsfasdom.dao.UsuarioDao;
import br.com.tmsfasdom.modelo.Usuario;
import br.com.tmsfasdom.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Transactional
	public void saveOrUpdate(Usuario usuario) {
		usuarioDao.saveOrUpdate(usuario);	
	}

	@Transactional
	public void delete(int userId) {
		usuarioDao.delete(userId);
	}

	@Transactional
	public Usuario getUsuario(int userId) {
		return usuarioDao.getUsuario(userId);
	}

	@Transactional
	public List<Usuario> getAllUsuario() {
		return usuarioDao.getAllUsuario();
	}

	@Transactional
	public boolean verificaUsuario(Usuario user) {
		List<Usuario> listaUsuarios = usuarioDao.getAllUsuario();
		for(Usuario usr : listaUsuarios)
		{
			if (usr.getUserName().equalsIgnoreCase(user.getUserName()) && 
					usr.getPassword().contentEquals(user.getPassword()))
			{
				return true;
			}
		}		
		return false;
	}

}
