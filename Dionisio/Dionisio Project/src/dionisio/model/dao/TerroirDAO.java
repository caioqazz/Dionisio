/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dionisio.model.dao;

import dionisio.connection.ConnectionFactory;
import dionisio.model.bean.Telefone;
import dionisio.model.bean.Terroir;
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
public class TerroirDAO {

    public void create(Terroir terroir) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO terroir (região,solo,altitude,umidade,indice_pluviometrico,temp,nome_propriedade)VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1, terroir.getRegiao());
            stmt.setString(2, terroir.getSolo());
            stmt.setInt(3, terroir.getAltitude());
            stmt.setInt(4, terroir.getUmidade());
            stmt.setInt(5, terroir.getIndice_plu());
            stmt.setFloat(6, terroir.getTemperatura());
            stmt.setString(7, terroir.getNome_propriedade());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar");
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public ArrayList<Terroir> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Terroir> terroirs = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM terroir");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Terroir terroir = new Terroir(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getFloat(6), rs.getString(7));
                terroirs.add(terroir);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return terroirs;
    }

    public ArrayList<String> getNomes() {
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

    public void delete(String região) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM terroir WHERE região = ? ");
            stmt.setString(1, região);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar");
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void update(Terroir terroir) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE terroir SET solo=? ,altitude=? ,umidade=? ,indice_pluviometrico=?, temp=?, nome_propriedade=? WHERE região = ?");
            stmt.setString(7, terroir.getRegiao());
            stmt.setString(1, terroir.getSolo());
            stmt.setInt(2, terroir.getAltitude());
            stmt.setInt(3, terroir.getUmidade());
            stmt.setInt(4, terroir.getIndice_plu());
            stmt.setFloat(5, terroir.getTemperatura());
            stmt.setString(6, terroir.getNome_propriedade());
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
