<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${item.title}- Online Items Store</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div class="center">
		<table class="item">
			<tr>
				<td colspan="3" align="left">
					<p id="item-title">${item.title}</p>
				</td>
			</tr>
			<tr>
				<td rowspan="2">
					<img class="item-large" src="data:image/jpg;base64,${item.base64Image}" width="240" height="300" />
				</td>
				<td valign="top" rowspan="2" width="20%">
					<h2>$${item.price}</h2>
					<br/><br/>
					<button id="buttonAddToCart">Add to Cart</button>
				</td>
			</tr>
			<tr>
				<td id="description">
					${item.description}
				</td>
			</tr>
			<tr><td>&nbsp;</td></tr>
		</table>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			
			$("#buttonAddToCart").click(function() {
				window.location = 'add_to_cart?item_id=' + ${item.itemId};
			});				
		});
	</script>
</body>
</html>