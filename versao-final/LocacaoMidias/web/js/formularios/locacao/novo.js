
$(() => {

    let itensLocacao = [];

    let fmtMoeda = new Intl.NumberFormat(
            "pt-BR", {
                style: "currency",
                currency: "BRL"
            }
    );

    let fmtNumero = new Intl.NumberFormat(
            "pt-BR", {
                minimumFractionDigits: 2,
                maximumFractionDigits: 2
            }
    );

    $("#btnInserir").on("click", event => {

        let $selectExemplar = $("#selectExemplar");
        let $txtQuantidade = $("#txtQuantidade");

        let codigo_interno = $selectExemplar.val();
        let valorAluguel = $selectExemplar.find(":selected").data("valor").toString();
        let descricao = $selectExemplar.find(":selected").data("descricao");

        if (valorAluguel.includes(",")) {
            valorAluguel = valorAluguel.replace(",", ".");
        }

        if (true) {
            let itemIgual = null;
            itensLocacao.some(item => {
                if (item.codigo_interno === codigo_interno) {
                    itemIgual = item;
                }
            });

            if (itemIgual == null) {
                itensLocacao.push({
                    codigo_interno: codigo_interno,
                    valorAluguel: valorAluguel,
                    descricao: descricao
                });
            }else{
               alert("O exemplar selecionado já se encontra na lista!"); 
            }
            
            atualizarGUI();
            $txtQuantidade.val("");

        } else {
            alert("Forneça uma quantidade maior que zero!");
        }

    });

    $("#btnRemover").on("click", event => {

        let selecao = $("#selectItensLocacao").val();

        if (selecao.length === 0) {
            alert("Selecione um item da locação para remover!");

        } else if (confirm("Deseja remover o(s) item(ns) da locação selecionado(s)?")) {

            for (let i = 0; i < selecao.length; i++) {

                for (let j = 0; j < itensLocacao.length; j++) {

                    let item = itensLocacao[j];

                    if (selecao[i] === item.codigo_interno) {

                        itensLocacao.splice(j, 1);
                        break;

                    }

                }

            }

            atualizarGUI();

        }

    });

    $("#btnLimpar").on("click", event => {
        if (confirm("Deseja remover todos os itens da locação?")) {
            itensLocacao = [];
            atualizarGUI();
        }
    });

    $("#formNovaLocacao").on("submit", event => {

        if ($("#selectItensLocacao > option").length === 0) {
            alert("Uma locação precisa conter pelo menos um item!");
            return false;
        }

        return true;

    });


    $("#txtQuantidade").on("keydown", event => {
        if (event.keyCode === 13) {
            event.preventDefault();
        }
    });

    let atualizarGUI = () => {

        let $select = $("#selectItensLocacao");
        let total = new Decimal(0);

        $select.html("");

        itensLocacao.forEach(item => {

            let valorItem = new Decimal(item.valorAluguel);

            $opt = $("<option></option>").
                    html(`${item.codigo_interno} - ` +
                            `${item.descricao} - ` +
                            `${fmtMoeda.format(valorItem)}`).
                    val(`${item.codigo_interno}`);

            $select.append($opt);
            total = total.plus(valorItem);

        });

        $("#divTotal").html("Total: " + fmtMoeda.format(total));
        $("#hiddenItensLocacao").val(JSON.stringify(itensLocacao));

    };

});
