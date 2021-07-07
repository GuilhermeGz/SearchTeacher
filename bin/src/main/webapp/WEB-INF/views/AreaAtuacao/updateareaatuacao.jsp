<%@page import="br.edu.ufape.model.AreaAtuacao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Update Area de Atuacao</title>

</head>
<body>

			
	 <form:form method="POST" modelAttribute="areaAtuacaoForm" action="/areaatuacao/update2">
		
			
        <form:hidden path="id" cssClass="form-control"/>        
        
		<label for="nome">Nome</label>
        <form:input path="nome" cssClass="form-control"/>
        <form:errors path="nome" cssclass="error"></form:errors>
        
        <br>
        
		<label for="descricao">Descricao</label>
        <form:input path="descricao" cssClass="form-control"/>
        <form:errors path="descricao" cssclass="error"></form:errors>
        
        <br>
        
        <label for="ano">Ano</label>
        <form:input path="ano" cssClass="form-control" type="date"/>
        <form:errors path="ano" cssclass="error"></form:errors>
        
        <br>
        
        
        <input type="submit" value="Atualizar" class="btn">
         
		
	</form:form>

	

</body>


</html>