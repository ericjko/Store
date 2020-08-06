<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Items in ${category.name} - Online Mobile Accessories Store</title>
<link rel="stylesheet" href="css/style.css" >
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	
	<div class="center">
		<h2>${category.name}</h2>
	</div>
	<div align="center" style="width: 80%; margin: 0 auto;">
	<div class="item-group">
		<c:forEach items="${listItems}" var="item">
		<div style="float: left; display: inline-block; margin: 0 auto">
			<div class="item">
				<div>
					<a href="view_item?id=${item.itemId}">
						<img class="item-small" src="data:image/jpg;base64,${item.base64Image}" />
					</a>
				</div>
				<div>
					<a href="view_item?id=${item.itemId}">
						<b>${item.title}</b>
					</a>
				</div>
				<div><b>$${item.price}</b></div>
			</div>
			</div>
		</c:forEach>
	</div>
	</div>
</body>
</html>