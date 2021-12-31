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
        <title>Alterar Cliente</title>

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
                    <h1 class="title form-signin">Alterar Cliente</h1>
                </div>

                <form method="post" action="${cp}/processaClientes">

                    <input name="acao" type="hidden" value="alterar"/>
                    <input name="id" type="hidden" value="${requestScope.cliente.id}"/>

                    <table class="form-signin">
                        <tr>
                            <td class="alinharDireita">Nome:</td>
                            <td>
                                <input name="nome"
                                       type="text"
                                       size="20"
                                       maxlength="45"
                                       required
                                       value="${requestScope.cliente.nome}"
                                       class="form-control"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="alinharDireita">Sobrenome:</td>
                            <td>
                                <input name="sobrenome"
                                       type="text"
                                       size="20"
                                       maxlength="45"
                                       required
                                       value="${requestScope.cliente.sobrenome}"
                                       class="form-control"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="alinharDireita">Data de Nascimento:</td>
                            <td>
                                <fmt:formatDate 
                                    pattern="yyyy-MM-dd"
                                    value="${requestScope.cliente.dataNascimento}"
                                    var="data" scope="page"/>
                                <input name="dataNascimento"
                                       type="date"
                                       size="8"
                                       placeholder="dd/mm/yyyy"
                                       required
                                       value="${data}"
                                       class="form-control"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="alinharDireita">CPF:</td>
                            <td>
                                <input name="cpf"
                                       type="text"
                                       size="13"
                                       pattern="\d{3}.\d{3}.\d{3}-\d{2}"
                                       placeholder="999.999.999-99"
                                       required
                                       value="${requestScope.cliente.cpf}"
                                       class="form-control"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="alinharDireita">E-mail:</td>
                            <td>
                                <input name="email"
                                       type="email"
                                       size="20"
                                       maxlength="60"
                                       required
                                       value="${requestScope.cliente.email}"
                                       class="form-control"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="alinharDireita">Logradouro:</td>
                            <td>
                                <input name="logradouro"
                                       type="text"
                                       size="25"
                                       maxlength="50"
                                       required
                                       value="${requestScope.cliente.logradouro}"
                                       class="form-control"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="alinharDireita">Número:</td>
                            <td>
                                <input name="numero"
                                       type="text"
                                       size="6"
                                       maxlength="6"
                                       required
                                       value="${requestScope.cliente.numero}"
                                       class="form-control"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="alinharDireita">Bairro:</td>
                            <td>
                                <input name="bairro"
                                       type="text"
                                       size="15"
                                       maxlength="30"
                                       value="${requestScope.cliente.bairro}"
                                       class="form-control"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="alinharDireita">CEP:</td>
                            <td>
                                <input name="cep"
                                       type="text"
                                       size="7"
                                       pattern="\d{5}-\d{3}"
                                       placeholder="99999-999"
                                       required
                                       value="${requestScope.cliente.cep}"
                                       class="form-control"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="alinharDireita">Cidade:</td>
                            <td>

                                <jsp:useBean
                                    id="servicos"
                                    scope="page"
                                    class="locacaomidias.servicos.CidadeServices"
                                    />

                                <select name="idCidade" required class="form-control">
                                    <c:forEach items="${servicos.todos}" var="cidade">
                                        <c:choose>
                                            <c:when test="${requestScope.cliente.cidade.id eq cidade.id}">
                                                <option value="${cidade.id}" selected>
                                                    ${cidade.nome}
                                                </option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${cidade.id}">
                                                    ${cidade.nome}
                                                </option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>

                            </td>
                        </tr>

                    </table>
                    <div class="form-group" id="btn-save">
                        <input type="submit" class="btn btn-success"  value="Alterar"/>
                    </div>
                </form>

                </body>

                </html>
