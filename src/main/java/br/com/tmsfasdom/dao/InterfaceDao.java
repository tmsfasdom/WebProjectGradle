package br.com.tmsfasdom.dao;

import java.util.List;

public interface InterfaceDao<T> {

	public void delete(int id);
	public T getEntity(int id);
	public List<T> getAll();
	public void save(T t);
	public void update(T t);
	
}
