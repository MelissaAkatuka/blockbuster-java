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

    <body style="background-image: url(fundo.gif);">

        <div style="text-align: center;margin-top: 20%;">
            <h1 style="color: white">Sistema para Cadastro de DVD's</h1>

            <a href="${cp}/formularios/classificacao/listagem.jsp" class="btn btn-secondary btn-lg">Classificação Etária</a>

            <a href="${cp}/formularios/atores/listagem.jsp" class="btn btn-secondary btn-lg">Atores</a>

            <a href="${cp}/formularios/generos/listagem.jsp" class="btn btn-secondary btn-lg">Gêneros</a>

            <a href="${cp}/formularios/dvds/listagem.jsp" class="btn btn-secondary btn-lg">DVD's</a>
        </div>


    </body>

</html>
