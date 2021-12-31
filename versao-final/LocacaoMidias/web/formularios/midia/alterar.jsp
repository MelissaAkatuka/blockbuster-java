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
        <title>Alterar Mídia</title>

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
                        <li><a href="${cp}/formularios/midia/listagem.jsp">Voltar</a></li>
                    </ul>
                </div>
            </div>
        </header>
        <div class="front-page"></div>
        <section class="section-information fundo">
            <div class="container" style="background:#d9d9d9">
                <div class="row title-section" id="programa-trainee">
                    <h1 class="title form-signin">Alterar Midia</h1>
                </div>

                <form method="post"  action="${cp}/processaMidia">

                    <input name="acao" type="hidden" value="alterar"/>
                    <input name="id" type="hidden" value="${requestScope.midia.id}"/>

                    <table class="form-signin">

                        <tr>
                            <td class="alinharDireita">Título: </td>
                            <td>
                                <input name="titulo"
                                       type="text"
                                       required
                                       value="${requestScope.midia.titulo}"
                                       class="form-control"/>
                            </td>
                        </tr>

                        <tr>
                            <td class="alinharDireita">Ano Lançamento: </td>
                            <td>
                                <input name="anoLanc"
                                       type="text"
                                       required
                                       value="${requestScope.midia.anoLancamento}"
                                       class="form-control"/>
                            </td>
                        </tr>

                        <tr>
                            <td class="alinharDireita">Código de Barras: </td>
                            <td>
                                <input name="codigoBarras"
                                       type="text"
                                       required
                                       value="${requestScope.midia.codigoBarras}"
                                       class="form-control"/>
                            </td>
                        </tr>

                        <tr>
                            <td class="alinharDireita">Duração(em minutos): </td>
                            <td>
                                <input name="duracaoMin"
                                       type="text"
                                       required
                                       value="${requestScope.midia.duracaoMin}"
                                       class="form-control"/>
                            </td>
                        </tr>

                        <tr>
                            <td class="alinharDireita">Ator/Atriz Principal: </td>
                            <td>

                                <jsp:useBean 
                                    id="servicos"
                                    scope="page"
                                    class="locacaomidias.servicos.AtorServices"/>

                                <select name="atorPrincId" required value="${requestScope.midia.atorPrincipal.nome}" class="form-control">
                                    <c:forEach items="${servicos.todos}" var="ator">
                                        <option value="${ator.id}">
                                            ${ator.nome}
                                        </option>
                                    </c:forEach>
                                </select>

                            </td>
                        </tr>

                        <tr>
                            <td class="alinharDireita">Ator/Atriz Coadjuvante: </td>
                            <td>

                                <jsp:useBean 
                                    id="servicos_ator"
                                    scope="page"
                                    class="locacaomidias.servicos.AtorServices"/>

                                <select name="atorCoadId" required value="${requestScope.midia.atorCoadjuvante.nome}" class="form-control"/>
                                <c:forEach items="${servicos_ator.todos}" var="ator">
                            <option value="${ator.id}">
                                ${ator.nome}
                            </option>
                        </c:forEach>
                        </select>

                        </td>
                        </tr>

                        <tr>
                            <td class="alinharDireita">Classificação Etária: </td>
                            <td>

                                <jsp:useBean 
                                    id="servicos_classi"
                                    scope="page"
                                    class="locacaomidias.servicos.ClassificacaoEtariaServices"/>

                                <select name="classificacaoEtariaId" required value="${requestScope.midia.classificacaoEtaria.descricao}" class="form-control"/>
                                <c:forEach items="${servicos_classi.todos}" var="classificacaoEtaria">
                            <option value="${classificacaoEtaria.id}">
                                ${classificacaoEtaria.descricao}
                            </option>
                        </c:forEach>
                        </select>

                        </td>
                        </tr>

                        <tr>
                            <td class="alinharDireita">Gênero: </td>
                            <td>

                                <jsp:useBean 
                                    id="servicos_gnr"
                                    scope="page"
                                    class="locacaomidias.servicos.GeneroServices"/>

                                <select name="generoId" required value="${requestScope.midia.genero.descricao}" class="form-control"/>
                                <c:forEach items="${servicos_gnr.todos}" var="genero">
                            <option value="${genero.id}">
                                ${genero.descricao}
                            </option>
                        </c:forEach>
                        </select>

                        </td>
                        </tr>

                        <tr>
                            <td class="alinharDireita">Tipo: </td>
                            <td>

                                <jsp:useBean 
                                    id="servicos_tipo"
                                    scope="page"
                                    class="locacaomidias.servicos.TipoServices"/>

                                <select name="tipoId" required value="${requestScope.midia.tipo.descricao}" class="form-control"/>
                                <c:forEach items="${servicos_tipo.todos}" var="tipo">
                            <option value="${tipo.id}">
                                ${tipo.descricao}
                            </option>
                        </c:forEach>
                        </select>

                        </td>
                        </tr>               

                        <tr>
                            <td class="alinharDireita">Classificação Interna: </td>
                            <td>

                                <jsp:useBean 
                                    id="servicos_ci"
                                    scope="page"
                                    class="locacaomidias.servicos.ClassificacaoInternaServices"/>

                                <select name="classificacaoInternaId" required value="${requestScope.midia.classificacaoInterna.descricao}" class="form-control"/>
                                <c:forEach items="${servicos_ci.todos}" var="classificacaoInterna">
                            <option value="${classificacaoInterna.id}">
                                ${classificacaoInterna.descricao}
                            </option>
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
