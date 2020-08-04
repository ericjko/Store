package com.store.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.dao.CategoryDAO;
import com.store.dao.ItemsDAO;
import com.store.entity.Category;
import com.store.entity.Items;

public class ItemsServices {
	
	private EntityManager entityManager;
	private ItemsDAO itemDAO;
	private CategoryDAO categoryDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public ItemsServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		super();
		this.entityManager = entityManager;
		this.request = request;
		this.response = response;
		itemDAO = new ItemsDAO(entityManager);
		categoryDAO = new CategoryDAO(entityManager);
	}

	public void listItems() throws ServletException, IOException {
		List<Items> listItems = itemDAO.listAll();
		request.setAttribute("listItems", listItems);
		
		String listPage = "item_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}

	public void showItemNewForm() throws ServletException, IOException {
		List<Category> listCategory = categoryDAO.listAll();
		request.setAttribute("listCategory", listCategory);
		
		String newPage = "item_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(newPage);
		requestDispatcher.forward(request, response);
		
	}
}
