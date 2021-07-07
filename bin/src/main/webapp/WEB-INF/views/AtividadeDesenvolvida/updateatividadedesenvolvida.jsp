<%@page import="br.edu.ufape.model.AtividadeDesenvolvida"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Update Atividade Desenvolvida</title>

</head>
<body>

			
	 <form:form method="POST" modelAttribute="atividadeDesenvolvidaForm" action="/atividadedesenvolvida/update2">
		
			
        <form:hidden path="id" cssClass="form-control"/>        
        
		<label for="descricao">Descricao</label>
        <form:input path="descricao" cssClass="form-control"/>
        <form:errors path="descricao" cssclass="error"></form:errors>
        
        <br>
        
        <label for="tipoAtividade">Tipo</label>
        <form:input path="tipoAtividade" cssClass="form-control"/>
        <form:errors path="tipoAtividade" cssclass="error"></form:errors>
        
        <br>
        
        <label for="dataInicio">Data Inicio</label>
        <form:input path="dataInicio" cssClass="form-control"/>
        <form:errors path="dataInicio" cssclass="error"></form:errors>
        
        
        <br>
        
        <label for="dataFim">Data Fim</label>
        <form:input path="dataFim" cssClass="form-control"/>
        <form:errors path="dataFim" cssclass="error"></form:errors>
        
        <br>
        
        <input type="submit" value="Atualizar" class="btn">
         
		
	</form:form>

	

</body>


</html>