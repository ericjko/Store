package com.store.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.store.entity.Category;
import com.store.entity.Items;

public class ItemsDAO extends JpaDAO<Items> implements GenericDAO<Items> {

	public ItemsDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Items create(Items itemId) {
		itemId.setLastUpdateTime(new Date());
		return super.create(itemId);
	}

	@Override
	public Items update(Items itemId) {
		itemId.setLastUpdateTime(new Date());
		return super.update(itemId);
	}

	@Override
	public Items get(Object itemId) {
		
		return super.find(Items.class, itemId);
	}

	@Override
	public void delete(Object itemId) {
		super.delete(Items.class, itemId);
		
	}

	@Override
	public List<Items> listAll() {
		
		return super.findWithNamedQuery("Items.findAll");
	}
	
	public Items findByTitle(String title) {
		List<Items> result = super.findWithNamedQuery("Items.findByTitle", "title", title);
		
		if (!result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}
	public List<Items> listByCategory(int categoryId) {
		
		return super.findWithNamedQuery("Items.findByCategory", "catId", "categoryId");
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
