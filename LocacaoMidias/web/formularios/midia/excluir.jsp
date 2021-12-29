<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
  <head>
    <title>Excluir Midia</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
          href="${cp}/css/estilos.css"/>
  </head>

  <body>

    <h1>Excluir Midia</h1>

    <form method="post" action="${cp}/processaDVDs">

      <input name="acao" type="hidden" value="excluir"/>
      <input name="id" type="hidden" value="${requestScope.midia.id}"/>

      <table>
        <tr>
          <td class="alinharDireita">Título:</td>
          <td>${requestScope.midia.titulo}</td>
        </tr>
        
        <tr>
          <td class="alinharDireita">Ano Lançamento:</td>
          <td>${requestScope.midia.anoLancamento}</td>
        </tr>
        
        <tr>
          <td class="alinharDireita">Código de Barras:</td>
          <td>${requestScope.midia.codigoBarras}</td>
        </tr>
        
        <tr>
          <td class="alinharDireita">Duração(em minutos):</td>
          <td>${requestScope.midia.duracaoMin}</td>
        </tr>
        
        <tr>
          <td class="alinharDireita">Ator/Atriz Principal:</td>
          <td>${requestScope.midia.atorPrincipal.nome} ${requestScope.midia.atorPrincipal.sobrenome}</td>
        </tr>
        
        <tr>
          <td class="alinharDireita">Ator/Atriz Coadjuvante:</td>
          <td>${requestScope.midia.atorCoadjuvante.nome} ${requestScope.midia.atorCoadjuvante.sobrenome}</td>
        </tr>

        <tr>
          <td class="alinharDireita">Gênero:</td>
          <td>${requestScope.midia.genero.descricao}</td>
        </tr>
        
        <tr>
          <td class="alinharDireita">Classificação Etária:</td>
          <td>${requestScope.midia.classificacaoEtaria.descricao}</td>
        </tr>
        
         <tr>
          <td class="alinharDireita">Tipo:</td>
          <td>${requestScope.midia.tipo.descricao}</td>
        </tr>
        
        <tr>
          <td class="alinharDireita">Classificação Interna:</td>
          <td>${requestScope.midia.classificacaoInterna.descricao}</td>
        </tr>
        
        <tr>
          <td class="alinharDireita">Valor do Aluguel:</td>
          <td>${requestScope.midia.classificacaoInterna.valorAluguel}</td>
        </tr>
        
        <tr>
          <td>
            <a href="${cp}/formularios/midia/listagem.jsp">Voltar</a>
          </td>
          <td class="alinharDireita">
            <input type="submit" value="Excluir"/>
          </td>
        </tr>
      </table>

    </form>

  </body>

</html>
