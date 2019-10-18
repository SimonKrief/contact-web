<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="EditContactServlet" method="get">
Modification: 
<input type="hidden" value="${contact.id}" name="id" id="id">
Civilité: <input value="${contact.civilite }" name="civilite" id="civilite" >
Prénom: <input value="${contact.prenom }" name="prenom" id="prenom" >
Nom: <input value="${contact.nom }" name="nom" id="nom" >
<button>Modifier</button>
</form>
</body>
</html>