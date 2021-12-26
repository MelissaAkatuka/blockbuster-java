<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
    <head>
        <title>Sistema para Cadastro e Locação de Mídias</title>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet"
              href="${cp}/css/estilos.css"/>

        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    </head>

    <body style="background-image: url(fundo.gif);text-align: center;margin-top: 10%;">

        <h1 style="color: white">Sistema para Locação de Mídias</h1>

        <div class="card-group p-5" style="width: 100%">

            <div class="card text-white bg-dark mb-3">
                <div class="card-body text-center">
                    <a href="${cp}/formularios/classificacao/listagem.jsp" style="color: #C0C0C0;">Classificações Etárias</a>
                </div>
            </div>
            <div class="card text-white bg-secondary mb-3">
                <div class="card-body text-center">
                    <a href="${cp}/formularios/atores/listagem.jsp" style="color: #363636;" >Atores</a>
                </div>
            </div>
            <div class="card text-white bg-dark mb-3">
                <div class="card-body text-center" >
                    <a href="${cp}/formularios/dvds/listagem.jsp" style="color: #C0C0C0;" >Mídias</a>
                </div>
            </div>

            <div class="card text-white bg-secondary mb-3">
                <div class="card-body text-center">
                    <a href="${cp}/formularios/clientes/listagem.jsp" style="color: #363636;" >Clientes</a>
                </div>
            </div>
            <div class="card text-white bg-dark mb-3">
                <div class="card-body text-center">
                    <a href="${cp}/formularios/cidades/listagem.jsp" style="color: #C0C0C0;">Cidades</a>
                </div>
            </div>
            <div class="card text-white bg-secondary mb-3">
                <div class="card-body text-center" >
                    <a href="${cp}/formularios/estados/listagem.jsp" style="color: #363636;" >Estados</a>
                </div>
            </div>
            <div class="card text-white bg-dark mb-3">
                <div class="card-body text-center">
                    <a href="${cp}/formularios/classificacaointerna/listagem.jsp" style="color: #C0C0C0;">Classificações Internas</a>
                </div>
            </div>
            <div class="card text-white bg-secondary mb-3">
                <div class="card-body text-center">
                    <a href="${cp}/formularios/tipos/listagem.jsp" style="color: #363636;">Tipos</a>
                </div>
            </div>

        </div>

        <div id="carouselExampleControls" class="carousel slide p-5" data-mdb-ride="carousel" style="width: 80%; margin-left: 8%">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img
                        src="series.jpg"
                        class="d-block w-100"
                        alt="Series"
                        />
                </div>
                <div class="carousel-item">
                    <img
                        src="documentarios.jpg"
                        class="d-block w-100"
                        alt="Documentarios"
                        />
                </div>
                <div class="carousel-item">
                    <img
                        src="filmes.jpg"
                        class="d-block w-100"
                        alt="Filmes"
                        />
                </div>
            </div>
            <button
                class="carousel-control-prev"
                type="button"
                data-mdb-target="#carouselExampleControls"
                data-mdb-slide="prev"
                >
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button
                class="carousel-control-next"
                type="button"
                data-mdb-target="#carouselExampleControls"
                data-mdb-slide="next"
                >
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>



    </body>

</html>
