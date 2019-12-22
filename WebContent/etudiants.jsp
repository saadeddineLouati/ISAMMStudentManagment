<%@page import="java.util.Iterator"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.*"%>
<%@ page import="java.*"%>
<%@ page import="beans.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>
	<nav class="blue accent-4 navbar-fixed">
		<div class="nav-wrapper blue accent-4 container">
			<a href="#" class="brand-logo">ISAMM</a>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
		        <li><a href="Etudiants"><i class="material-icons left">group</i>Etudiants</a></li>
		        <li><a href="Recherche"><i class="material-icons left">search</i>Recherche</a></li>
		        <li><a href="Profil"><i class="material-icons left">face</i>Profil</a></li>
		        <li><a href="Deconnexion"><i class="material-icons left">keyboard_capslock</i>Déconnexion</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="row center">
			<div class="card-panel blue accent-2 white-text">
				<h2>
					<i class="small material-icons">filter_list</i> Liste des étudiants
				</h2>
			</div>
		</div>
	</div>

<div class="container">
		<div class="right">
			<a class="btn waves-effect waves-light left-align blue accent-2" href="insertionEtudiant.html">
				Ajouter <i class="material-icons left">add_box</i>
			</a>
		</div>
</div>
	<div class="container">

		<div class="row center">
			<div class="card-panel white">
				<%List<Etudiant> l=(List<Etudiant>)request.getAttribute("etudiants"); %>
			
				<table class="centered">
					<thead class="valign center">
						<tr class="valign center">
							<th>ID</th>
							<th>Nom</th>
							<th>Prénom</th>
							<th>Moyenne</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%Iterator	<Etudiant> lista=l.iterator();
							while(lista.hasNext()){ Etudiant e=lista.next(); if (e.moyenne>10){%>
						<tr class="green white-text">
							<td><%=e.id%></td>
							<td><%=e.nom%></td>
							<td><%=e.prenom%></td>
							<td><%=e.moyenne%></td>
							<td class="white">
							<c:url value="SuppressionEtudiant" var="lien1">
								<c:param name="id" value="<%=String.valueOf(e.id)%>"></c:param>
							</c:url>
								<a href="${lien1 }" class="btn-floating waves-effect waves-light green">
									<i class="tiny material-icons ">delete</i> Supprimer
								</a>
							</td>
						</tr>
						<%}else{ %>
						
						<tr class="red white-text">
							<td><%=e.id%></td>
							<td><%=e.nom%></td>
							<td><%=e.prenom%></td>
							<td><%=e.moyenne%></td>
							<td class="white">
							<c:url value="SuppressionEtudiant" var="lien1">
									<c:param name="id" value="<%=String.valueOf(e.id)%>"></c:param>
							</c:url>
							<a href="${lien1}" class="btn-floating waves-effect waves-light red">
									<i class="tiny material-icons ">delete_sweep</i>
								</a>
							</td>
						</tr>
						<%}} %>
						
												<%
							if (l.size() <= 0) {
						%>
							<tr class="orange white-text">
								<td colspan="5">
									<i class="tiny material-icons ">warning</i> Liste vide
								</td>
							</tr>	
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>


	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script>
</body>
</html>