/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dionisio.model.bean;

import java.sql.Date;

/**
 *
 * @author Caio
 */
public class Parreiral {

    int id;
    int qntd;
    int area;
    String data;
    String nome_prop;
    String nome_cepa;

    public Parreiral(int id, int qntd, int area, String data, String nome_prop, String nome_cepa) {
        this.id = id;
        this.qntd = qntd;
        this.area = area;
        this.data = data;
        this.nome_prop = nome_prop;
        this.nome_cepa = nome_cepa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQntd() {
        return qntd;
    }

    public void setQntd(int qntd) {
        this.qntd = qntd;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNome_prop() {
        return nome_prop;
    }

    public void setNome_prop(String nome_prop) {
        this.nome_prop = nome_prop;
    }

    public String getNome_cepa() {
        return nome_cepa;
    }

    public void setNome_cepa(String nome_cepa) {
        this.nome_cepa = nome_cepa;
    }

}
