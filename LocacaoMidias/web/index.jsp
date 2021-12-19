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

        <div class="card-group col-8 p-5" style="width: 100%">
            <div class="card text-white bg-dark mb-3">
                <div class="card-body text-center">
                    <a href="${cp}/formularios/classificacao/listagem.jsp" class="linkum" >Classificação Etária</a>
                </div>
            </div>
            <div class="card text-white bg-secondary mb-3">
                <div class="card-body text-center">
                    <a href="${cp}/formularios/atores/listagem.jsp" class="linkdois" >Atores</a>
                </div>
            </div>
            <div class="card text-white bg-dark mb-3">
                <div class="card-body text-center" >
                    <a href="${cp}/formularios/dvds/listagem.jsp" class="linkum" >Mídias</a>
                </div>
            </div>

        </div>

        <div class="card-group col-8 p-5" style="width: 100%">
            <div class="card text-white bg-dark mb-3">
                <div class="card-body text-center">
                    <a href="${cp}/formularios/clientes/listagem.jsp" class="linkum" >Cliente</a>
                </div>
            </div>
            <div class="card text-white bg-secondary mb-3">
                <div class="card-body text-center">
                    <a href="${cp}/formularios/cidades/listagem.jsp" class="linkdoois">Cidade</a>
                </div>
            </div>
            <div class="card text-white bg-dark mb-3">
                <div class="card-body text-center" >
                    <a href="${cp}/formularios/estados/listagem.jsp" class="linkum" >Estado</a>
                </div>
            </div>

        </div>

    </body>

</html>
