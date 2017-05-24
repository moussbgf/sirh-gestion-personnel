<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="dev.sgp.entite.Departement"%>

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
<title>SGP - Editer collaborateur</title>
</head>

<body class="container">

<%@include file="../template/header.jsp" %>

	<h2>Editer un collaborateur :</h2>



	<form class="form-horizontal" method="post">
		<fieldset>

			<!-- Form Name -->
			<legend>NOM Prenom - Matricule</legend>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="civilite">Civilité *
					:</label>
				<div class="col-md-2">
					<select id="civilite" name="civilite" class="form-control">
						<option value="1">Mr</option>
						<option value="2">Mme</option>
					</select>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="nom">Nom * : </label>
				<div class="col-md-2">
					<input id="nom" name="nom" value="ok" type="text" placeholder="Nom"
						class="form-control input-md" required="">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="prenom">Prenom * :</label>
				<div class="col-md-2">
					<input id="prenom" name="prenom" value="ok" type="text" placeholder="Prenom"
						class="form-control input-md" required="">

				</div>
			</div>

			<!-- Textarea -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="adresse">Adresse *
					:</label>
				<div class="col-md-4">
					<textarea class="form-control" id="adresse" name="adresse">ok !</textarea>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="numsecu">Numéro
					de sécurité sociale * :</label>
				<div class="col-md-2">
					<input id="numsecu" name="numsecu" value="ok" type="text"
						placeholder="N° sécurité sociale" class="form-control input-md"
						required="">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="telephone">Téléphone
					:</label>
				<div class="col-md-2">
					<input id="telephone" name="telephone" value="ok" type="text"
						placeholder="Téléphone" class="form-control input-md">

				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton"></label>
				<div class="col-md-4">
					<button id="valider" name="valider" class="btn btn-success"><span class="glyphicon glyphicon-ok"></span> Valider</button>
				</div>
				<button id="annuler" name="annuler" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span> Annuler</button>
			</div>

		</fieldset>
	</form>

</body>
</html>