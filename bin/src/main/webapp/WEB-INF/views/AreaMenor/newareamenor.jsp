<%@page import="br.edu.ufape.model.AreaMenor"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Nova Area Menor</title>
</head>
<body>
			
	 <form:form method="POST" modelAttribute="areaMenorForm" action="/areamenor/new2">
	
        
		<label for="nome">Nome</label>
        <form:input path="nome" cssClass="form-control" id="nome"/>
        <form:errors path="nome" cssclass="error"></form:errors>
        
        <br>
        
		<label for="descricao">Descricao</label>
        <form:input path="descricao" cssClass="form-control" id="email"/>
        <form:errors path="descricao" cssclass="error"></form:errors>
        
        <br>
        
        <input type="submit" value="Adicionar" class="btn">
         
		
	</form:form>


</body>


</html>