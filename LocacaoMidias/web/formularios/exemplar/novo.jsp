<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
    <head>
        <title>Novo Exemplar</title>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet"
              href="${cp}/css/estilos.css"/>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>

    <body>

        <h1>Novo Exemplar</h1>

        <form class="form-group container" method="post" action="${cp}/processaExemplar" style="background-color: white;">

            <input name="acao" type="hidden" value="inserir"/>

            <table>
                
                 <tr>
                    <td class="alinharDireita">Mídia: </td>
                    <td>

                        <jsp:useBean 
                            id="servicos_midia"
                            scope="page"
                            class="locacaomidias.servicos.MidiaServices"/>

                        <select name="idMidia" required>
                            <c:forEach items="${servicos_midia.todos}" var="midia">
                                <option value="${midia.id}">
                                    ${midia.titulo}
                                </option>
                            </c:forEach>
                        </select>

                    </td>
                </tr>
                
                <tr>
                    <td class="alinharDireita">Quantidade:</td>
                    <td>
                        <input name="qtd"
                               type="number"
                               value="1"
                               required/>
                    </td>
                </tr>                
                
                <tr>
                    <td>
                        <a href="${cp}/formularios/exemplar/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Salvar"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>

</html>
