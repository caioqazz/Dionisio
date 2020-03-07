/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dionisio.model.bean;

/**
 *
 * @author Caio
 */
public class Propriedade {

    String nome;
    String adm;
    String endereço;

    public Propriedade() {

    }

    public Propriedade(String nome, String adm, String endereço) {
        this.nome = nome;
        this.adm = adm;
        this.endereço = endereço;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAdm() {
        return adm;
    }

    public void setAdm(String adm) {
        this.adm = adm;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

}
