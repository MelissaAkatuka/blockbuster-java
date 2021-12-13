<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
    <head>
        <title>Sistema para Cadastro de DVD's</title>
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
        <div style="text-align: center;">

            <div class = "row align-middle">
                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" src="classificacao.jpg" alt="Card image cap" >
                    <div class="card-body">
                        <a href="${cp}/formularios/classificacao/listagem.jsp" class="btn btn-secondary btn-lg">Classificação Etária</a>
                    </div>
                </div>

                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" src="..." alt="Card image cap">
                    <div class="card-body">
                        <a href="#" class="btn btn-primary">Go somewhere</a>
                    </div>
                </div>
            </div>
        </div>  
        <div class="card-columns">
            <div class="card bg-primary">
                <div class="card-body text-center">
                    <a href="${cp}/formularios/classificacao/listagem.jsp" >Classificação Etária</a>
                </div>
            </div>
            <div class="card bg-warning">
                <div class="card-body text-center">
                    <p class="card-text">Some text inside the second card</p>
                </div>
            </div>
            <div class="card bg-success">
                <div class="card-body text-center">
                    <p class="card-text">Some text inside the third card</p>
                </div>
            </div>
            <div class="card bg-danger">
                <div class="card-body text-center">
                    <p class="card-text">Some text inside the fourth card</p>
                </div>
            </div>
            <div class="card bg-light">
                <div class="card-body text-center">
                    <p class="card-text">Some text inside the fifth card</p>
                </div>
            </div>
            <div class="card bg-info">
                <div class="card-body text-center">
                    <p class="card-text">Some text inside the sixth card</p>
                </div>
            </div>
        </div>


        <a href="${cp}/formularios/atores/listagem.jsp" class="btn btn-secondary btn-lg">Atores</a>

        <a href="${cp}/formularios/generos/listagem.jsp" class="btn btn-secondary btn-lg">Gêneros</a>

        <a href="${cp}/formularios/dvds/listagem.jsp" class="btn btn-secondary btn-lg">DVD's</a>



    </body>

</html>
