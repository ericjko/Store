package com.store.controller.frontend;

import com.store.controller.BaseServlet;
import com.store.service.ItemsServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewItemsByCategoryServlet
 */
@WebServlet("/view_category")
public class ViewItemsByCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ViewItemsByCategoryServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		ItemsServices itemServices = new ItemsServices(entityManager, request, response);
		itemServices.listItemsByCategory();
	}

}