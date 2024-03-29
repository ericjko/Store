package com.store.dao;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.store.entity.Category;

class CategoryDAOTest {
	

	private static CategoryDAO categoryDao;
	
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		categoryDao = new CategoryDAO();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
	}

	@Test
	void testCreateCategory() {
		Category newCat = new Category("Java");
		Category category = categoryDao.create(newCat);
		
		assertTrue(category != null && category.getCategoryId() > 0);
	}

	@Test
	void testUpdateCategory() {
		
	}

	@Test
	void testGet() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteObject() {
		fail("Not yet implemented");
	}

	@Test
	void testListAll() {
		fail("Not yet implemented");
	}

	@Test
	void testCount() {
		fail("Not yet implemented");
	}

}
