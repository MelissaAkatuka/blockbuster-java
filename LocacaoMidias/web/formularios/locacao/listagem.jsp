<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
  <head>
    
    <title>Locações Cadastradas</title>
    
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet"
          href="${cp}/css/estilos.css"/>
    
    <script src="${cp}/js/libs/jquery/jquery.min.js"></script>
    <script src="${cp}/js/formularios/locacao/listagem.js"></script>
    
  </head>

  <body>

    <h1>Locações Cadastradas</h1>

    <p>
      <a href="${cp}/formularios/locacao/novo.jsp">
        Nova Locação
      </a>
    </p>

    <table class="tabelaListagem">
      <thead>
        <tr>
          <th>Id</th>
          <th>Data Início</th>
          <th>Data Fim</th>
          <th>Cliente</th>
          <th>Cancelar</th>
        </tr>
      </thead>
      <tbody>

        <jsp:useBean 
            id="servicos"
            scope="page"
            class="locacaomidias.servicos.LocacaoServices"/>

        <c:forEach items="${servicos.todos}" var="locacao">
          <tr>
            <td>${locacao.id}</td>
            <td>
              <fmt:formatDate 
                pattern="dd/MM/yyyy"
                value="${locacao.dataInicio}"/>
            </td>
            <td>
              <fmt:formatDate 
                pattern="dd/MM/yyyy"
                value="${locacao.dataFim}"/>
            </td>
            <td>${locacao.cliente.nome} ${locacao.cliente.sobrenome}</td>
            <td>
              <c:choose>
                <c:when test="${locacao.cancelada}">
                  Cancelada
                </c:when>
                <c:otherwise>
                  <a href="#" data-id="${locacao.id}" onclick="cancelarLocacao(event,'${cp}')">
                    Cancelar
                  </a>
                </c:otherwise>
              </c:choose>
            </td>
          </tr>
        </c:forEach>
      </tbody>
      
    </table>


    <p><a href="${cp}/index.jsp">Tela Principal</a></p>

  </body>

</html>
