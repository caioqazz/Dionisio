/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dionisio.model.dao;

import dionisio.connection.ConnectionFactory;
import dionisio.model.bean.Colheita;
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
public class ColheitaDAO {

    public void create(Colheita colheita) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO colheita (id,data_colheita,material,i_maturação,f_maturação,id_parreiral,cepa_nome)VALUES(?,?,?,?,?,?,?)");
            stmt.setInt(1, colheita.getId());
            stmt.setString(2, colheita.getData());
            stmt.setInt(3, colheita.getMaterial());
            stmt.setString(4, colheita.getI_maturacao());
            stmt.setString(5, colheita.getF_maturacao());
            stmt.setInt(6, colheita.getId_parreiral());
            stmt.setString(7, colheita.getCepa_nome());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar");
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public ArrayList<Colheita> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Colheita> colheitas = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM colheita");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Colheita colheita = new Colheita(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));

                colheitas.add(colheita);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return colheitas;
    }

    public ArrayList<String> getNomesCepa() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<String> nomes = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT nome FROM cepa");
            rs = stmt.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");

                nomes.add(nome);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return nomes;
    }

    public int readMaximalId() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int maximal = 0;
        try {
            stmt = con.prepareStatement("SELECT max(id) FROM colheita");
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

    public ArrayList<Integer> getIdParreiral() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Integer> Ids = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT id FROM parreiral");
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

    public void deleteColheita(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM colheita WHERE id = ? ");
            stmt.setInt(1, id);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO!!! Delete as produções de id de colheita=" + id + " para prosseguir");
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void update(Colheita colheita) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE colheita SET data_colheita = ? , material = ?,i_maturação= ?,f_maturação = ? WHERE id= ?");
            stmt.setInt(5, colheita.getId());
            stmt.setString(1, colheita.getData());
            stmt.setInt(2, colheita.getMaterial());
            stmt.setString(3, colheita.getI_maturacao());
            stmt.setString(4, colheita.getF_maturacao());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizado");
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}
