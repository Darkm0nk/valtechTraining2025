<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="register" method="post">
		<table>
		<tr>
				<td>ID</td>
				<td><input name="id" id="id"/></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input name="name" id="name"/></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input name="age" id="age"/></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input name="address" id="address"/></td>
			</tr>
			<tr>
				<td>Permanent Address</td>
				<td><input name="permanentAddress" id="permanentAddress"/></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="Submit"/></td>
				<td><input name="cancel" type="submit" value="Cancel"/></td>
			</tr>
		</table>
	</form>
</body>
</html>