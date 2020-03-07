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
public class Terroir {
    String regiao;
    String solo;
    int altitude;
    int umidade;
    int indice_plu;
    float temperatura;
    String nome_propriedade;

    public Terroir(String regiao, String solo, int altitude, int umidade, int indice_plu, float temperatura, String nome_propriedade) {
        this.regiao = regiao;
        this.solo = solo;
        this.altitude = altitude;
        this.umidade = umidade;
        this.indice_plu = indice_plu;
        this.temperatura = temperatura;
        this.nome_propriedade = nome_propriedade;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getSolo() {
        return solo;
    }

    public void setSolo(String solo) {
        this.solo = solo;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public int getUmidade() {
        return umidade;
    }

    public void setUmidade(int umidade) {
        this.umidade = umidade;
    }

    public int getIndice_plu() {
        return indice_plu;
    }

    public void setIndice_plu(int indice_plu) {
        this.indice_plu = indice_plu;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public String getNome_propriedade() {
        return nome_propriedade;
    }

    public void setNome_propriedade(String nome_propriedade) {
        this.nome_propriedade = nome_propriedade;
    }
    
    
}
