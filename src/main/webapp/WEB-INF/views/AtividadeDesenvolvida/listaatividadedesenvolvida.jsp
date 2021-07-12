<%@page import="br.edu.ufape.model.AtividadeDesenvolvida"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Atividades Desenvolvidas</title>

</head>
<body>

	<h2>${msgs}</h2>
	
	<table border="2" width="70%" cellpadding="2">

		<tr>
		            <th>Id</th>
		            <th>Descricao</th>
		            <th>Tipo</th>
		            <th>Data Inicio</th>
		            <th>Data Fim</th>
		            
		</tr>
	        
	
		 <c:forEach var="atividadeDesenvolvida" items="${atividadesDesenvolvidas}">
		            <tr>
		            
		                <td>${atividadeDesenvolvida.id}</td>
		                <td>${atividadeDesenvolvida.descricao}</td>
		                <td>${atividadeDesenvolvida.tipoAtividade}</td>
		                <td>${atividadeDesenvolvida.exibirDataInicio}</td>
		                <td>${atividadeDesenvolvida.exibirDataFinal}</td>
		                
		                
		                <td><a href="/atividadedesenvolvida/update/${atividadeDesenvolvida.id}">Atualizar</a></td>
		                <td><a href="/atividadedesenvolvida/delete/${atividadeDesenvolvida.id}">Deletar</a></td>
		                
		            </tr>
		</c:forEach>


	
	</table>
	<h2>${errors}</h2>
	
	<a href="/atividadedesenvolvida/new/">Adicionar Atividade Desenvolvida</a></td>	
	
	
	
</body>


</html>