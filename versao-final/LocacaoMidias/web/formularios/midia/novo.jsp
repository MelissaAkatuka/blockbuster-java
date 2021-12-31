<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html class="fundo">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
        <meta http-equiv="Pragma" content="no-cache" />
        <meta http-equiv="Expires" content="0" />
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <title>Nova Mídia</title>

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
                  <li><a href="${cp}/formularios/midia/listagem.jsp">Voltar</a></li>
                </ul>
              </div>
            </div>
        </header>

        <div class="front-page"></div>

        <section class="section-information fundo">
          <div class="container" style="background:#d9d9d9">
            <div class="row title-section" id="programa-trainee">
                <h1 class="title form-signin">Nova Mídia</h1>
            </div>

            <form method="post" action="${cp}/processaMidia">
                <input name="acao" type="hidden" value="inserir"/>
                <table class="form-signin">
                    <div class="form-group">
                       <tr>
                           <td>Título: </td>
                           <td>
                               <input class="form-control" name="titulo"
                                      type="text"
                                      required/>
                           </td>
                       </tr>
                    </div>
                    <div class="form-group">
                       <tr>
                           <td>Ano Lançamento: </td>
                           <td>
                               <input class="form-control" name="anoLanc"
                                      type="text"
                                      required/>
                           </td>
                       </tr>
                    </div>
                    <div class="form-group">
                        <tr>
                           <td>Código de Barras: </td>
                           <td>
                               <input class="form-control" name="codigoBarras"
                                      type="text"
                                      required/>
                           </td>
                       </tr>               
                    </div>
                    <div class="form-group">
                       <tr>
                           <td>Duração(em minutos): </td>
                           <td>
                               <input class="form-control" name="duracaoMin"
                                      type="text"
                                      required/>
                           </td>
                       </tr>
                    </div>
                    <div class="form-group">
                       <tr>
                           <td>Ator/Atriz Principal: </td>
                           <td>

                               <jsp:useBean 
                                   id="servicos"
                                   scope="page"
                                   class="locacaomidias.servicos.AtorServices"/>

                               <select name="atorPrincId" required>
                                   <c:forEach items="${servicos.todos}" var="ator">
                                       <option value="${ator.id}">
                                           ${ator.nome} ${ator.sobrenome}
                                       </option>
                                   </c:forEach>
                               </select>

                           </td>
                       </tr>
                    </div>
                    <div class="form-group">
                       <tr>
                           <td>Ator/Atriz Coadjuvante: </td>
                           <td>

                               <jsp:useBean 
                                   id="servicos_ator"
                                   scope="page"
                                   class="locacaomidias.servicos.AtorServices"/>

                               <select name="atorCoadId" required>
                                   <c:forEach items="${servicos_ator.todos}" var="ator">
                                       <option value="${ator.id}">
                                           ${ator.nome} ${ator.sobrenome}
                                       </option>
                                   </c:forEach>
                               </select>

                           </td>
                       </tr>
                    </div>
                    <div class="form-group">
                       <tr>
                           <td>Gênero: </td>
                           <td>

                               <jsp:useBean 
                                   id="servicos_gnr"
                                   scope="page"
                                   class="locacaomidias.servicos.GeneroServices"/>

                               <select name="generoId" required>
                                   <c:forEach items="${servicos_gnr.todos}" var="genero">
                                       <option value="${genero.id}">
                                           ${genero.descricao}
                                       </option>
                                   </c:forEach>
                               </select>

                           </td>
                       </tr>
                    </div>
                    <div class="form-group">
                       <tr>
                           <td>Classificação Etária: </td>
                           <td>

                               <jsp:useBean 
                                   id="servicos_classi"
                                   scope="page"
                                   class="locacaomidias.servicos.ClassificacaoEtariaServices"/>

                               <select name="classificacaoEtariaId" required>
                                   <c:forEach items="${servicos_classi.todos}" var="classificacao">
                                       <option value="${classificacao.id}">
                                           ${classificacao.descricao}
                                       </option>
                                   </c:forEach>
                               </select>

                           </td>
                       </tr>
                    </div>
                    <div class="form-group">
                       <tr>
                           <td>Tipo: </td>
                           <td>

                               <jsp:useBean 
                                   id="servicos_tipo"
                                   scope="page"
                                   class="locacaomidias.servicos.TipoServices"/>

                               <select name="tipoId" required>
                                   <c:forEach items="${servicos_tipo.todos}" var="tipo">
                                       <option value="${tipo.id}">
                                           ${tipo.descricao}
                                       </option>
                                   </c:forEach>
                               </select>

                           </td>
                       </tr>
                    </div>
                    <div class="form-group">
                       <tr>
                           <td>Classificação Interna: </td>
                           <td>

                               <jsp:useBean 
                                   id="servicos_ci"
                                   scope="page"
                                   class="locacaomidias.servicos.ClassificacaoInternaServices"/>

                               <select name="classificacaoInternaId" required>
                                   <c:forEach items="${servicos_ci.todos}" var="ci">
                                       <option value="${ci.id}">
                                           ${ci.descricao}
                                       </option>
                                   </c:forEach>
                               </select>

                           </td>
                       </tr>
                    </div>
                   </table>
                   <div class="form-group" id="btn-save">
                      <input type="submit" class="btn btn-success" value="Salvar"/>
                   </div>
               </form>
          </div> 
        </section>
    </body>
</html>
