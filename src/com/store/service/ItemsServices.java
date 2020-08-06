package com.store.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
		listItems(null);
	}

	public void listItems(String message) throws ServletException, IOException {
		List<Items> listItems = itemDAO.listAll();
		request.setAttribute("listItems", listItems);
		
		if (message!= null) {
			request.setAttribute("message", message);
		}
		
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

	public void createItem() throws ServletException, IOException {
		
		Integer categoryId = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		float price = Float.parseFloat(request.getParameter("price"));
		
		System.out.println("Category ID: " + categoryId);
		System.out.println("title: " + title);
		System.out.println("description: " + description);
		System.out.println("price: " + price);
		
		Items newItem = new Items();
		newItem.setTitle(title);
		newItem.setDescription(description);
		
		Category category = categoryDAO.get(categoryId);
		newItem.setCategory(category);
		
		newItem.setPrice(price);
		
		Part part = request.getPart("itemImage");
		
		if (part != null && part.getSize() > 0) {
			long size = part.getSize();
			byte[] imageBytes = new byte[(int) size];
			
			InputStream inputStream = part.getInputStream();
			inputStream.read(imageBytes);
			inputStream.close();
			
			newItem.setImage(imageBytes);
		}
		
		Items createdItem = itemDAO.create(newItem);
		
		if(createdItem.getItemId() > 0) {
			String message = "A new book has been created successfully";
			request.setAttribute("message", message);
			listItems();
			
			
		}
		
		
		
//		String title = request.getParameter("title");
//		
//		Items existItem = itemDAO.findByTitle(title);
//		
//		if (existItem != null) {
//			String message = "Could not create new item because the title '"
//					+ title + "' already exists.";
//			listItems(message);
//			return;
//		}
//		
//		Items newItem = new Items();
//		readItemFields(newItem);
//		
//		Items createdItem = itemDAO.create(newItem);
//		
//		if (createdItem.getItemId() > 0) {
//			String message = "A new item has been created successfully.";
//			listItems(message);
//		}
	}
//	public void readItemFields(Items item) throws ServletException, IOException {
//		String title = request.getParameter("title");
//		String description = request.getParameter("description");
//		float price = Float.parseFloat(request.getParameter("price"));
//		
//		
//		
//		Integer categoryId = Integer.parseInt(request.getParameter("category"));
//		Category category = categoryDAO.get(categoryId);
//		item.setCategory(category);
//		
//		item.setPrice(price);
//		
//		Part part = request.getPart("itemImage");
//		
//		if (part != null && part.getSize() > 0) {
//			long size = part.getSize();
//			byte[] imageBytes = new byte[(int) size];
//			
//			InputStream inputStream = part.getInputStream();
//			inputStream.read(imageBytes);
//			inputStream.close();
//			
//			item.setImage(imageBytes);
//		}
//		
//	}
	public void listItemsByCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		List<Items> listItems = itemDAO.listByCategory(categoryId);
		Category category = categoryDAO.get(categoryId);
		List<Category> listCategory = categoryDAO.listAll();
		
		request.setAttribute("listCategory", listCategory);
		request.setAttribute("listItems", listItems);
		request.setAttribute("category", category);
		
		String listPage = "frontend/items_list_by_category.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
		
	}
	public void viewBookDetail() throws ServletException, IOException {
		Integer itemId = Integer.parseInt(request.getParameter("id"));
		Items item = itemDAO.get(itemId);
		List<Category> listCategory = categoryDAO.listAll();
		request.setAttribute("listCategory", listCategory);
		request.setAttribute("item", item);
		
		String detailPage = "frontend/item_detail.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(detailPage);
		requestDispatcher.forward(request, response);
		
		
	}
	
}
