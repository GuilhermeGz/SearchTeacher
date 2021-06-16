<%@page import="br.edu.ufape.model.AreaMenor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Area Menor</title>

</head>
<body>

	<h2>${msgs}</h2>
	
	<table border="2" width="70%" cellpadding="2">

		<tr>
		            <th>Id</th>
		            <th>Nome</th>
		            <th>Descricao</th>
		            
		</tr>
	        
	
		 <c:forEach var="areaMenor" items="${areasMenores}">
		            <tr>
		            
		                <td>${areaMenor.id}</td>
		                <td>${areaMenor.nome}</td>
		                <td>${areaMenor.descricao}</td>
		                
		                
		                <td><a href="/areamenor/update/${areaMenor.id}">Atualizar</a></td>
		                <td><a href="/areamenor/delete/${areaMenor.id}">Deletar</a></td>
		                
		            </tr>
		</c:forEach>


	
	</table>
	<h2>${errors}</h2>
	
	<a href="/areamenor/new/">Adicionar Area Menor</a></td>	
	
	
	
</body>


</html>