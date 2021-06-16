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
			
	 <form:form method="POST" modelAttribute="usuarioForm" >
	
        
			<%= ((Usuario) session.getAttribute("usuarioLogado")).getLogin() %>!   
        
     
                
         
		
	</form:form>

	

</body>


</html>