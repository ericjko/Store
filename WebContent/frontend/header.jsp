<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div align="center">

<div align="center">
<h1>Mobile Accessories</h1>
</div>
<div align="center">
<input type="text" name="keyword" size="50"/>
<input type="button" value="Search" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="login">Sign In</a>
<a href="register">Register</a> 
<a href="view_cart">Cart</a>
</div>
<div>&nbsp;</div>
<div>
<c:forEach var="category" items="${listCategory}" varStatus="status">
<a href="view_category?id=${category.categoryId}">
	<b><c:out value="${category.name}"/></b>
	</a>
	&nbsp; |
</c:forEach>
</div>
</div>