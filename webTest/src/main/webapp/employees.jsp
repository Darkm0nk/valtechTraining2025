<%@page import="dao.EmployeeInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri ="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th><a></a>Id</th>
		<th>Name</th>
		<th>Age</th>
		<th>Gender</th>
		<th>Salary</th>
		<th>Experience</th>
		<th>Level</th>
		<th>Department ID</th>
		<th>Action</th>
	</tr>
<c:forEach items = "${emps}" var ="e">
	<tr>
		<%-- <td><c:out value="${e.id}"></c:out></td> --%>
	    <td>${e.id}</td> 
		<td>${e.name}</td>
		<td>${e.age}</td>
		<td>${e.gender}</td>
		<td>${e.salary}</td>
		<td>${e.exp}</td>
		<td>${e.level}</td>
		<td>${e.departmentId}</td>
		<td>
			<a href ="employees?operation=Update&id=${e.id}">Update</a>
			<a href ="employees?operation=Delete&id=${e.id}">Delete</a>
		</td>
	</tr>	
</c:forEach>
	<tr>
		<td colspan="7">
			<a href = "employees?operation=new">New Employee</a>
</table>
<hr></hr>
<%-- <table>
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Age</th>
		<th>Gender</th>
		<th>Salary</th>
		<th>Experience</th>
		<th>Level</th>
	</tr>
	
<%
	List<EmployeeInfo> emps = (List<EmployeeInfo>) request.getAttribute("emps");
	for(EmployeeInfo e : emps){
%>	<tr>
	<td><%=e.getId() %></td>
	<td><%=e.getName() %></td>
	<td><%=e.getAge() %></td>
	<td><%=e.getGender() %></td>
	<td><%=e.getSalary() %></td>
	<td><%=e.getExp() %></td>
	<td><%=e.getLevel() %></td>
	</tr>
<%} %>
</table> --%>
</body>
</html>