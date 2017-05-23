<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
<title>SGP - ajout collaborateur</title>
</head>
<body class="container">


	 	<%-- <p class="alert alert-danger">${ !empty status ? "Erreur !" : '' }</p>  --%>
	
	<c:if test="${ erreur == 1 }">
	
	<p class="alert alert-danger"> ${ errorMessage } </p>
	
	</c:if>


	<a href="lister" class="btn btn-lg btn-danger"><span
		class="glyphicon glyphicon-arrow-left"></span> Annuler</a>
	<br>
	<br>
	<br>
	<div>

		<form class="form-horizontal jumbotron" method="post">
			<fieldset>

				<!-- Form Name -->
				<legend>Nouveau Collaborateur</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="nom">Nomddd:</label>
					<div class="col-md-2">
						<input id="nom" name="nom" type="text" placeholder="Nom"
							class="form-control input-md">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="prenom">Prenom:</label>
					<div class="col-md-2">
						<input id="prenom" name="prenom" type="text" placeholder="Prenom"
							class="form-control input-md" required="">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="datedenaissance">Date
						de naissance</label>
					<div class="col-md-2">
						<input id="datedenaissance" name="datedenaissance" type="date"
							placeholder="" class="form-control input-md" required="">

					</div>
				</div>

				<!-- Textarea -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="adresse">Adresse:</label>
					<div class="col-md-4">
						<textarea class="form-control" id="adresse" name="adresse"></textarea>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="numsecu">Numéro
						de sécurité sociale</label>
					<div class="col-md-2">
						<input id="numsecu" name="numsecu" type="text" placeholder=""
							class="form-control input-md" required="">

					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="singlebutton">Single
						Button</label>
					<div class="col-md-4">
						<button id="singlebutton" name="singlebutton"
							class="btn btn-primary">Créer</button>
					</div>
				</div>

			</fieldset>
		</form>
	</div>

</body>
</html>