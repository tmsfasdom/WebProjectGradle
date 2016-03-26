package br.com.tmsfasdom.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class AbstractDao<T> implements InterfaceDao<T>{

	@PersistenceContext
    private EntityManager entityManager;
	private Class<T> entityClass;
    private String tableName;

	public AbstractDao(Class<T> classeDePersistencia, String tableName) {
        this.entityClass = classeDePersistencia;
        this.tableName = tableName;
    }
    
    public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
    
	@Override
	public void save(T t) {
		this.entityManager.persist(t);
	}

	@Override
	public void update(T t) {
		this.entityManager.merge(t);
	}
	
	@Override
	public void delete(int id) {
		this.entityManager.remove(getEntity(id));
	}

	@Override
	public T getEntity(int id)
	{
		return this.entityManager.find(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(){
		Query query = this.entityManager.createQuery("SELECT e FROM " + tableName + " e");
		return (List<T>)query.getResultList();
	}

}
