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
					<i class="small material-icons">assignment_ind</i> Mon profil
				</h2>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row center">
			<div class="col s4">
				<div class="card-panel white">
					<img
						src="https://thumbs.dreamstime.com/b/homme-d-affaires-avatar-flat-icon-sur-le-blanc-95459476.jpg"
						width="96.5%">
				</div>
			</div>
			<div class="col s8">
				<div class="card-panel white">
					<ul class="collection with-header">
						<li class="collection-header"><h4>Mes informations</h4></li>
						<li class="collection-item">
							<div class="left-align">
								<i class="tiny material-icons">fingerprint</i> Id<small>(Login)</small>: <%out.println(session.getAttribute("id"));%>
							</div>
						</li>
						<li class="collection-item">
							<div class="left-align">
								<i class="tiny material-icons">face</i> <%out.println(session.getAttribute("nom"));%> <%out.println(session.getAttribute("prenom"));%>
							</div>
						</li>
						<li class="collection-item">
							<div class="left-align">
								<i class="tiny material-icons">more</i> <%out.println(session.getAttribute("status"));%>
							</div>
						</li>

					</ul>
					<a class="btn-floating btn-large modal-trigger" href="#modal1" id="mdpbtn" ><i
						class="tiny material-icons">security</i></a><a href="#modal1" id="mdplink"
						class="modal-trigger">Voir le mot de passe</a>
					<div id="modal1" class="modal">
						<div class="modal-content">
							<h4>Bonjour, voici votre mot de passe</h4>
							<p><%out.println(session.getAttribute("mdp"));%></p>
						</div>
						<div class="modal-footer">
							<a href="#!"
								class="modal-close waves-effect waves-green btn-flat">Annuler</a>
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