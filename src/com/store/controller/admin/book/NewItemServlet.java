package com.store.controller.admin.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.controller.BaseServlet;
import com.store.service.ItemsServices;


@WebServlet("/admin/new_item")
public class NewItemServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ItemsServices itemServices = new ItemsServices(entityManager, request, response);
		itemServices.showItemNewForm();
	}

}
