<%@page import="br.edu.ufape.model.Professor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Update Professor</title>

</head>
<body>

			
	 <form:form method="POST" modelAttribute="professorForm" action="/professor/update2">
		
			
        <form:hidden path="id" cssClass="form-control"/>
        
        <form:hidden path="idLattes" cssClass="form-control"/>
		<form:errors path="idLattes" cssclass="error"></form:errors>
        <br>
        
		<label for="nome">Nome</label>
        <form:input path="nome" cssClass="form-control"/>
        <form:errors path="nome" cssclass="error"></form:errors>
        <br>
        
        <label for="emial">Email</label>
        <form:input path="email" cssClass="form-control"/>
        <form:errors path="email" cssclass="error"></form:errors>
        <br>
        
		<label for="descricao">Descricao</label>
        <form:input path="descricao" cssClass="form-control"/>
        <form:errors path="descricao" cssclass="error"></form:errors>
        <br>
        
        <label for="citacaoBibliografica">Citacao Bibliografica</label>
        <form:input path="citacaoBibliografica" cssClass="form-control"/>
        <form:errors path="citacaoBibliografica" cssclass="error"></form:errors>
        <br>
        
        
        <input type="submit" value="Atualizar" class="btn">
         
		
	</form:form>

	

</body>


</html>