<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<c:set var="prefixo" value="processaTipos?acao=preparar"/>
<!DOCTYPE html>

<html style="background-image:url('_Locadora-If.gif')">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <title>Tipos Cadastrados</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="${cp}/js/libs/jquery/jquery.min.js"></script>
    <script src="${cp}/js/libs/decimal.js/decimal.min.js"></script>
    <script src="${cp}/js/formularios/locacao/novo.js"></script>
    <link rel="stylesheet" href="${cp}/css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
  </head>
 
    <body style="background-image:url('_Locadora-If.gif')">
        <header class="main-header">
          <div class="wrap">   
            <div class="main-options">
              <ul class="menu-top">
                <li><img class="logo" src="_logo.PNG" alt="logo"></li>
                <li><a href="${cp}/index.jsp">Página inicial</a></li>
                <li><a href="${cp}/formularios/tipos/novo.jsp">Cadastro</a></li>
              </ul>
            </div>
          </div>
        </header>

    <div class="front-page"></div>
        <section class="section-information" style="background-image:url('_Locadora-If.gif')">
            <div class="container">
                <div class="row title-section" id="programa-trainee">
                  <h1 class="title">Tipos Cadastrados</h1>
                </div>
                <table class="table table-hover table-bordered">
                    <thead>
                      <tr>
                        <th>Id</th>
                        <th>Descrição</th>
                        <th>Alterar</th>
                        <th>Excluir</th>
                      </tr>
                    </thead>
                    <tbody>

                      <jsp:useBean
                          id="servicos"
                          scope="page"
                          class="locacaomidias.servicos.TipoServices"/>

                      <c:forEach items="${servicos.todos}" var="tipo">
                        <tr>
                          <td>${tipo.id}</td>
                          <td>${tipo.descricao}</td>
                          <td>
                            <a href="${cp}/${prefixo}Alteracao&id=${tipo.id}">
                              Alterar
                            </a>
                          </td>
                          <td>
                            <a href="${cp}/${prefixo}Exclusao&id=${tipo.id}">
                              Excluir
                            </a>
                          </td>
                        </tr>
                      </c:forEach>
                    </tbody>
              </table>
            </div>    
        </section>
  </body>
</html>
