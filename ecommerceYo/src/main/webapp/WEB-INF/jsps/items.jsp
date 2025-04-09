<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="item" method="post">
		<Table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" id="id"/></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" id="name"/></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" name="description" id="description"/></td>
			</tr>
			<tr>
				<td>Reorder Quantity</td>
				<td><input type="text" name="reorderQty" id="reorderQty"/></td>
			</tr>
			<tr>
				<td>Maximum Quantity</td>
				<td><input type="text" name="maxQty" id="maxQty"/></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="Submit"/></td>
				<td><input name="cancel" type="submit" value="Cancel"/></td>
			</tr>
		</Table>
	</form>
</body>
</html>