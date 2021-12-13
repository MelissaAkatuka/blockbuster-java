<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
    <head>
        <title>Alterar Ator</title>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet"
              href="${cp}/css/estilos.css"/>
    </head>

    <body>

        <div>
            <h1>Alterar Ator</h1>

            <form method="post"  action="${cp}/processaAtores">

                <input name="acao" type="hidden" value="alterar"/>
                <input name="id" type="hidden" value="${requestScope.ator.id}"/>

                <table>
                    <tr>
                        <td class="alinharDireita">Nome:</td>
                        <td>
                            <input name="nome"
                                   type="text"
                                   size="20"
                                   maxlength="30"
                                   required
                                   value="${requestScope.ator.nome}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="alinharDireita">Sobrenome:</td>
                        <td>
                            <input name="sobrenome"
                                   type="text"
                                   required
                                   value="${requestScope.ator.sobrenome}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="alinharDireita">Data de Estreia:</td>
                        <td>
                            <input name="estreia"
                                   type="date"
                                   size="8"
                                   placeholder="yyyy-mm-dd"
                                   required
                                   value="${requestScope.ator.dataEstreia}"/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <a href="${cp}/formularios/atores/listagem.jsp">Voltar</a>
                        </td>
                        <td class="alinharDireita">
                            <input type="submit" value="Alterar"/>
                        </td>
                    </tr>
                </table>

            </form>
        </div>


    </body>

</html>
