<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
    <head>
        <title>Alterar Midia</title>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet"
              href="${cp}/css/estilos.css"/>
    </head>

    <body>

        <h1>Alterar Midia</h1>

        <form method="post"  action="${cp}/processaDVDs">

            <input name="acao" type="hidden" value="alterar"/>
            <input name="id" type="hidden" value="${requestScope.midia.id}"/>

            <table>
                
                <tr>
                    <td class="alinharDireita">Título: </td>
                    <td>
                        <input name="titulo"
                               type="text"
                               required
                               value="${requestScope.midia.titulo}"/>
                    </td>
                </tr>

                <tr>
                    <td class="alinharDireita">Ano Lançamento: </td>
                    <td>
                        <input name="anoLanc"
                               type="text"
                               required
                               value="${requestScope.midia.anoLancamento}"/>
                    </td>
                </tr>
                
                 <tr>
                    <td class="alinharDireita">Código de Barras: </td>
                    <td>
                        <input name="codigoBarras"
                               type="text"
                               required
                               value="${requestScope.midia.codigoBarras}"/>
                    </td>
                </tr>

                <tr>
                    <td class="alinharDireita">Duração(em minutos): </td>
                    <td>
                        <input name="duracaoMin"
                               type="text"
                               required
                               value="${requestScope.midia.duracaoMin}"/>
                    </td>
                </tr>

                <tr>
                    <td class="alinharDireita">Ator/Atriz Principal: </td>
                    <td>

                        <jsp:useBean 
                            id="servicos"
                            scope="page"
                            class="locacaomidias.servicos.AtorServices"/>

                        <select name="atorPrincId" required value="${requestScope.midia.atorPrincipal.nome}">
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

                        <select name="atorCoadId" required value="${requestScope.midia.atorCoadjuvante.nome}"/>
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

                        <select name="classificacaoId" required value="${requestScope.midia.classificacao.descricao}"/>
                            <c:forEach items="${servicos_classi.todos}" var="classificacao">
                                <option value="${classificacao.id}">
                                    ${classificacao.descricao}
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

                        <select name="generoId" required value="${requestScope.midia.genero.descricao}"/>
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

                        <select name="generoId" required value="${requestScope.midia.tipo.descricao}"/>
                            <c:forEach items="${servicos_tipo.todos}" var="tipo">
                                <option value="${tipo.id}">
                                    ${tipo.descricao}
                                </option>
                            </c:forEach>
                        </select>

                    </td>
                </tr>               
                <tr>
                <tr>
                    <td class="alinharDireita">Classificação Interna: </td>
                    <td>

                        <jsp:useBean 
                            id="servicos_ci"
                            scope="page"
                            class="locacaomidias.servicos.ClassificacaoInternaServices"/>

                        <select name="classificacaoId" required value="${requestScope.midia.classificacaoInterna.descricao}"/>
                            <c:forEach items="${servicos_ci.todos}" var="classificacaoInterna">
                                <option value="${classificacaoInterna.id}">
                                    ${classificacaoInterna.descricao}
                                </option>
                            </c:forEach>
                        </select>

                    </td>
                </tr>                   
                    <td>
                        <a href="${cp}/formularios/midias/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Alterar"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>

</html>
