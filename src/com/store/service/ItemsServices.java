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
import com.store.entity.Items;

public class ItemsServices {
	
	private EntityManager entityManager;
	private ItemsDAO itemDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public ItemsServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		super();
		this.entityManager = entityManager;
		this.request = request;
		this.response = response;
		itemDAO = new ItemsDAO(entityManager);
	}

	public void listItems() throws ServletException, IOException {
		List<Items> listItems = itemDAO.listAll();
		request.setAttribute("listItems", listItems);
		
		String listPage = "item_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}
}
