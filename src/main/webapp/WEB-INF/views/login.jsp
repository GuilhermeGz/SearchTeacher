<%@page import="br.edu.ufape.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html
    xmlns:th="http://www.thymeleaf.org"
    xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
    lang="en"
>
	<head>
	    <title>Login</title>

	    <link th:href="@{/webjars/bootstrap/css/bootstrap.min.css}" rel="stylesheet"/>

	    <link th:href="@{/webjars/bootstrap/css/bootstrap-theme.min.css}" rel="stylesheet"/>

	    <link th:href="@{/webjars/font-awesome/css/font-awesome.min.css}" rel="stylesheet"/>

	    <link th:href="@{/css/style.css}" rel="stylesheet"/>
	    
	    <!-- Custom fonts for this template-->
	    <link href="../resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
	    
	    <link
	        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	        rel="stylesheet">
	
	    <!-- Custom styles for this template-->
    	<link href="../resources/css/sb-admin-2.min.css" rel="stylesheet">
	    
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <meta name="description" content="">
	    <meta name="author" content="">
	
	    
	</head>

<body style="background-image: url('../resources/index/assets/img/bg-masthead.jpg')">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-6 col-lg-6 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            
                            <div class="col-lg-12">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Bem-vindo, SearchTeacher!</h1>
                                    </div>
                                    
                               <!--     <div th:if="${param.error}"> 
										<div class="alert alert-info">Adios</div>
									</div> -->
                                    
										<form class="user" action="/login" method="post">
											<div class="form-group">
												<label >Nome Do Usuário</label>
												<input name="username" class="form-control  form-control-user" placeholder="Usuário"/>
											</div>
				
											<div class="form-group">
												<label >Senha</label>
												<input type="password" name="password" class="form-control  form-control-user" placeholder="Senha"/>
											</div>
				
											<div class="form-group">
												<button class="btn btn-primary btn-user btn-block" >Entrar</button>
												<a type="button"class="btn btn-primary btn-user btn-block" href="/home">Voltar</a>
											</div>
				
											
				
											<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
										</form>
						
				                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>

		<script th:src="@{/webjars/jquery/jquery.min.js}"></script>

		<script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>
		
		<!-- Bootstrap core JavaScript-->
	    <script src="../resources/vendor/jquery/jquery.min.js"></script>
	    <script src="../resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	
	    <!-- Core plugin JavaScript-->
	    <script src="../resources/vendor/jquery-easing/jquery.easing.min.js"></script>
				
	    <!-- Custom scripts for all pages-->
	    <script src="../resources/js/sb-admin-2.min.js"></script>
	    
	     
	</body>
</html>