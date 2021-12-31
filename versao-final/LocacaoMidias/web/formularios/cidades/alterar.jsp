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
        <title>Alterar Cidade</title>

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
                        <li><a href="${cp}/formularios/cidades/listagem.jsp">Voltar</a></li>
                    </ul>
                </div>
            </div>
        </header>

        <div class="front-page"></div>
        <section class="section-information fundo">
            <div class="container" style="background:#d9d9d9">
                <div class="row title-section" id="programa-trainee">
                    <h1 class="title form-signin">Alterar Cidade</h1>
                </div>

                <form method="post"  action="${cp}/processaCidades">

                    <input name="acao" type="hidden" value="alterar"/>
                    <input name="id" type="hidden" value="${requestScope.cidade.id}"/>

                    <table class="form-signin">
                        <tr>
                            <td class="alinharDireita">Nome:</td>
                            <td>
                                <input name="nome"
                                       type="text"
                                       size="20"
                                       maxlength="30"
                                       required
                                       value="${requestScope.cidade.nome}"
                                       class="form-control"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="alinharDireita">Estado:</td>
                            <td>

                                <jsp:useBean 
                                    id="servicos"
                                    scope="page"
                                    class="locacaomidias.servicos.EstadoServices"/>

                                <select name="idEstado" required class="form-control">
                                    <c:forEach items="${servicos.todos}" var="estado">
                                        <c:choose>
                                            <c:when test="${requestScope.cidade.estado.id eq estado.id}">
                                                <option value="${estado.id}" selected>
                                                    ${estado.nome} - ${estado.sigla}
                                                </option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${estado.id}">
                                                    ${estado.nome} - ${estado.sigla}
                                                </option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>

                            </td>
                        </tr>

                    </table>
                    <div class="form-group" id="btn-save">
                        <input type="submit" class="btn btn-success"  value="Alterar"/>
                    </div>
                </form>

                </body>

                </html>
