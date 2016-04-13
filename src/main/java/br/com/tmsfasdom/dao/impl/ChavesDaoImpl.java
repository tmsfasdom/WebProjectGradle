package br.com.tmsfasdom.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.tmsfasdom.dao.AbstractDao;
import br.com.tmsfasdom.modelo.Chaves;

@Repository
public class ChavesDaoImpl extends AbstractDao<Chaves> {

	public ChavesDaoImpl() {
		super(Chaves.class, Chaves.tableName);
	}
	
}

