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
public class Avaliação {

    String nome;
    int nota;
    int id_safra;

    public Avaliação(String nome, int nota, int id_safra) {
        this.nome = nome;
        this.nota = nota;
        this.id_safra = id_safra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getId_safra() {
        return id_safra;
    }

    public void setId_safra(int id_safra) {
        this.id_safra = id_safra;
    }

}
