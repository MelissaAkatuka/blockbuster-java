<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html style="background-image:url('_Locadora-If.gif')">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
        <meta http-equiv="Pragma" content="no-cache" />
        <meta http-equiv="Expires" content="0" />
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <title>Sistema de Locação If</title>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="${cp}/css/style.css"> 
        <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
    </head>

    <body style="background-image:url('_Locadora-If.gif')">
        <header class="main-header">
            <div class="wrap">   
              <div class="main-options">
                <ul class="menu-top">
                  <li><img class="logo" src="_logo.PNG" alt="logo"></li>
                  <li><a href="${cp}/formularios/classificacao/listagem.jsp"style="color: #C0C0C0;"">C. Etárias</a></li>
                  <li><a href="${cp}/formularios/atores/listagem.jsp" style="color: #363636;">Atores</a></li>
                  <li><a href="${cp}/formularios/midia/listagem.jsp" style="color: #C0C0C0;">Mídias</a></li>
                  <li><a href="${cp}/formularios/clientes/listagem.jsp" style="color: #363636;">Clientes</a></li>
                  <li><a href="${cp}/formularios/cidades/listagem.jsp" style="color: #C0C0C0;">Cidades</a></li>
                  <li><a href="${cp}/formularios/estados/listagem.jsp" style="color: #363636;">Estados</a></li>
                  <li><a href="${cp}/formularios/classificacaointerna/listagem.jsp" style="color: #C0C0C0;">C. Internas</a></li>
                  <li><a href="${cp}/formularios/tipos/listagem.jsp" style="color: #363636;">Tipos</a></li>
                  <li><a href="${cp}/formularios/generos/listagem.jsp" style="color: #C0C0C0;">Gêneros</a></li>
                  <li><a href="${cp}/formularios/exemplar/listagem.jsp" style="color: #363636;">Estoque</a></li>
                  <li><a href="${cp}/formularios/locacao/listagem.jsp" style="color: #C0C0C0;">Locação</a></li>
                </ul>
              </div>
            </div>
        </header>

        <div class="front-page"></div>

        <section class="section-information" style="background-image:url('_Locadora-If.gif')">
            <div class="container">
                <div class="row title-section" id="programa-trainee">
                    <h1 style="color: white">Locação de Mídias If</h1>
                </div>
            </div>
        </section>
        
        <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel" style="width: 60%; margin-left: 20%">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="gif_certo.gif" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="filmes.jpg" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="documentarios.jpg" class="d-block w-100" alt="...">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>

        <br/>
        <br/>

    </body>

</html>
