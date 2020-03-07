/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dionisio.model.dao;

import dionisio.connection.ConnectionFactory;
import dionisio.model.bean.Vinho;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Caio
 */
public class VinhoDAO {

    public void create(Vinho vinho) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO vinho (id,nome,classificação,rotulo)VALUES(?,?,?,?)");
            stmt.setInt(1, vinho.getId());
            stmt.setString(2, vinho.getNome());
            stmt.setInt(3, vinho.getClassificacao());
            stmt.setBytes(4, vinho.getRotulo());
            //  stmt.setBlob(4, b);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar");
            Logger.getLogger(VinhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public ArrayList<Vinho> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Vinho> vinhos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM vinho");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Vinho vinho = new Vinho();
                vinho.setId(rs.getInt("id"));
                vinho.setNome(rs.getString("nome"));
                vinho.setClassificacao(rs.getInt("classificação"));

                vinho.setRotulo(rs.getBytes(4));

                vinhos.add(vinho);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VinhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return vinhos;
    }

    public int readMaximalId() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int maximal = 0;
        try {
            stmt = con.prepareStatement("SELECT max(id) FROM vinho");
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
            stmt = con.prepareStatement("DELETE FROM vinho WHERE id = ? ");
            stmt.setInt(1, id);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO!!! Delete as safras de id de vinho=" + id + " para prosseguir");
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void update(Vinho vinho) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE vinho SET nome = ?,classificação= ?,rotulo= ? WHERE id = ?");
            stmt.setInt(4, vinho.getId());
            stmt.setString(1, vinho.getNome());
            stmt.setInt(2, vinho.getClassificacao());
            Blob b = null;
            stmt.setBlob(3, b);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizado");
            Logger.getLogger(VinhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}
