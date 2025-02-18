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
Counters = ${counters}
Current Department = ${current}
<form action="depts" method="post">
<table>
<tr>
	<td>Id</td>
	<td>${dept.id}</td>
</tr>
<tr>
	<td>Name</td>
	<td>${dept.name}</td>
</tr>
<tr>
	<td>Location</td>
	<td>${dept.location}</td>
</tr>
<tr>
	<td colspan="2">
	<input type ="submit" name ="operation" value ="First"/>
	<input type ="submit" name ="operation" value ="Previous"/>
	<input type ="submit" name ="operation" value ="Next"/>
	<input type ="submit" name ="operation" value ="Last"/>
	</td>
</tr>
</table>
</form>
<form action = "depts" method = "post">
<table>
<tr>
	<td>Name</td>
	<td><input type = "text" name = "name" /></td>

	<td>Age</td>
	<td><input type = "text" name = "age" /></td>

	<td>Salary</td>
	<td><input type = "text" name = "salary" /></td>

	<td>Experience</td>
	<td><input type = "text" name = "exp" /></td>
	
	<td>Level</td>
	<td><input type = "text" name = "level" /></td>
	
	<td>
		<input type ="submit" name = "operation" value="search">
	</td>
	</tr>
</table>
</form>
<table>
<tr>
	<th><a href="depts?column=id&order=<%= request.getParameter("order") != null && request.getParameter("column").equals("id") && request.getParameter("order").equals("asc") ? "desc" : "asc" %>">Id</a></th>
	<th></th>
	<th><a href="depts?column=name&order=<%= request.getParameter("order") != null && request.getParameter("column").equals("name") && request.getParameter("order").equals("asc") ? "desc" : "asc" %>">Name</a></th>
	<th></th>
	<th><a href="depts?column=age&order=<%= request.getParameter("order") != null && request.getParameter("column").equals("age") && request.getParameter("order").equals("asc") ? "desc" : "asc" %>">Age</a></th>
	<th></th>
	<th><a href="depts?column=gender&order=<%= request.getParameter("order") != null && request.getParameter("column").equals("gender") && request.getParameter("order").equals("asc") ? "desc" : "asc" %>">Gender</a></th>
	<th></th>
	<th><a href="depts?column=salary&order=<%= request.getParameter("order") != null && request.getParameter("column").equals("salary") && request.getParameter("order").equals("asc") ? "desc" : "asc" %>">Salary</a></th>
	<th></th>
	<th><a href="depts?column=experience&order=<%= request.getParameter("order") != null && request.getParameter("column").equals("experience") && request.getParameter("order").equals("asc") ? "desc" : "asc" %>">Experience</a></th>
	<th></th>
	<th><a href="depts?column=level&order=<%= request.getParameter("order") != null && request.getParameter("column").equals("level") && request.getParameter("order").equals("asc") ? "desc" : "asc" %>">Level</a></th>
	<th></th>
	<th>Dept_id</th>
</tr>
<c:forEach items = "${employeeByDept}" var = "e">
<tr>
	<td>${e.id}</td> 
	<td></td>
	<td></td> 
	<td>${e.name}</td>
	<td></td>
	<td>${e.age}</td>
	<td></td>
	<td>${e.gender}</td>
	<td></td>
	<td>${e.salary}</td>
	<td></td>
	<td>${e.exp}</td>
	<td></td>
	<td>${e.level}</td>
	<td></td>
	<td>${e.departmentId}</td>
</tr>
</c:forEach>

</table>
</body>
</html>