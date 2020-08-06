package com.store.controller.frontend;

import com.store.controller.BaseServlet;
import com.store.service.ItemsServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/view_item")
public class ViewItemServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;


    public ViewItemServlet() {
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemsServices itemServices = new ItemsServices(entityManager, request, response);
		itemServices.viewBookDetail();
		
	}

}
