<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Contacts</h2>
	<table>
		<c:forEach items="${contacts }" var="contact">
			<tr>
				<td>${contact.nom }
					${contact.id }
				
<%-- 				 <button href="ContactDeleteServlet?id=${contact.id }"  >Supprimer</button> --%>
					 <a href="ContactDeleteServlet?id=${contact.id }"  >Supprimer</a>
<%-- 					 <a href="UpdateServlet?id=${contact.id }"  >Supprimer</a> --%>
	
	
				 </td>
			</tr>
		</c:forEach>
	</table>
<a href="index.jsp"> Retour</a>

</body>
</html>