<%@page import="br.edu.ufape.model.Professor" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />

    <title>SearchTeacher</title>
    <link href="../../../resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../../../resources/css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="../../../resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

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
                <h4 class="text-secondary">Resultados</h4>
                <hr class="sidebar-divider mt-2 d-md-block">
                <table class="table">
                    <thead class="text-center">
                        <th scope="col">ID lattes</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Área de Atuação</th>
                        <th scope="col">Visualizar</th>

                    </thead>
                    <tbody class="text-center">
	                    <c:forEach var="professor" items="${professores}">
														
		                    <tr>
		                        <td>${professor.idLattes}</td>
		                        <td>${professor.nome}</td>
		                        <td>${professor.getAreasAtuacoes()[0].getNome()}</td>
		                        <td class="text-center">
		                            <a href="/perfil/${professor.id}" class="btn btn-primary"> 
		                                <i class="fas fa-search"></i>
		                            </a>
		                        </td>
		                    </tr>
                    	</c:forEach>
                    </tbody>
                </table>
            <a type="button"class="btn btn-primary btn-user btn-block" href="/home">Voltar</a>
            </div>
        </div>
    </div>
    

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../../../resources/index/js/scripts.js"></script>
    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>

</html>