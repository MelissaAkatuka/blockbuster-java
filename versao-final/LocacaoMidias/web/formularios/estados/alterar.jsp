<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html class="fundo">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
        <meta http-equiv="Pragma" content="no-cache" />
        <meta http-equiv="Expires" content="0" />
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <title>Alterar Estado</title>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="${cp}/css/style.css">
        <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
    </head>

    <body class="fundo">
        <header class="main-header">
            <div class="wrap">   
                <div class="main-options">
                    <ul class="menu-top">
                        <li><img class="logo" src="_logo.PNG" alt="logo"></li>
                        <li><a href="${cp}/index.jsp">Página inicial</a></li>
                        <li><a href="${cp}/formularios/estados/listagem.jsp">Voltar</a></li>
                    </ul>
                </div>
            </div>
        </header>

        <div class="front-page"></div>
        <section class="section-information fundo">
            <div class="container" style="background:#d9d9d9">
                <div class="row title-section" id="programa-trainee">
                    <h1 class="title form-signin">Alterar Estado</h1>
                </div>


                <form method="post" action="${cp}/processaEstados">

                    <input name="acao" type="hidden" value="alterar"/>
                    <input name="id" type="hidden" value="${requestScope.estado.id}"/>

                    <table class="form-signin">
                        <tr>
                            <td class="alinharDireita">Nome:</td>
                            <td>
                                <input name="nome"
                                       type="text"
                                       size="20"
                                       maxlength="30"
                                       value="${requestScope.estado.nome}"
                                       class="form-control"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="alinharDireita">Sigla:</td>
                            <td>
                                <input name="sigla"
                                       type="text"
                                       size="3"
                                       maxlength="2"
                                       value="${requestScope.estado.sigla}"
                                       class="form-control"/>
                            </td>
                        </tr>

                    </table>

                    <div class="form-group" id="btn-save">
                        <input type="submit" class="btn btn-success"  value="Alterar"/>
                    </div>

                </form>

                </body>

                </html>
