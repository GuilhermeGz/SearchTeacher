<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <!-- Navigation-->
    <nav class="navbar navbar-light bg-light static-top">
        <div class="container">
            <div class="sidebar-brand-text mx-3">
                <h4 class="h4">SearchTeacher</h4>
            </div>
            <a class="btn btn-primary" href="/login">Entrar</a>
        </div>
    </nav>
    <!-- Masthead-->
    <header class="masthead">
        <div class="container position-relative">
            <div class="row justify-content-center">
                <div class="col-xl-8">
                    <div class="text-center text-white">
                        <!-- Page heading-->
                        <h1 class=" mb-2">Encontre um professor!</h1>

                        <form class="form-subscribe" id="contactForm" data-sb-form-api-token="API_TOKEN">
                            <!-- Email address input-->
                            <div class="row">
                                <div class="col">
                                    <input class="form-control form-control-lg" id="emailAddress" type="email"
                                        placeholder="Nome, formação, área de pesquisa ..."
                                        data-sb-validations="required,email" />
                                    <div class="invalid-feedback text-white" data-sb-feedback="emailAddress:required">
                                        Email Address is required.</div>
                                    <div class="invalid-feedback text-white" data-sb-feedback="emailAddress:email">Email
                                        Address Email is not valid.</div>
                                </div>
                                <div class="col-auto"><button class="btn btn-primary btn-lg disabled" id="submitButton"
                                        type="submit">Busca</button></div>
                            </div>


                        </form>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <section class="testimonials text-center bg-light">
        <div class="container">
            <h2 class="mb-5">Alguns dos nossos renomados professores...</h2>
            <div class="row">
                <div class="col-lg-4">
                    <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                        <img class="img-fluid rounded-circle mb-3"
                            src="../../../resources/index/assets/img/testimonials-1.jpg" alt="..." />
                        <h5>Alixandre Santana</h5>
                        <p class="font-weight-light mb-0">Doutorado em Ciências da Computação</p>
                        <p class="font-weight-light mb-0">Área atuação atualmente, Agile Enterprise Architecture</p>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                        <img class="img-fluid rounded-circle mb-3"
                            src="../../../resources/index/assets/img/testimonials-2.jpg" alt="..." />
                        <h5>Guilherme Silva</h5>
                        <p class="font-weight-light mb-0">Doutorado em Engenharia da Computação</p>
                        <p class="font-weight-light mb-0">Área atuação atualmente, Sistema Embarcados</p>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                        <img class="img-fluid rounded-circle mb-3"
                            src="../../../resources/index/assets/img/testimonials-3.jpg" alt="..." />
                        <h5>Milena Macedo</h5>
                        <p class="font-weight-light mb-0">Pós-doutourada em Machine Learning</p>
                        <p class="font-weight-light mb-0">Área de atuação Sistemas de Recomendações</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    <section class="showcase">
        <div class="container-fluid p-0">
            <div class="row g-0">
                <div class="col-lg-6 order-lg-2 text-white showcase-img"
                    style="background-image: url('../../../resources/index/assets/img/bg-showcase-3.jpg')"></div>
                <div class="col-lg-6 order-lg-1 my-auto showcase-text">
                    <h2>Professores</h2>
                    <p class="lead mb-0">A Universidade possui uma quantidade muito grande de professores de
                        todas as áreas, mas cabe a você, buscar ajuda em sua sua demanda ou necessidade.</p>
                </div>
            </div>
            <div class="row g-0">
                <div class="col-lg-6 text-white showcase-img"
                    style="background-image: url('../../../resources/index/assets/img/bg-showcase-2.jpg')"></div>
                <div class="col-lg-6 my-auto showcase-text">
                    <h2>Busca Simples</h2>
                    <p class="lead mb-0">Plataforma possuí uma buscar simples, que tem como objetivo facilitar e
                        integrar as bases de dados curriculares
                        de professores das Universidades para centralizar todos os tipos de informações científicas de
                        estudiosos e suas devidas áreas de atuação.</p>
                </div>
            </div>
            <div class="row g-0">
                <div class="col-lg-6 order-lg-2 text-white showcase-img"
                    style="background-image: url('../../../resources/index/assets/img/bg-showcase-1.jpg')"></div>
                <div class="col-lg-6 order-lg-1 my-auto showcase-text">
                    <h2>Como funciona a plataforma SearchTeacher?</h2>
                    <p class="lead mb-0">A plataforma conta com variáveis de tipos filtro, como questões área de
                        atuação,
                        atividades desenvolvidas e área de conhecimento. Em algumas unidades, as variáveis já são
                        preestabelecidas,
                        outras são estruturadas de acordo com o conteúdo buscado, como nome, formação etc.</p>
                </div>
            </div>
        </div>
    </section>

    <footer class="footer bg-light">
        <div class="container">
            <div class="row">
                <p class="text-muted small mb-4 mb-lg-0 text-center">Copyright &copy; SearchTeacher 2021. All Rights
                    Reserved.</p>
            </div>
        </div>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../../../resources/index/js/scripts.js"></script>
    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>

</html>