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
public class Search5 {

    String cepa;
    String ano;
    int qntd;

    public Search5(String cepa, String ano, int qntd) {
        this.cepa = cepa;
        this.ano = ano;
        this.qntd = qntd;
    }

    public String getCepa() {
        return cepa;
    }

    public void setCepa(String cepa) {
        this.cepa = cepa;
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

}
