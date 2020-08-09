package com.store.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.store.entity.Category;

public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category> {

	public CategoryDAO() {
		
	}

	@Override
	public Category create(Category category) {
		
		return super.create(category);
	}

	@Override
	public Category update(Category category) {
		// TODO Auto-generated method stub
		return super.update(category);
	}

	@Override
	public Category get(Object id) {
		
		return super.find(Category.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Category.class, id);
		
	}
 
	@Override
	public List<Category> listAll() {
		
		return super.findWithNamedQuery("Category.findAll");
	}

	@Override
	public long count() {
//		return super.countWithNamedQuery("Category.countAll");
		return 0;
	}

}
