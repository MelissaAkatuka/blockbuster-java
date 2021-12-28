<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<c:set var="prefixo" value="processaDVDs?acao=preparar"/>
<!DOCTYPE html>

<html>
  <head>
    <title>Mídias Cadastrados</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
          href="${cp}/css/estilos.css"/>
  </head>

  <body>

    <h1>Mídias Cadastradas</h1>

    <p>
      <a href="${cp}/formularios/midia/novo.jsp">
        Nova Mídia
      </a>
    </p>

    <table class="tabelaListagem">
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
            <td>${midia.atorPrincipal.nome} $midiadvd.atorPrincipal.sobrenome}</td>
            <td>${midia.atorCoadjuvante.nome} ${midia.atorCoadjuvante.sobrenome}</td>
            <td>${midia.genero.descricao}</td>
            <td>${midia.classificacao.descricao}</td>
            <td>${midia.tipo.descricao}</td>
            <td>${midia.classificacaoInterna.descricao}</td>
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

    <p><a href="${cp}/index.jsp">Tela Principal</a></p>

  </body>

</html>
