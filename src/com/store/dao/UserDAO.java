package com.store.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.store.entity.Users;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users> {

	public UserDAO() {
		
	}
	public Users create(Users user) {
		return super.create(user);
	}

	@Override
	public Users update(Users user) {
		
		return super.update(user);
	}

	@Override
	public Users get(Object id) {
		
		return null;
	}

	@Override
	public void delete(Object userid) {
		// TODO Auto-generated method stub
		super.delete(Users.class, userid);
	}

	@Override
	public List<Users> listAll() {

		return super.findWithNamedQuery("Users.findAll");
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
