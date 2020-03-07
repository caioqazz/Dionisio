/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dionisio.model.bean;

import java.io.InputStream;

/**
 *
 * @author Caio
 */
public class Vinho {

    int id;
    String nome;
    int classificacao;
    byte[] rotulo;

    public Vinho() {

    }

    public Vinho(int id, String nome, int classificacao) {
        this.id = id;
        this.nome = nome;
        this.classificacao = classificacao;
    }

    public Vinho(int id, String nome, int classificacao, byte[] rotulo) {
        this.id = id;
        this.nome = nome;
        this.classificacao = classificacao;
        this.rotulo = rotulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public byte[] getRotulo() {
        return rotulo;
    }

    public void setRotulo(byte[] rotulo) {
        this.rotulo = rotulo;
    }

}
