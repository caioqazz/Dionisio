/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dionisio.model.dao;

import dionisio.connection.ConnectionFactory;
import dionisio.model.bean.Avaliação;
import dionisio.model.bean.Produção;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Caio
 */
public class ProduçãoDAO {

    public void create(Produção producao) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO produção (id_colheita,id_safra)VALUES(?,?)");
            stmt.setInt(1, producao.getId_colheita());
            stmt.setInt(2, producao.getId_safra());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar");
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public ArrayList<Produção> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Produção> producoes = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM produção");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produção producao = new Produção(rs.getInt(1), rs.getInt(2));
                producoes.add(producao);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return producoes;
    }

    public ArrayList<Integer> getIdColheita() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Integer> Ids = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT id FROM colheita");
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");

                Ids.add(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return Ids;
    }

    public ArrayList<Integer> getIdSafras() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Integer> Ids = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT id FROM safra");
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");

                Ids.add(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return Ids;
    }

    public void delete(int id_safra, int id_colheita) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM produção WHERE id_safra = ? AND id_colheita = ?");
            stmt.setInt(1, id_safra);
            stmt.setInt(2, id_colheita);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar");
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
