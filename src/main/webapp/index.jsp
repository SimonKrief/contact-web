<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page d'acceuil</title>
</head>
<body>
<h1>${message }</h1>
<form action="ContactServlet" method="get" >
<!-- target="_blank" -->
<button type="submit">Afficher tous les contacts</button>
</form>
<img alt="chirac en braille" src="chirac.jpg">
</body>
</html>