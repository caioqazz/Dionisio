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
public class Produção {

    int id_colheita;
    int id_safra;

    public Produção(int id_colheita, int id_safra) {
        this.id_colheita = id_colheita;
        this.id_safra = id_safra;
    }

    public int getId_colheita() {
        return id_colheita;
    }

    public void setId_colheita(int id_colheita) {
        this.id_colheita = id_colheita;
    }

    public int getId_safra() {
        return id_safra;
    }

    public void setId_safra(int id_safra) {
        this.id_safra = id_safra;
    }

}
