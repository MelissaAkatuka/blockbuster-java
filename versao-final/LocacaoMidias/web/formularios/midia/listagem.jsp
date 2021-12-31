<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<c:set var="prefixo" value="processaMidia?acao=preparar"/>
<!DOCTYPE html>

<html class="fundo">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <title>Mídias Cadastradas</title>

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
                <li><a href="${cp}/formularios/midia/novo.jsp">Cadastro</a></li>
              </ul>
            </div>
          </div>
        </header>

    <div class="front-page"></div>
        <section class="section-information fundo" style="width:60%;">
            <div class="container">
                <div class="row title-section" id="programa-trainee">
                  <h1 class="title">Mídias Cadastradas</h1>
                </div>
                <table class="table table-hover table-bordered">
                    <thead>
                      <tr>
                        <th>Id</th>
                        <th>Título</th>
                        <th>Ano Lançamento</th>
                        <th>Código de Barras</th>
                        <th>Duração(em minutos)</th>
                        <th>Ator/Atriz Principal</th>
                        <th>Ator/Atriz Coadjuvante</th>
                        <th>Gênero</th>
                        <th>Classificação Etária</th>
                        <th>Tipo</th>
                        <th>Classificação Interna</th>
                        <th>Valor do Aluguel</th>
                        <th>Alterar</th>
                        <th>Excluir</th>
                      </tr>
                    </thead>
                    <tbody>
                      <jsp:useBean
                          id="servicos"
                          scope="page"
                          class="locacaomidias.servicos.MidiaServices"/>

                      <c:forEach items="${servicos.todos}" var="midia">
                        <tr>
                          <td>${midia.id}</td>
                          <td>${midia.titulo}</td>
                          <td>${midia.anoLancamento}</td>
                          <td>${midia.codigoBarras}</td>
                          <td>${midia.duracaoMin}</td>
                          <td>${midia.atorPrincipal.nome} ${midia.atorPrincipal.sobrenome}</td>
                          <td>${midia.atorCoadjuvante.nome} ${midia.atorCoadjuvante.sobrenome}</td>
                          <td>${midia.genero.descricao}</td>
                          <td>${midia.classificacaoEtaria.descricao}</td>
                          <td>${midia.tipo.descricao}</td>
                          <td>${midia.classificacaoInterna.descricao}</td>
                          <td>${midia.classificacaoInterna.valorAluguel}</td>
                          <td>
                            <a href="${cp}/${prefixo}Alteracao&id=${midia.id}">
                              Alterar
                            </a>
                          </td>
                          <td>
                            <a href="${cp}/${prefixo}Exclusao&id=${midia.id}">
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
