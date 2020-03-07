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
public class Colheita {

    int id;
    String data;
    int material;
    String i_maturacao;
    String f_maturacao;
    int id_parreiral;
    String cepa_nome;

    public Colheita(int id, String data, int material, String i_maturacao, String f_maturacao, int id_parreiral, String cepa_nome) {
        this.id = id;
        this.data = data;
        this.material = material;
        this.i_maturacao = i_maturacao;
        this.f_maturacao = f_maturacao;
        this.id_parreiral = id_parreiral;
        this.cepa_nome = cepa_nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getMaterial() {
        return material;
    }

    public void setMaterial(int material) {
        this.material = material;
    }

    public String getI_maturacao() {
        return i_maturacao;
    }

    public void setI_maturacao(String i_maturacao) {
        this.i_maturacao = i_maturacao;
    }

    public String getF_maturacao() {
        return f_maturacao;
    }

    public void setF_maturacao(String f_maturacao) {
        this.f_maturacao = f_maturacao;
    }

    public int getId_parreiral() {
        return id_parreiral;
    }

    public void setId_parreiral(int id_parreiral) {
        this.id_parreiral = id_parreiral;
    }

    public String getCepa_nome() {
        return cepa_nome;
    }

    public void setCepa_nome(String cepa_nome) {
        this.cepa_nome = cepa_nome;
    }

}
