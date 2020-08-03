//package com.store.dao;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import com.store.entity.Category;
//import com.store.entity.Items;
//
//class ItemsDAOTest {
//
//	private static ItemsDAO itemDao;
//	
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//		itemDao = new ItemsDAO();
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//		itemDao.close();
//	}
//
//	@Test
//	public void testCreateItems() throws ParseException, IOException {
//		Items newItem = new Items();
//		
//		Category category = new Category("Advanced Java");
//		category.setCategoryId(2);
//		newItem.setCategory(category );
//		
//		newItem.setTitle("Effective Java (2nd Edition)");
//		
//		newItem.setDescription("New coverage of generics, enums, annotations, autoboxing");
//		newItem.setPrice(38.87f);
//		
//		
////		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");		
//	
//		
//		String imagePath = "D:\\BookStoreProject\\dummy-data\\books\\Effective Java.JPG";
//		
//		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
//		newItem.setImage(imageBytes);
//		
//		Items createdBook = itemDao.create(newItem);
//		
//		assertTrue(createdBook.getItemId() > 0);
//	}
//
//}
