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
        <title>Nova Locação</title>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="${cp}/js/libs/jquery/jquery.min.js"></script>
        <script src="${cp}/js/libs/decimal.js/decimal.min.js"></script>
        <script src="${cp}/js/formularios/locacao/novo.js"></script>
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
                        <li><a href="${cp}/formularios/locacao/listagem.jsp">Voltar</a></li>
                    </ul>
                </div>
            </div>
        </header>

        <div class="front-page"></div>

        <section class="section-information fundo">
            <div class="container" style="background:#d9d9d9">
                <div class="row title-section" id="programa-trainee">
                    <h1 class="title form-signin">Nova locação</h1>
                </div>


                <form id="formNovaLocacao" method="post" action="${cp}/processaLocacao" sytle="width:100%;">

                    <input name="acao" type="hidden" value="inserir"/>
                    <input id="hiddenItensLocacao" name="itensLocacao" type="hidden"/>
                    <div id="divItensLocacao">
                        <table class="form-signin">
                            <tr>
                            <div class="form-group" style="width: 80%; margin-left: 10%">
                                <div id="divCliente">
                                    <jsp:useBean 
                                        id="servicosC" 
                                        scope="page" 
                                        class="locacaomidias.servicos.ClienteServices"/>

                                    Cliente:
                                    <br>
                                    <select id="selectCliente" name="idCliente" required class="form-control" >
                                        <c:forEach items="${servicosC.todos}" var="cliente">
                                            <option value="${cliente.id}">
                                                ${cliente.nome} ${cliente.sobrenome}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <td>
                                    <jsp:useBean 
                                        id="servicosE" 
                                        scope="page" 
                                        class="locacaomidias.servicos.ExemplarServices"/>
                                    <p>
                                        Exemplar:
                                        <br>
                                        <select id="selectExemplar" class="form-control" style="width: 100%;">
                                            <c:forEach items="${servicosE.todos}" var="exemplar">

                                                <fmt:formatNumber
                                                    pattern="#.##"
                                                    minIntegerDigits="1"
                                                    minFractionDigits="2"
                                                    maxFractionDigits="2"
                                                    var="valorLocacao"
                                                    scope="page"
                                                    value="${exemplar.midia.classificacaoInterna.valorAluguel}"/>

                                                <option value="${exemplar.codigo_interno}"
                                                        data-valor="${exemplar.midia.classificacaoInterna.valorAluguel}"
                                                        data-descricao="${exemplar.midia.titulo}">
                                                    ${exemplar.codigo_interno} - 
                                                    ${exemplar.midia.titulo}
                                                    (R$ ${exemplar.midia.classificacaoInterna.valorAluguel})
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </p>
                                </td>
                            </div>
                            <tr>
                                <td>
                                    Data Início:
                                    <input class="form-control" name="dataInicio"
                                           type="date"
                                           size="8"
                                           placeholder="dd/mm/yyyy"
                                           required/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Data Fim:
                                    <input class="form-control" name="dataFim"
                                           type="date"
                                           size="8"
                                           placeholder="dd/mm/yyyy"
                                           required/>
                                </td>
                            </tr>
                            <div class="form-group ">
                                <td class="btnsItensLocacao p-5" style="width: 80%">
                                    <p><input class="form-control" id="btnInserir" type="button" value="&#x2795;"></p>
                                    <p><input class="form-control" id="btnRemover" type="button" value="&#x2796;"></p>
                                    <p><input class="form-control" id="btnLimpar" type="button" value="&#x274C;"></p>
                                </td>
                            </div>
                            <div class="form-group">
                                <tr>
                                <td>
                                    
                                    <br>
                                    <p>Itens da Locação:</p>
                                    <select id="selectItensLocacao" size="10" multiple>
                                    </select>
                                    <br>
                                    <div>
                                        <div id="divTotal">Total: R$ 0,00</div>
                                    </div>
                                </td>
                                </tr>
                            </div>

                            </tr>
                        </table>
                    </div>
                    <div class="form-group" id="btn-save">
                        <input type="submit" class="btn btn-success" value="Salvar"/>
                    </div>
                </form>
            </div> 
        </section>
    </body>
</html>
