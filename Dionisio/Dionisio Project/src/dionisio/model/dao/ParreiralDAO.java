/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dionisio.model.dao;

import dionisio.connection.ConnectionFactory;
import dionisio.model.bean.Parreiral;
import dionisio.model.bean.Telefone;
import java.sql.Connection;
import java.sql.Date;
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
public class ParreiralDAO {

    public void create(Parreiral parreiral) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO parreiral (id,qtd_vinhas,area,data_plantio,nome_propriedade,nome_cepa)VALUES(?,?,?,?,?,?)");
            stmt.setInt(1, parreiral.getId());
            stmt.setInt(2, parreiral.getQntd());
            stmt.setInt(3, parreiral.getArea());
            stmt.setString(4, parreiral.getData());
            stmt.setString(5, parreiral.getNome_prop());
            stmt.setString(6, parreiral.getNome_cepa());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar");
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public ArrayList<Parreiral> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Parreiral> parreirals = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM parreiral");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Parreiral parreiral = new Parreiral(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6));

                parreirals.add(parreiral);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return parreirals;
    }

    public int readMaximalId() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int maximal = 0;
        try {
            stmt = con.prepareStatement("SELECT max(id) FROM parreiral");
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

    public ArrayList<String> getNomesPropriedade() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<String> nomes = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT nome FROM propriedade");
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

    public void deleteParreiral(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM parreiral WHERE id = ? ");
            stmt.setInt(1, id);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar");
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void update(Parreiral parreiral) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE parreiral SET qtd_vinhas = ?,area= ? ,data_plantio = ?,nome_propriedade = ?,nome_cepa = ? WHERE id = ?");
            stmt.setInt(6, parreiral.getId());
            stmt.setInt(1, parreiral.getQntd());
            stmt.setInt(2, parreiral.getArea());
            stmt.setString(3, parreiral.getData());
            stmt.setString(4, parreiral.getNome_prop());
            stmt.setString(5, parreiral.getNome_cepa());
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
