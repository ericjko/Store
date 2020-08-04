package com.store.controller.frontend;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.controller.BaseServlet;

import com.store.dao.CategoryDAO;
import com.store.dao.ItemsDAO;
import com.store.entity.Category;
import com.store.entity.Items;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/")
public class HomeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDAO categoryDAO = new CategoryDAO(entityManager);
		List<Category> listCategory = categoryDAO.listAll();
		request.setAttribute("listCategory", listCategory);
		
//		ItemsDAO bookDAO = new ItemsDAO();
//		
//		List<Items> listNewBooks = bookDAO.listNewBooks();
//		List<Items> listBestSellingBooks = bookDAO.listBestSellingBooks();
//		List<Items> listFavoredBooks = bookDAO.listMostFavoredBooks();
		
//		request.setAttribute("listNewBooks", listNewBooks);
//		request.setAttribute("listBestSellingBooks", listBestSellingBooks);
//		request.setAttribute("listFavoredBooks", listFavoredBooks);
//		
		String homepage = "frontend/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(homepage);
		dispatcher.forward(request, response);
	}


}
