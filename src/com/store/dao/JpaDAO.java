package com.store.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.store.entity.Category;
import com.store.entity.Users;

public class JpaDAO<E> {
	protected EntityManager entityManager;
	
	public JpaDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public E create(E entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.flush();
		entityManager.refresh(entity);
		
		entityManager.getTransaction().commit();
		return entity;
	}
	
	public E update(E entity) {
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
		return entity;
	}

	public E find(Class<E> type, Object id) {
		E entity = entityManager.find(type, id);
		
		if (entity != null) {
			entityManager.refresh(entity);
		}
		return entity;
	}

	public void delete(Class<E> type, Object id) {
		entityManager.getTransaction().begin();
		
		Object reference = entityManager.getReference(type, id);
		entityManager.remove(reference);
		
		entityManager.getTransaction().commit();
		// TODO Auto-generated method stub
		
	}

	public List<E> findWithNamedQuery(String queryName) {
		Query query = entityManager.createNamedQuery(queryName);
		
		return query.getResultList();
	}
	public List<E> findWithNamedQuery(String queryName, String paramName, Object paramValue) {
		
		Query query = entityManager.createNamedQuery(queryName);
		
		query.setParameter(paramName, paramValue);
		
		List<E> result = query.getResultList();
		
		
		
		return result;
	}
	
}
