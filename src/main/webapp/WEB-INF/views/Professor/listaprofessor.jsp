<%@page import="br.edu.ufape.model.Professor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Professor</title>

</head>
<body>

	<h2>${msgs}</h2>
	
	<table border="2" width="70%" cellpadding="2">

		<tr>
		            <th>Id</th>
		            <th>Nome</th>
		            <th>Email</th>
		            <th>Id Lattes</th>
		            <th>Descricao</th>
		            <th>Citacao Bibliografica</th>
		            
		</tr>
	        
	
		 <c:forEach var="professor" items="${professores}">
		            <tr>
		            
		                <td>${professor.id}</td>
		                <td>${professor.nome}</td>
		                <td>${professor.email}</td>
		                <td>${professor.idLattes}</td>
		                <td>${professor.descricao}</td>
		                <td>${professor.citacaoBibliografica}</td>
		                
		                
		                <td><a href="/professor/update/${professor.id}">Atualizar</a></td>
		                <td><a href="/professor/delete/${professor.id}">Deletar</a></td>
		                
		            </tr>
		</c:forEach>


	
	</table>
	<h2>${errors}</h2>
	
	<a href="/professor/new/">Adicionar Professor</a></td>	
	
	
	
</body>


</html>