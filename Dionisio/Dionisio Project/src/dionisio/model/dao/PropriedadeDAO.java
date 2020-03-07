/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dionisio.model.dao;

import dionisio.connection.ConnectionFactory;
import dionisio.model.bean.Propriedade;
import java.sql.Connection;
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
public class PropriedadeDAO {

    public void create(Propriedade propriedade) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO propriedade (nome,adm,endereço)VALUES(?,?,?)");
            stmt.setString(1, propriedade.getNome());
            stmt.setString(2, propriedade.getAdm());
            stmt.setString(3, propriedade.getEndereço());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar");
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public ArrayList<Propriedade> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Propriedade> propriedades = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM propriedade");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Propriedade propriedade = new Propriedade(rs.getString("nome"), rs.getString("adm"), rs.getString("endereço"));

                propriedades.add(propriedade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return propriedades;
    }

    public void delete(String nome) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM propriedade WHERE nome = ? ");
            stmt.setString(1, nome);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO!!\n" + "Delete os terroir da " + nome + " para prosseguir");
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void update(Propriedade propriedade) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE propriedade SET adm = ?, endereço = ? WHERE nome = ? ");
            stmt.setString(3, propriedade.getNome());
            stmt.setString(1, propriedade.getAdm());
            stmt.setString(2, propriedade.getEndereço());
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
