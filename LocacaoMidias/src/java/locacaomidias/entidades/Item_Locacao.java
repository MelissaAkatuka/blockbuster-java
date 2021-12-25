/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacaomidias.entidades;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Melissa
 */
public class Item_Locacao {
    @NotNull
    private int locacao_id;
    @NotNull
    private int exemplar_codigo_interno;
    private Double valor;

    public int getLocacao_id() {
        return locacao_id;
    }

    public void setLocacao_id(int locacao_id) {
        this.locacao_id = locacao_id;
    }

    public int getExemplar_codigo_interno() {
        return exemplar_codigo_interno;
    }

    public void setExemplar_codigo_interno(int exemplar_codigo_interno) {
        this.exemplar_codigo_interno = exemplar_codigo_interno;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
}
