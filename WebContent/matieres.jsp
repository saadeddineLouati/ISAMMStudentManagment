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
		        <li><a href="Matieres"><i class="material-icons left">folder</i>Matières</a></li>
		        <li><a href="Profil"><i class="material-icons left">face</i>Profil</a></li>
		        <li><a href="Deconnexion"><i class="material-icons left">keyboard_capslock</i>Déconnexion</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="row center">
			<div class="card-panel blue accent-2 white-text">
				<h2>
					<i class="small material-icons">view_carousel</i> Liste des matières
				</h2>
			</div>
				<div class="card-panel orange accent-2 white-text">
					<h6>
						<i class="tiny material-icons">info</i> Vous avez le droit de choisir 3 matières uniquemeent. Si vous avez atteint la seuil maximale vous aurer la possibiliter de substituer une matière avec une autre en supprimant la matière souhaitée de votre liste.
					</h6>
				</div>
		</div>
	</div>

	<%List<String> l=(List<String>)request.getAttribute("matieres"); %>
	<%List<String> l2=(List<String>)request.getAttribute("mesMatieres"); %>
	<div class="container">
		<div class="row center">
			<div class="col s4">
				<div class="card-panel white">
				<ul class="collection with-header">
						<li class="collection-header teal accent-3 white-text"><h5><i class="tiny material-icons white-text">done</i> Mes Matières</h5></li>
						<%if (l2.size()>0){for(int j=0; j<l2.size(); j++){ %>
							<li class="collection-item left-align">
								<div>
									<%=l2.get(j) %>
								<c:url value="SupprimerMatiere" var="lien2">
									<c:param name="matiere" value="<%=l2.get(j)%>"></c:param>
								</c:url>
								<a href="${lien2 }" class="secondary-content"> <i
									class="material-icons red-text">delete_forever</i>
								</a>
								</div>
							</li>

						<% }%>
						<%}else{ %>
							<small class="orange-text">
							<i class="tiny material-icons red-text">warning</i>
							Vous avez le droit de choisir 3 matières.</small>
						<% } %>
					</ul>
				</div>
			</div>
			<div class="col s8">
				<div class="card-panel white">
					<ul class="collection with-header">
						<li class="collection-header teal accent-3 white-text"><h5><i class="tiny material-icons white-text">list</i>Tous les Matières</h5></li>
						<%int i=0; for(i=0 ; i< l.size(); i++){%>						
						<li class="collection-item left-align"><div>
								<%=l.get(i)%>
								<%if(l2.size()>0){ if (l2.size()<=2){if (!l2.contains(l.get(i))){ %>
									<c:url value="AjouterMatiere" var="lien1">
										<c:param name="matiere" value="<%=l.get(i)%>"></c:param>
									</c:url>
								<a href="${lien1 }" class="secondary-content">
									<i class="material-icons">add_circle</i>
								</a>
								<%}}}else{ %>
								<c:url value="AjouterMatiere" var="lien1">
									<c:param name="matiere" value="<%=l.get(i)%>"></c:param>
								</c:url>
								<a href="${lien1 }" class="secondary-content"> <i
									class="material-icons">add_circle</i>
								</a>
								<% } %>
							</div>
						</li>
						<%} %>
					</ul>
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script>
</body>
</html>