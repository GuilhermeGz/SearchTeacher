<%@page import="br.edu.ufape.model.Instituicao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Instituicoes</title>

</head>
<body>

	<h2>${msgs}</h2>
	
	<table border="2" width="70%" cellpadding="2">

		<tr>
		            <th>Id</th>
		            <th>Nome</th>
		            <th>Endereco</th>
		</tr>
	        
	
		 <c:forEach var="instituicao" items="${instituicoes}">
		            <tr>
		                <td>${instituicao.id}</td>
		                <td>${instituicao.nome}</td>
		                <td>${instituicao.endereco}</td>
		                
		                <td><a href="/instituicao/update/${instituicao.id}">Atualizar</a></td>
		                <td><a href="/instituicao/delete/${instituicao.id}">Deletar</a></td>
		                
		            </tr>
		</c:forEach>

	
	</table>
	<h2>${errors}</h2>
	
	<a href="/instituicao/new/">Adicionar Instituicao</a></td>	
	
	
	
</body>


</html>