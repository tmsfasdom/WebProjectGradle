package br.com.tmsfasdom.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.tmsfasdom.dao.UsuarioDao;
import br.com.tmsfasdom.modelo.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	private SessionFactory session;

	public UsuarioDaoImpl() {

	}

	@Autowired
	public UsuarioDaoImpl(SessionFactory sessionFactory) {
		this.session = sessionFactory;
	}

	@Override
	public void saveOrUpdate(Usuario usuario) {
		session.getCurrentSession().saveOrUpdate(usuario);
	}

	@Override
	public void delete(int userId) {
		session.getCurrentSession().delete(getUsuario(userId));

	}

	@Override
	public Usuario getUsuario(int userId) {
		return (Usuario) session.getCurrentSession().get(Usuario.class, userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getAllUsuario() {
		return (List<Usuario>)session.getCurrentSession().createQuery("from Usuario").list();
	}

}
