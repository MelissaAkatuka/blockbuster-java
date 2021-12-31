<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html class="fundo">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <title>Locações Cadastradas</title>

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
                <li><a href="${cp}/formularios/locacao/novo.jsp">Nova Locação</a></li>
              </ul>
            </div>
          </div>
        </header>

    <div class="front-page"></div>
        <section class="section-information fundo">
            <div class="container">
                <div class="row title-section" id="programa-trainee">
                  <h1 class="title">Locações Cadastradas</h1>
                </div>
                <table class="table table-hover table-bordered">
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
            </div>    
        </section>
  </body>
</html>
