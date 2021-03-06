<%@page import="br.edu.ufape.model.Professor" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

                <!DOCTYPE html>
                <html lang="pt-BR">

                <head>

                    <title>Cadastrar Professor</title>
                    <meta charset="UTF-8">
                    <meta http-equiv="X-UA-Compatible" content="IE=edge">
                    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                    <meta name="description" content="">
                    <meta name="author" content="">



                    <!-- Custom fonts for this template -->
                    <link href="../../resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
                        type="text/css">
                    <link
                        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
                        rel="stylesheet">

                    <!-- Custom styles for this template -->
                    <link href="../../resources/css/sb-admin-2.min.css" rel="stylesheet">

                    <!-- Custom styles for this page -->
                    <link href="../../resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

                </head>

                <body id="page-top">

                    <!-- Page Wrapper -->
                    <div id="wrapper">

                        <!-- Sidebar -->
                        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar"
                        style="background-image: url('../resources/index/assets/img/bg-masthead.jpg')">

                            <!-- Sidebar - Brand -->
                            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">

                                <div class="sidebar-brand-text mx-3">SearchTeacher</div>
                            </a>

                            <!-- Divider -->
                            <hr class="sidebar-divider">

                            <!-- Heading -->
                            <div class="sidebar-heading">Acesso</div>

                            <!-- Nav Item - Professor -->
                            <li class="nav-item"><a class="nav-link" href="/professor/"> <i class="fas fa-chalkboard-teacher"></i>
                                    <span>Professor</span>
                                </a></li>
                            <!-- Nav Item - Institui????o -->
                            <li class="nav-item"><a class="nav-link" href="/instituicao/"> <i
                                        class="fas fa fa-university"></i> <span>Institui????o</span>
                                </a></li>

                            <!-- Nav Item - Forma????o -->
                            <li class="nav-item"><a class="nav-link" href="/formacao/">
                                    <i class="fas fa fa-graduation-cap"></i> <span>Forma????o</span>
                                </a></li>

                            <!-- Nav Item - Area de atua????o -->
                            <li class="nav-item"><a class="nav-link" href="/areaatuacao/"> <i
                                        class="fas fa fa-flask"></i> <span>Area Atua????o</span>
                                </a></li>

                            <!-- Nav Item - Area de SubArea -->
                            <li class="nav-item"><a class="nav-link" href="/areamenor/">
                                    <i class="fas fa fa-flask"></i> <span>Sub??rea</span>
                                </a></li>

                            <!-- Nav Item - Area de Atividade -->
                            <li class="nav-item"><a class="nav-link" href="/atividadedesenvolvida/">
                                    <i class="fas fa fa-flask"></i> <span>Atividade Desenvolvida</span>
                                </a></li>

                            <!-- Nav Item - Pages Collapse Menu -->
                            <li class="nav-item"><a class="nav-link collapsed" href="#" data-toggle="collapse"
                                    data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo"> <i
                                        class="fas fa-fw fa-cog"></i> <span>Configura????es</span>
                                </a>
                                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
                                    data-parent="#accordionSidebar">
                                    <div class="bg-white py-2 collapse-inner rounded">
                                        <h6 class="collapse-header">Custom Components:</h6>
                                        <a class="collapse-item" href="buttons.html">Buttons</a> <a
                                            class="collapse-item" href="cards.html">Cards</a>
                                    </div>
                                </div>
                            </li>

                            <!-- Divider -->
                            <hr class="sidebar-divider d-none d-md-block">

                            <!-- Sidebar Toggler (Sidebar) -->
                            <div class="text-center d-none d-md-inline">
                                <button class="rounded-circle border-0" id="sidebarToggle"></button>
                            </div>

                        </ul>
                        <!-- End of Sidebar -->

                        <!-- Content Wrapper -->
                        <div id="content-wrapper" class="d-flex flex-column">

                            <!-- Main Content -->
                            <div id="content">

                                <!-- Topbar -->
                                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                                    <!-- Sidebar Toggle (Topbar) -->
                                    <form class="form-inline">
                                        <button id="sidebarToggleTop"
                                            class="btn btn-link d-md-none rounded-circle mr-3">
                                            <i class="fa fa-bars"></i>
                                        </button>
                                    </form>


                                    <!-- Topbar Navbar -->
                                    <ul class="navbar-nav ml-auto">


                                        <div class="topbar-divider d-none d-sm-block"></div>

                                        <!-- Nav Item - User Information -->
                                        <li class="nav-item dropdown no-arrow"><a class="nav-link dropdown-toggle"
                                                href="#" id="userDropdown" role="button" data-toggle="dropdown"
                                                aria-haspopup="true" aria-expanded="false"> <span
                                                    class="mr-2 d-none d-lg-inline text-gray-600 small">
                                                    Perfil </span> <img class="img-profile rounded-circle"
                                                    src="../../resources/img/undraw_profile.svg">
                                            </a> <!-- Dropdown - User Information -->
                                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                                aria-labelledby="userDropdown">
                                                
                                                <form action="/logout" method="post" class="navbar-form navbar-right">
								        		<button type="submit" class="btn btn-default">
								        			<span class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></span>
								        			Sair
								        		</button>
								        		
								        		<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
									      	</form>
                                            </div>
                                        </li>

                                    </ul>

                                </nav>
                                <!-- End of Topbar -->

                                <!-- Begin Page Content -->
                                <div class="container-fluid">

                                    <!-- Page Heading -->


                                    <div class="card shadow mb-4">
                                        <div class="card-title ml-4	mt-4">
                                            <h4>Cadastrar Professor</h4>
                                        </div>

                                        <hr class="sidebar-divider mt-2 d-md-block">

                                        <div class="card-body">

                                            <form:form method="POST" modelAttribute="professorForm"
                                                action="/professor/new2">

                                                <div class="row">
                                                    <div class="col-lg-12">
                                                        <div class="form-group">
                                                            <label>Nome</label>
                                                            <form:input path="nome" cssClass="form-control" />
                                                            <form:errors path="nome"></form:errors>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-lg-6">
                                                        <div class="form-group">
                                                            <label>Institui????o</label>
                                                            <br/>
                                                            <form:select path="instituicao.id"
																cssclass="form-control mb-3">
																<form:options items="${instituicoes}"
																	itemLabel="nome" />
															</form:select>
                                                            
													        
                                                        </div>
                                                    </div>
                                                   
                                                    <div class="col-lg-6">
                                                        <div class="form-group">
                                                            <label for="idLattes">ID Lattes</label>
                                                            <form:input path="idLattes" cssClass="form-control" />
                                                            <form:errors path="idLattes"></form:errors>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-lg-4">
                                                        <div class="form-group">
                                                            <label>??rea de Atua????o:</label>

                                                            <select class=" form-control mb-3">
                                                                <option value="0" disabled>Selecione</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-4">
                                                        <div class="form-group">
                                                            <label>Sub??rea</label>

                                                            <select class=" form-control mb-3">
                                                                <option value="0" disabled>Selecione</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-4">
                                                        <div class="form-group">
                                                            <label>Atividade Desenvolvida</label>

                                                            <select class=" form-control mb-3">
                                                                <option value="0" disabled>Selecione</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-lg-7">
                                                        <div class="form-group">
                                                            <label for="email">Email</label>
                                                            <form:input path="email" cssClass="form-control" />
                                                            <form:errors path="email"></form:errors>
                                                            <br>
                                                        </div>
                                                    </div>

                                                    <div class="col-lg-5">
                                                        <div class="form-group">
                                                            <label for="citacaoBibliografica">Cita????o
                                                                Bibliogr??fica</label>
                                                            <form:input path="citacaoBibliografica"
                                                                cssClass="form-control" />
                                                            <form:errors path="citacaoBibliografica"></form:errors>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-lg-12">
                                                        <div class="form-group">
                                                            <label for="descricao">Descricao</label>
                                                            <form:input path="descricao" cssClass="form-control" />
                                                            <form:errors path="descricao">
                                                            </form:errors>
                                                        </div>
                                                    </div>
                                                </div>

                                                <hr class="sidebar-divider mt-2 d-md-block">
                                                <button href="#" class="btn btn-primary btn-icon-split" type="submit">
                                                    <span class="icon text-white-50"> <i class="fas fa-plus"></i></span>
                                                    <span class="text">Cadastrar</span>
                                                </button>
                                                <a type="button"class="btn btn-primary" href="/professor">
					    						<span class="icon text-white-50">
					                                </span> <span class="text">Voltar</span>
					                            </a>
                                            </form:form>


                                        </div>

                                    </div>
                                </div>

                                <!-- /.container-fluid -->

                            </div>
                            <!-- End of Main Content -->

                            <!-- Footer -->
                            <footer class="sticky-footer bg-white">
                                <div class="container my-auto">
                                    <div class="copyright text-center my-auto">
                                        <span>Copyright &copy; SearchTeacher 2021</span>
                                    </div>
                                </div>
                            </footer>
                            <!-- End of Footer -->

                        </div>
                    </div>
                    <!-- End of Content Wrapper -->

                    </div>
                    <!-- End of Page Wrapper -->

                    <!-- Scroll to Top Button-->
                    <a class="scroll-to-top rounded" href="#page-top"> <i class="fas fa-angle-up"></i>
                    </a>

                    <!-- Logout Modal-->
                    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
                        aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">???</span>
                                    </button>
                                </div>
                                <div class="modal-body">Select "Logout" below if you are ready
                                    to end your current session.</div>
                                <div class="modal-footer">
                                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                                    <a class="btn btn-primary" href="login.html">Logout</a>
                                </div>
                            </div>
                        </div>
                    </div>


                    <!-- Bootstrap core JavaScript-->
                    <script src="../../resources/vendor/jquery/jquery.min.js"></script>
                    <script src="../../resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

                    <!-- Core plugin JavaScript-->
                    <script src="../../resources/vendor/jquery-easing/jquery.easing.min.js"></script>

                    <!-- Custom scripts for all pages-->
                    <script src="../../resources/js/sb-admin-2.min.js"></script>

                    <!-- Page level plugins -->
                    <script src="../../resources/vendor/datatables/jquery.dataTables.min.js"></script>
                    <script src="../../resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

                    <!-- Page level custom scripts -->
                    <script src="../../resources/js/demo/datatables-demo.js"></script>

                </body>


                </html>