<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/js/bootstrap.js">
<title>SGP - liste collaborateur</title>
</head>

<body class="jumbotron">

	<h1>Les collaborateurs</h1>

	<a href="nouveau" class="btn btn-lg btn-primary"><span
		class="glyphicon glyphicon-user"></span> nouveau</a>

	<div>
		<ul>

			<%
				List<Collaborateur> collaborateurs = (List<Collaborateur>) request.getAttribute("collaborateurs");

				for (Collaborateur collab : collaborateurs) {
			%>

			<li>Matricule : <%=collab.getMatricule()%> <br> Nom : <%=collab.getNom()%>
				<br> Prenom : <%=collab.getPrenom()%><br> Date de
				Naissance : <%=collab.getDateDeNaissance()%><br> Adresse : <%=collab.getAdresse()%>
				<br> Numero de séurité sociale : <%=collab.getNumSecu()%><br>


				<br> <br>

			</li>

			<%
				}
			%>

		</ul>
	</div>




</body>

</html>