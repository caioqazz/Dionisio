/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dionisio.model.dao;

import dionisio.connection.ConnectionFactory;
import dionisio.model.bean.Safra;
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
public class SafraDAO {

    public void create(Safra safra) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO safra (id,ano,quantidade,id_vinho)VALUES(?,?,?,?)");
            stmt.setInt(1, safra.getId());
            stmt.setString(2, safra.getAno());
            stmt.setInt(3, safra.getQntd());
            stmt.setInt(4, safra.getId_vinho());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar");
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public ArrayList<Safra> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Safra> safras = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM safra");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Safra safra = new Safra(rs.getInt("id"), rs.getString("ano"), rs.getInt("quantidade"), rs.getInt("id_vinho"));

                safras.add(safra);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return safras;
    }

    public ArrayList<Integer> getIdVinhos() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Integer> Ids = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT id FROM vinho");
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

    public int readMaximalId() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int maximal = 0;
        try {
            stmt = con.prepareStatement("SELECT max(id) FROM safra");
            rs = stmt.executeQuery();

            while (rs.next()) {
                maximal = rs.getInt("max(id)");

            }
        } catch (SQLException ex) {
            Logger.getLogger(VinhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return maximal;
    }

    public void delete(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM safra WHERE id = ? ");
            stmt.setInt(1, id);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO!!! Delete as produções de id de safra=" + id + " para prosseguir");
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void update(int id, int quantidade) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE safra SET quantidade= ? where id = ? ");
            stmt.setInt(1, quantidade);
            stmt.setInt(2, id);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterado");
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
