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
public class Safra {

    int id;
    String ano;
    int qntd;
    int id_vinho;

    public Safra(int id, String ano, int qntd, int id_vinho) {
        this.id = id;
        this.ano = ano;
        this.qntd = qntd;
        this.id_vinho = id_vinho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

}
