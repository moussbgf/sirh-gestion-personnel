<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<c:url value='/bootstrap-3.3.7-dist/css/bootstrap.css'></c:url>">
<link rel="stylesheet"
	href="<c:url value='/bootstrap-3.3.7-dist/js/bootstrap.js'></c:url>">
<title>SGP - Statistiques</title>
</head>
<body class="container">

	<h1>Statistiques</h1>

	<br>
	<br>
	<br>
		
		<a href="lister" class="btn btn-primary"><span class="glyphicon glyphicon-arrow-left"></span> retour</a>
	<br>
	<br>
	<br>
	
	<table class="table table-bordered table-striped">
	
		<thead>
		
			<th>Id</th>
			<th>Chemin</th>
			<th>Temps d'execution</th>
		
		</thead>
		
		<c:forEach var="visite" items="${ listeVisites }">
		
		<tr>
		
			<td>${ visite.id }</td>
			<td>${ visite.chemin }</td>
			<td>${ visite.tempsExecution }</td>
		
		</tr>

		</c:forEach>
		
		
	
	</table>

</body>
</html>