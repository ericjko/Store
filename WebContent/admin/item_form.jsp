<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Create New Item</title>
	
	<link rel="stylesheet" href="../css/style.css" >
	<link rel="stylesheet" href="../css/jquery-ui.min.css">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="..//css/richtext.min.css">	
	
	<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
	
	<script type="text/javascript" src="../js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="../js/jquery.richtext.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	
	<div align="center">
		<h2 class="pageheading">
			<c:if test="${item != null}">
				Edit Item
			</c:if>
			<c:if test="${item == null}">
				Create New Item
			</c:if>
		</h2>
	</div>
	
	<div align="center">
		<c:if test="${item != null}">
			<form action="update_item" method="post" id="itemForm" enctype="multipart/form-data">
			<input type="hidden" name="bookId" value="${book.bookId}">
		</c:if>
		<c:if test="${item == null}">
			<form action="create_item" method="post" id="itemForm" enctype="multipart/form-data">
		</c:if>
		
		<table class="form">
			<tr>
				<td>Category:</td>
				<td>
					<select name="category">
						<c:forEach items="${listCategory}" var="category">
							<c:if test="${category.categoryId eq item.category.categoryId}">
								<option value="${category.categoryId}" selected>
							</c:if>
							<c:if test="${category.categoryId ne item.category.categoryId}">
								<option value="${category.categoryId}">
							</c:if>							
								${category.name}
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right">Title:</td>
				<td align="left"><input type="text" id="title" name="title" size="20" value="${book.title}" /></td>
			</tr>
			<tr>
				<td align="right">Publish Date:</td>
				<td align="left"><input type="text" id="publishDate" name="publishDate" size="20" 
					value="<fmt:formatDate pattern='MM/dd/yyyy' value='${book.publishDate}' />" /></td>
			</tr>			
			<tr>
				<td align="right">Item Image:</td>
				<td align="left">
					<input type="file" id="itemImage" name="itemImage" size="20" /><br/>
					<img id="thumbnail" alt="Image Preview" style="width:20%; margin-top: 10px"
						src="data:image/jpg;base64,${item.base64Image}"
					 />
				</td>
			</tr>
			<tr>
				<td align="right">Price:</td>
				<td align="left"><input type="text" id="price" name="price" size="20" value="${item.price}" /></td>
			</tr>
			<tr>
				<td align="right">Description:</td>
				<td align="left">
					<textarea rows="5" cols="50" name="description" id="description">${item.description}</textarea>
				</td>
			</tr>										
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">Save</button>&nbsp;&nbsp;&nbsp;
					<button id="buttonCancel">Cancel</button>
				</td>
			</tr>				
		</table>
		</form>
	</div>

	<%-- <jsp:directive.include file="footer.jsp" /> --%>
</body>
<script type="text/javascript">

	$(document).ready(function() {
		$('#publishDate').datepicker();
		$('#description').richText();
		
		$('#itemImage').change(function() {
			showImageThumbnail(this);
		});
		
		
		$("#itemForm").validate({
			rules: {
				category: "required",
				title: "required",
				publishDate: "required",
				
				<c:if test="${item == null}">
				itemImage: "required",
				</c:if>
				
				price: "required",
				description: "required",
			},
			
			messages: {
				category: "Please select a category for the item",
				title: "Please enter title of the item",
				publishDate: "Please enter publish date of the item",
				itemImage: "Please choose an image of the item",
				price: "Please enter price of the item",
				description: "Please enter description of the item"
			}
		});
		
		$("#buttonCancel").click(function() {
			history.go(-1);
		});
	});
	
	function showImageThumbnail(fileInput) {
		var file = fileInput.files[0];
		
		var reader = new FileReader();
		
		reader.onload = function(e) {
			$('#thumbnail').attr('src', e.target.result);
		};
		
		reader.readAsDataURL(file);
	}
</script>
</html>