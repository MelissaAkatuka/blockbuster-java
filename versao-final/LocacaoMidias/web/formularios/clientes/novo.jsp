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
        <title>Novo Cliente</title>

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
                  <li><a href="${cp}/formularios/clientes/listagem.jsp">Voltar</a></li>
                </ul>
              </div>
            </div>
        </header>

        <div class="front-page"></div>

        <section class="section-information fundo">
          <div class="container" style="background:#d9d9d9">
              <div class="row title-section" id="programa-trainee">
                  <h1 class="title form-signin">Novo Cliente</h1>
                </div>

         <form method="post" action="${cp}/processaClientes">

             <input name="acao" type="hidden" value="inserir"/>

             <table class="form-signin">
                 <div class="form-group">
                    <tr>
                      <td>Nome:</td>
                      <td>
                        <input class="form-control" name="nome"
                               type="text"
                               size="20"
                               maxlength="45"
                               required/>
                      </td>
                 </div>
                 <div class="form-group">
                    </tr>
                    <tr>
                      <td>Sobrenome:</td>
                      <td>
                        <input class="form-control" name="sobrenome"
                               type="text"
                               size="20"
                               maxlength="45"
                               required/>
                      </td>
                    </tr>
                 </div>
                 <div class="form-group">
                    <tr>
                      <td>Data de Nascimento:</td>
                      <td>
                        <input class="form-control" name="dataNascimento"
                               type="date"
                               size="8"
                               placeholder="dd/mm/yyyy"
                               required/>
                      </td>
                    </tr>
                 </div>
                 <div class="form-group">
                    <tr>
                      <td>CPF:</td>
                      <td>
                        <input class="form-control" name="cpf"
                               type="text"
                               size="13"
                               pattern="\d{3}.\d{3}.\d{3}-\d{2}"
                               placeholder="999.999.999-99"
                               required/>
                      </td>
                    </tr>
                 </div>
                 <div class="form-group">
                    <tr>
                      <td>E-mail:</td>
                      <td>
                        <input class="form-control" name="email"
                               type="email"
                               size="20"
                               maxlength="60"
                               required/>
                      </td>
                    </tr>
                 </div>
                 <div class="form-group">
                    <tr>
                      <td>Logradouro:</td>
                      <td>
                        <input class="form-control" name="logradouro"
                               type="text"
                               size="25"
                               maxlength="50"
                               required/>
                      </td>
                    </tr>
                 </div>
                 <div class="form-group">
                    <tr>
                      <td>Número:</td>
                      <td>
                        <input class="form-control" name="numero"
                               type="text"
                               size="6"
                               maxlength="6"
                               required/>
                      </td>
                    </tr>
                 </div>
                 <div class="form-group">
                    <tr>
                      <td>Bairro:</td>
                      <td>
                        <input class="form-control" name="bairro"
                               type="text"
                               size="15"
                               maxlength="30"
                               required/>
                      </td>
                    </tr>
                 </div>
                 <div class="form-group">
                    <tr>
                      <td>CEP:</td>
                      <td>
                        <input class="form-control" name="cep"
                               type="text"
                               size="7"
                               pattern="\d{5}-\d{3}"
                               placeholder="99999-999"
                               required/>
                      </td>
                    </tr>
                 </div>
                 <div class="form-group">
                    <tr>
                      <td>Cidade:</td>
                      <td>

                        <jsp:useBean 
                            id="servicos" 
                            scope="page" 
                            class="locacaomidias.servicos.CidadeServices"/>

                        <select name="idCidade" required>
                          <c:forEach items="${servicos.todos}" var="cidade">
                            <option value="${cidade.id}">
                              ${cidade.nome}
                            </option>
                          </c:forEach>
                        </select>

                      </td>
                    </tr>
                 </div>      
                  </table>
                        <div class="form-group" id="btn-save">
                            <input type="submit"  class="btn btn-success" value="Salvar"/>
                        </div>
                </form>
            </div> 
        </section>
  </body>

</html>
