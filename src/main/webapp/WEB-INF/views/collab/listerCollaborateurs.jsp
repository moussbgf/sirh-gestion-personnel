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
<title>SGP - liste collaborateur</title>
</head>

<body class="container">

	<%@include file="../template/header.jsp"%>

	<h2>Les collaborateurs :</h2>

	<br>
	<br>
	<br>


	<br>
	<br>

	<form class="form-horizontal">
		<fieldset>

			<!-- Form Name -->
			<legend>Recherche</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="searchNomPrenom">Rechercher
					un nom ou un prénom qui commence par: </label>
				<div class="col-md-2">
					<input id="searchNomPrenom" name="searchNomPrenom" type="text"
						placeholder="" class="form-control input-md">

				</div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="depSearch">Filtrer
					par département :</label>
				<div class="col-md-2">
					<select id="depSearch" name="depSearch" class="form-control">

						<option value="0">Tous</option>

						<c:forEach var="dept" items="${ departements }">

							<option value="${ dept.id }">${ dept.nom }</option>

						</c:forEach>

					</select>
				</div>
			</div>

			<!-- Multiple Checkboxes (inline) -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="checkboxes">Voir
					les collaborateurs désactivé :</label>
				<div class="col-md-4">
					<label class="checkbox-inline" for="checkboxes-0"> <input
						type="checkbox" name="checkboxes" id="checkboxes-0" value="1">

					</label>
				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="search"></label>
				<div class="col-md-4">
					<button id="search" name="search" class="btn btn-primary">Rechercher</button>
				</div>
			</div>

		</fieldset>
	</form>

	<br>
	<br>
	<br>

	<a href="nouveau" class="btn btn-lg btn-primary"><span
		class="glyphicon glyphicon-user"></span> nouveau</a>
	<br>
	<br>
	<h3>Liste des collaborateur :</h3>
	<br>

	<div class="container">
		<div class="row">
			<!-- 			<div class="col-md-5  toppad  pull-right col-md-offset-3 ">
				<A href="edit.html">Edit Profile</A> <A href="edit.html">Logout</A>
				<br>
				<p class=" text-info">May 05,2014,03:00 pm</p>
			</div> -->
			<c:forEach var="collab" items="${ collaborateurs }">
				<div
					class="col-xs-12 col-sm-6 col-md-4 col-lg-4 col-xs-offset-0 col-sm-offset-0 col-md-offset-0 col-lg-offset-0 toppad">


					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title">${collab.nom} ${collab.prenom}</h3>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-3 col-lg-3 " align="center">
									<img alt="User Pic"
										src="http://babyinfoforyou.com/wp-content/uploads/2014/10/avatar-300x300.png"
										class="img-circle img-responsive">
										<br/>
										<a href="#" class="btn btn-sm btn-primary pull-right"><span class="glyphicon glyphicon-search"></span> Détails</a>
								</div>
								
								<div style="word-wrap: break-word;" class=" col-md-9 col-lg-9 " >
									<table   class="jumbotron table table-user-information">
										<tbody>
											<tr>
												<td>Matricule:</td>
												<td >${collab.matricule}</td>
											</tr>
											<tr>
												<td>Adresse:</td>
												<td>${collab.adresse}</td>
											</tr>
											<tr>
												<td>Date de Naissance</td>
												<td>${collab.dateDeNaissance}</td>
											</tr>

											<tr>
											<tr>
												<td>Numéro de sécu:</td>
												<td>${collab.numSecu}</td>
											</tr>
											<tr>
												<td>Email Pro:</td>
												<td ><a href="#" style="display: inline-block; word-break: break-word;">${collab.emailPro}</a></td>
<!-- 											</tr>
											<td>Phone Number</td>
											<td>123-4567-890(Landline)<br> <br>555-4567-890(Mobile)
											</td>

											</tr> -->

										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="panel-footer">
							<a data-original-title="Broadcast Message" data-toggle="tooltip"
								type="button" class="btn btn-sm btn-primary"><i
								class="glyphicon glyphicon-envelope"></i></a> <span
								class="pull-right"> <a href="editer?matricule=${collab.matricule}"
								data-original-title="Edit this user" data-toggle="tooltip"
								type="button" class="btn btn-sm btn-warning"><i
									class="glyphicon glyphicon-edit"></i> Modifier</a> <a
								data-original-title="Remove this user" data-toggle="tooltip"
								type="button" class="btn btn-sm btn-danger"><i
									class="glyphicon glyphicon-remove"></i> Supprimer</a>
							</span>
						</div>

					</div>
				</div>
			</c:forEach>
		</div>
	</div>

</body>

</html>