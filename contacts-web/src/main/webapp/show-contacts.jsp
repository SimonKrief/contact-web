<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Affichage contact</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>
	<h2>Contacts</h2>
	<table>
		<c:forEach items="${contacts }" var="contact">
			<tr>
				<td>${contact.nom }${contact.id } 
				<a href="ContactDeleteServlet?id=${contact.id }">Supprimer</a>
<%-- 					<form action="UpdateContactServlet?id=${contact.id }"> --%>
<!-- 						<button}>mettre à jour</button> -->
<!-- 					</form> -->
				<a href="UpdateContactServlet?id=${contact.id }">Modifier</a>

				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="index.jsp"> Retour</a>

</body>
</html>