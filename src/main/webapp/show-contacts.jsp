<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="CreerContactServlet" method="get">
		<h1>Nouveau contact:</h1><br> 
		Civilité: <input name="civilite" id="civilite">
		<!-- mettre des select pr sélectionner la civilite parmi une liste prédéfinie-->
		Prénom: <input name="prenom" id="prenom"> 
		Nom: <input name="nom" id="nom">
		<button>Créer</button>
	</form>
	<h2>La liste des contacts de la BDD est:</h2>
	<table>
		<tr>
			<th>Civilité</th>
			<th>Prénom</th>
			<th>Nom</th>
		</tr>
		<c:forEach items="${contacts}" var="contact">
			<tr>
				<td>${contact.civilite }</td>
				<td>${contact.prenom }</td>
				<td>${contact.nom }</td>
				<td>
					<form action="ShowAdressesServlet" method="get">
						<input type="hidden" value="${contact.id}" name="id" id="id">
						<button>Adresses</button>
					</form>
				</td>
				<td>
					<form action="ModifyContactServlet" method="get">
						<input type="hidden" value="${contact.id}" name="id" id="id">
						<button>Modifier</button>
					</form>
				</td>
				<td>
					<form action="DeleteContactServlet" method="get">
						<input type="hidden" value="${contact.id}" name="id" id="id">
						<button>Supprimer</button>
					</form>
				</td>
			</tr>
			<tr>
				<c:forEach items="${contact.adresses}" var="adresse">
					<td colspan="4">${adresse.rue }  à  ${adresse.ville } (${adresse.codePostal }, ${adresse.pays })</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	<a href="index.jsp">Retour</a>
</body>
</html>