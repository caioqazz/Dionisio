/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dionisio.model.bean.search;

/**
 *
 * @author Caio
 */
public class Search2 {

    int id_safra;
    String ano;
     int qntd;
    int id_vinho;
    int nota;
    String nome;

    public Search2(int id_safra, String ano, int qntd, int id_vinho, int nota, String nome) {
        this.id_safra = id_safra;
        this.ano = ano;
        this.qntd = qntd;
        this.id_vinho = id_vinho;
        this.nota = nota;
        this.nome = nome;
    }

    public int getId_safra() {
        return id_safra;
    }

    public void setId_safra(int id_safra) {
        this.id_safra = id_safra;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getQntd() {
        return qntd;
    }

    public void setQntd(int qntd) {
        this.qntd = qntd;
    }

    public int getId_vinho() {
        return id_vinho;
    }

    public void setId_vinho(int id_vinho) {
        this.id_vinho = id_vinho;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



}
