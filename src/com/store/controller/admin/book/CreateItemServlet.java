package com.store.controller.admin.book;

import com.store.controller.BaseServlet;
import com.store.service.ItemsServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateItemServlet
 */
@WebServlet("/admin/create_item")
@MultipartConfig(
		fileSizeThreshold = 1024 * 10,	// 10 KB
		maxFileSize = 1024 * 300,		// 300 KB
		maxRequestSize = 1024 * 1024	// 1 MB 
)
public class CreateItemServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public CreateItemServlet() {
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ItemsServices itemServices = new ItemsServices(entityManager, request, response);
		itemServices.createItem();
	}

}
