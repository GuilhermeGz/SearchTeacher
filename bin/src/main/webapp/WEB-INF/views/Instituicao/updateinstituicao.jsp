<%@page import="br.edu.ufape.model.Instituicao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Update Instituicao</title>

</head>
<body>

			
	 <form:form method="POST" modelAttribute="instituicaoForm" action="/instituicao/update2">
		
			
        <form:hidden path="id" cssClass="form-control"/>
        
        
		<label for="nome">Nome</label>
        <form:input path="nome" cssClass="form-control"/>
        <form:errors path="nome" cssclass="error"></form:errors>
        
        <br>
       
        <label for="endereco">Endereco</label>
        <form:input path="endereco" cssClass="form-control"/>
        <form:errors path="endereco" cssclass="error"></form:errors>
        
        <br>
        
        <input type="submit" value="Atualizar" class="btn">
         
		
	</form:form>

	

</body>


</html>