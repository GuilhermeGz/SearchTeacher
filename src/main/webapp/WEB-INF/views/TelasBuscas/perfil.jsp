<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />

    <title>SearchTeacher</title>

    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"
        type="text/css" />
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet"
        type="text/css" />
    <link href="../../../resources/index/css/styles.css" rel="stylesheet" />

</head>

<body>

    <nav class="navbar  static-top"
        style="background-image: url('../../../resources/index/assets/img/bg-masthead.jpg')">
        <div class="container">
            <div class="sidebar-brand-text mx-3">
                <h4 class="h4 text-white">SearchTeacher</h4>
            </div>
            <a class="btn btn-primary" href="/login">Entrar</a>
        </div>
    </nav>
    <div class="container-sm  mt-4">
        <div class="card shadow mb-4">
            <div class="card-body">
	                <h4 class="text-primary">Nome: ${professor.getNome()}</h4>
	               
	                <h5 class="text-primary">ID lattes: ${professor.getIdLattes()}</h5>
	                <hr class="sidebar-divider mt-2 d-md-block">
	                <h5 class="text-primary">Descrição</h5>
	                <p>${professor.getDescricao()}</p>
	                <h4 class="text-primary">Áreas de atuação</h4>
	                <c:forEach var="area" items="${professor.getAreasAtuacoes()}">
	                	<p>${area.getNome()}</p>
	                </c:forEach>
	                <hr class="sidebar-divider mt-2 d-md-block">
	                <h4 class="text-primary">SubÁreas de atuação</h4>
	                <hr class="sidebar-divider mt-2 d-md-block">
	                <h4 class="text-primary">Atividades desenvolvidas</h4>
	                <hr class="sidebar-divider mt-2 d-md-block">
	         
            </div>
            <a type="button"class="btn btn-primary btn-user btn-block" href="/home">Voltar</a>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../../../resources/index/js/scripts.js"></script>
    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>

</html>