<%@page import="beans.Etudiant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
<%if(session.getAttribute("status").equals("Enseignant")){ %>
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
<%}else{ %>
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
<%} %>

	<div class="container">
		<div class="row center">
			<div class="card-panel blue accent-2 white-text">
				<h2>
					<i class="small material-icons">search</i> Résultats de recheche
				</h2>
			</div>
		</div>
	</div>
	<%Etudiant l=(Etudiant)request.getAttribute("etudiant"); %>
	<div class="container">
		<div class="row center">
			<div class="col s12">
				<div class="container">
					<div class="container">
						<div class="container">
						<div class="row">
							<div class="col s12 m12">
								<div class="card">
									<div class="card-image center">
										<img src="https://thumbs.dreamstime.com/b/homme-d-affaires-avatar-flat-icon-sur-le-blanc-95459476.jpg">
										 <span class="card-title orange-text">														<%
															out.println(l.nom);
														%>
														<%
															out.println(l.prenom);
														%>
										</span>
									</div>
									<div class="card-content">
											<ul class="collection ">
												<li class="collection-item">
													<div class="left-align">
														<i class="tiny material-icons">fingerprint</i> Id<small>(Login)</small>:
														<%
															out.println(l.id);
														%>
													</div>
												</li>
												<li class="collection-item">
													<div class="left-align">
														<i class="tiny material-icons">face</i>
														<%
															out.println(l.nom);
														%>
														<%
															out.println(l.prenom);
														%>
													</div>
												</li>
												<li class="collection-item">
													<div class="left-align">
														<i class="tiny material-icons">format_list_numbered</i>
														<%out.println(l.moyenne);%> de moyenne
													</div>
												</li>

											</ul>
										</div>
								</div>
							</div>
						</div>
					</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script>

	<script type="text/javascript">
	  $('#mdpbtn').click(function(){
		  $('.modal').openModal()
	  });
	  $('#mdplink').click(function(){
		  $('.modal').openModal()
	  });
	</script>
</body>
</html>