<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<c:set var="prefixo" value="processaDVDs?acao=preparar"/>
<!DOCTYPE html>

<html>
  <head>
    <title>DVD's Cadastrados</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
          href="${cp}/css/estilos.css"/>
  </head>

  <body>

    <h1>DVD's Cadastrados</h1>

    <p>
      <a href="${cp}/formularios/dvds/novo.jsp">
        Novo DVD
      </a>
    </p>

    <table class="tabelaListagem">
      <thead>
        <tr>
          <th>Id</th>
          <th>Título</th>
          <th>Ano Lançamento</th>
          <th>Ator/Atriz Principal</th>
          <th>Ator/Atriz Coadjuvante</th>
          <th>Data Lançamento</th>
          <th>Duração(em minutos)</th>
          <th>Gênero</th>
          <th>Classificação Etária</th>
          <th>Alterar</th>
          <th>Excluir</th>
        </tr>
      </thead>
      <tbody>

        <jsp:useBean
            id="servicos"
            scope="page"
            class="locacaomidias.servicos.DVDServices"/>

        <c:forEach items="${servicos.todos}" var="dvd">
          <tr>
            <td>${dvd.id}</td>
            <td>${dvd.titulo}</td>
            <td>${dvd.anoLancamento}</td>
            <td>${dvd.atorPrincipal.nome} ${dvd.atorPrincipal.sobrenome}</td>
            <td>${dvd.atorCoadjuvante.nome} ${dvd.atorCoadjuvante.sobrenome}</td>
            <td>${dvd.dataLancamento}</td>
            <td>${dvd.duracaoMin}</td>
            <td>${dvd.genero.descricao}</td>
            <td>${dvd.classificacao.descricao}</td>
            <td>
              <a href="${cp}/${prefixo}Alteracao&id=${dvd.id}">
                Alterar
              </a>
            </td>
            <td>
              <a href="${cp}/${prefixo}Exclusao&id=${dvd.id}">
                Excluir
              </a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>

    <p><a href="${cp}/index.jsp">Tela Principal</a></p>

  </body>

</html>
