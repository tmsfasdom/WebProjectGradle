package br.com.tmsfasdom.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.tmsfasdom.dao.impl.UsuarioDaoImpl;
import br.com.tmsfasdom.exceptions.UsernameAlreadyInUseException;
import br.com.tmsfasdom.modelo.Usuario;
import br.com.tmsfasdom.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDaoImpl usuarioDao;

	// @Autowired
	/// public UsuarioServiceImpl(UsuarioDaoImpl usuarioDao) {
	// this.usuarioDao = usuarioDao;
	// }

	@Transactional
	public void save(Usuario usuario) throws UsernameAlreadyInUseException {
		try{
		usuarioDao.save(usuario);
		}
		catch(DuplicateKeyException e){
			throw new UsernameAlreadyInUseException(usuario.getUserName());
		}
	}

	@Transactional
	public void update(Usuario usuario) {
		usuarioDao.update(usuario);
	}

	@Transactional
	public void delete(int userId) {
		usuarioDao.delete(userId);
	}

	@Transactional
	public Usuario getUsuario(int userId) {
		return usuarioDao.getEntity(userId);
	}

	@Transactional
	public List<Usuario> getAllUsuario() {
		return usuarioDao.getAll();
	}

	public boolean verificaUsuario(Usuario user) {
		List<Usuario> listaUsuarios = usuarioDao.getAll();
		for (Usuario usr : listaUsuarios) {
			if (usr.getUserName().equalsIgnoreCase(user.getUserName())
					&& usr.getPassword().contentEquals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Usuario recuperaUsuarioPorLogin(String login) {
		return usuarioDao.RecuperaUsuarioPorLogin(login);
	}

}
