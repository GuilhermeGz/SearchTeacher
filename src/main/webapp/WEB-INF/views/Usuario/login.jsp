<%@page import="br.edu.ufape.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Novo Usuario</title>

</head>
<body>
			
	 <form:form method="POST" modelAttribute="usuarioForm" action="/usuario/efetuarlogin">
	
        
		<label for="login">login</label>
        <form:input path="login" cssClass="form-control"/>
        <form:errors path="login" cssclass="error"></form:errors>
        <br>
        
		<label for="senha">senha</label>
        <form:input path="senha" cssClass="form-control"/>
        <form:errors path="senha" cssclass="error"></form:errors>
        <br>
        
        <h2>TESTE</h2>
        
     	<c:out value="${errors}"></c:out>
     	
                
        <input type="submit" value="Adicionar" class="btn">
		
	</form:form>

	

</body>


</html>