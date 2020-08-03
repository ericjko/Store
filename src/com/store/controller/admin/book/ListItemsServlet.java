package com.store.controller.admin.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.controller.BaseServlet;
import com.store.service.ItemsServices;

@WebServlet("/admin/list_items")
public class ListItemsServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ItemsServices itemServices = new ItemsServices(entityManager, request, response);
		itemServices.listItems();
		
	}

}
