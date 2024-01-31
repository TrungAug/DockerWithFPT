<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Content</th>
				<th>Important</th>
			</tr>			
		</thead>
		<!--${list.content}=> List<T> getContent(); trong Slice.class -->
		<tbody>
			<c:forEach var="item" items="${list.content}">
				<tr>
					<td>${item.id}</td>
					<td>${item.content}</td>
					<td>${item.important}</td>
				</tr>			
			</c:forEach>
		</tbody>		
	</table>
	<div>
		<a href="?page=0">First</a>
		
		<c:if test="${not list.first}">
			<a href="?page=${list.number-1}">Prev</a>
		</c:if>
		<c:if test="${not list.last}">
			<a href="?page=${list.number+1}">Next</a>
		</c:if>
		
		<a href="?page=${list.totalPages}">Last</a>
	</div>
</body>
</html>