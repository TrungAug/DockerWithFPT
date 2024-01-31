<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="add" modelAttribute="toDoItem">
		<form:label path="content">Content</form:label>
		<form:input path="content"/>
		<br><br>
		<form:label path="important">Important</form:label>
		<form:input path="important"/>
		<br><br>
		<form:errors></form:errors>
		<form:button>Submit</form:button>		
	</form:form>
	
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Content</th>
				<th>Important</th>
			</tr>			
		</thead>
		<tbody>
			<c:forEach var="item" items="${list}">
				<tr>
					<td>${item.id}</td>
					<td>${item.content}</td>
					<td>${item.important}</td>
				</tr>			
			</c:forEach>
		</tbody>		
	</table>
	<div class="sort">
		<a href="?sortAsc=true">Sort ASC</a>
		<a href="?sortAsc=false">Sort DESC</a>
	</div>
</body>
</html>