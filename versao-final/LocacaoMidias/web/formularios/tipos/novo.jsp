<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html style="background-image:url('_Locadora-If.gif')">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
        <meta http-equiv="Pragma" content="no-cache" />
        <meta http-equiv="Expires" content="0" />
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <title>Novo Tipo</title>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
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
                  <li><a href="${cp}/formularios/tipos/listagem.jsp">Voltar</a></li>
                </ul>
              </div>
            </div>
        </header>

        <div class="front-page"></div>

        <section class="section-information" style="background-image:url('_Locadora-If.gif')">
          <div class="container" style="background:#d9d9d9">
            <div class="row title-section" id="programa-trainee">
                <h1 class="title form-signin">Novo Tipo</h1>
            </div>

            <form method="post" action="${cp}/processaTipos">
                <input name="acao" type="hidden" value="inserir"/>
                <table class="form-signin">
                    <div class="form-group">
                       <tr>
                         <td class="alinharDireita">Descrição:</td>
                         <td>
                           <input name="descricao"
                                  type="text"
                                  required/>
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
