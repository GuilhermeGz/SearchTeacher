<%@page import="br.edu.ufape.model.Formacao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Formacao</title>

</head>
<body>

	<h2>${msgs}</h2>
	
	<table border="2" width="70%" cellpadding="2">

		<tr>
		            <th>Id</th>
		            <th>Nome</th>
		            <th>Ano</th>
		            <th>Descricao</th>
		            
		</tr>
	        
	
		 <c:forEach var="formacao" items="${formacoes}">
		            <tr>
		                <td>${formacao.id}</td>
		                <td>${formacao.nome}</td>
		                <td>${formacao.ano}</td>
		                <td>${formacao.descricao}</td>
		                
		                <td><a href="/formacao/update/${formacao.id}">Atualizar</a></td>
		                <td><a href="/formacao/delete/${formacao.id}">Deletar</a></td>
		            </tr>
		</c:forEach>


	
	</table>
	<h2>${errors}</h2>
	
	<a href="/formacao/new/">Adicionar Formacao</a></td>	
	
	
	
</body>


</html>