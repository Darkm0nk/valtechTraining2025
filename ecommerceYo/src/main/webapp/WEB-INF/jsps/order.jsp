<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- ${customer.name} --%>

		<table>

		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Description</td>
		</tr>
		<c:forEach items="${item}" var="i">
			<tr>
				<td>${i.id}</td>
				<td>${i.name}</td>
				<td>${i.description}</td>
			</tr>
		</c:forEach>
		</table>
		<br/>
		<form action="order" method="post">
		Order Id : <input type="text" name="id">
		Customer Id : <input type="text" name="custId"><br/><br/>
		Item Id : <input type="text" name="itemId"><br/><br/>
		Quantity : <input type="text" name="qty"><br/><br/>
		<input type = "submit" value="Submit"/>
		<%-- <h2>Place orders</h2>
		
		<tr>
			<td>Id</td>
			<td><input type="text" name="ids" id="ids"/></td>
		</tr>
		<tr>
			<td>Quantity</td>
			<td><input type="text" name="qty" id="qty"/></td>
		</tr>
		<tr>
			<td colspan=2><input type="submit" name="submit" value="add"/></td>
		</tr>
		<c:forEach items="${itemIds}" var="i">
		<tr>
			<td>ID  : ${i}</td>
		</tr>
		</c:forEach>
		<c:forEach items="${itemQty}" var="i">
		<tr>
			<td>Qty  : ${i}</td>
		</tr>
		</c:forEach> --%>
		</form>
	
	
	
</body>
</html>