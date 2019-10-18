<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adresses</title>
</head>
<body>
	<h4>Ajouter adresse:</h4>
	<br>
	<form action="AjouterAdresseServlet" method="get">
		Rue: <input name="rue" id="rue"> 
		Ville:<input name="ville" id="ville"> 
		Code Postal:<input name="codePostal" id="codePostal"> 
		Pays:<input name="pays" id="pays">
		<input type="hidden" name="contactID" id="contactID" value="${contactID }">
		<button>Ajouter</button>
	</form>
	<h2>La liste des adresses de ce contact est:</h2>
	<table>
		<c:forEach items="${adresses}" var="adresse">
			<tr>
				<td>${adresse.rue}</td>
				<td>${adresse.ville}</td>
				<td>${adresse.codePostal}</td>
				<td>${adresse.pays}</td>
				<td>
					<form action="DeleteAdresseServlet" method="get">
					<input type="hidden" name="contactID" id="contactID" value="${contactID }">
						<input type="hidden" value="${adresse.id}" name="id" id="id">
						<button>Supprimer</button>
					</form>
				</td>
				<td>
					<form action="ModifyAdresseServlet" method="get">
					<input type="hidden" name="contactID" id="contactID" value="${contactID }">
						<input type="hidden" value="${adresse.id}" name="id" id="id">
						<button>Modifier</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>