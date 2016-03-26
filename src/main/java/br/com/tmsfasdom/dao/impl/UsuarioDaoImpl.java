package br.com.tmsfasdom.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.tmsfasdom.dao.AbstractDao;
import br.com.tmsfasdom.modelo.Usuario;

@Repository
public class UsuarioDaoImpl extends AbstractDao<Usuario> {

	public UsuarioDaoImpl() {
		super(Usuario.class, Usuario.tableName);
	}
}
