<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Projects list</title>
</head>
<body>
	<h1>Project list</h1>
	<table>
	<c:forEach var="project" items="${projects}" varStatus="i">
	<tr>
		<td>#${i.index + 1}</td>
		<td><img width="100" height="auto"  src="${project.imageUrl}" /></td>
		<td>${project.description}</td>
		<td><button type="button" onclick="onRemove(${project.id})">Remove</button></td>
		<td><a href="projects/${project.id}"><button type="button">Edit</button></a></td>
	</tr>
	</c:forEach>
	</table>
	
	<a href="addProject.html"> Add a Project</a>
</body>
<script src="https://code.jquery.com/jquery-3.1.0.min.js" integrity="sha256-cCueBR6CsyA4/9szpPfrX3s49M9vUU5BgtiJj06wt/s=" crossorigin="anonymous"></script>
<script src="js/project-detail.js"></script>
</html>