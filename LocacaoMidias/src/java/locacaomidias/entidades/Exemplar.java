/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacaomidias.entidades;

/**
 *
 * @author Melissa
 */
public class Exemplar {
    private int codigo_interno;
    private boolean disponivel;
    private Midia midia;

    public int getCodigo_interno() {
        return codigo_interno;
    }

    public void setCodigo_interno(int codigo_interno) {
        this.codigo_interno = codigo_interno;
    }

    public boolean estaDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Midia getMidia() {
        return midia;
    }

    public void setMidia(Midia midia) {
        this.midia = midia;
    }
    
    
}
