<%@page import="br.edu.ufape.model.AreaAtuacao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Area de Atuacao</title>

</head>
<body>

	<h2>${msgs}</h2>
	
	<table border="2" width="70%" cellpadding="2">

		<tr>
		            <th>Id</th>
		            <th>Nome</th>
		            <th>Descricao</th>
		            <th>Ano</th>
		            
		</tr>
	        
	
		 <c:forEach var="areaAtuacao" items="${areasAtuacao}">
		            <tr>
		            
		                <td>${areaAtuacao.id}</td>
		                <td>${areaAtuacao.nome}</td>
		                <td>${areaAtuacao.descricao}</td>
		                <td>${areaAtuacao.ano}</td>
		                
		                
		                <td><a href="/areaatuacao/update/${areaAtuacao.id}">Atualizar</a></td>
		                <td><a href="/areaatuacao/delete/${areaAtuacao.id}">Deletar</a></td>
		                
		            </tr>
		</c:forEach>


	
	</table>
	<h2>${errors}</h2>
	
	<a href="/areaatuacao/new/">Adicionar Area de Atuacao</a></td>	
	
	
	
</body>


</html>