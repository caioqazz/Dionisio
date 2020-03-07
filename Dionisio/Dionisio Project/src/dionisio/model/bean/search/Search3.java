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
public class Search3 {

    String nome;
    int sum;

    public Search3(String nome, int sum) {
        this.nome = nome;
        this.sum = sum;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

}
