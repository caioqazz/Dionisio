/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dionisio.model.dao;

import dionisio.connection.ConnectionFactory;
import dionisio.model.bean.Avaliação;
import dionisio.model.bean.Cepa;
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
public class AvaliaçãoDAO {

    public void create(Avaliação avaliacao) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO avaliação (nome,nota,id_safra)VALUES(?,?,?)");
            stmt.setString(1, avaliacao.getNome());
            stmt.setInt(2, avaliacao.getNota());
            stmt.setInt(3, avaliacao.getId_safra());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar");
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public ArrayList<Avaliação> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Avaliação> avaliacaos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM avaliação");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Avaliação avaliacao = new Avaliação(rs.getString("nome"), rs.getInt(2), rs.getInt(3));
                avaliacaos.add(avaliacao);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return avaliacaos;
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

    public void deleteInfo(String nome, int nota, int id_safra) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM avaliação WHERE nome = ? AND nota= ? AND id_safra = ? ");
            stmt.setString(1, nome);
            stmt.setInt(2, nota);
            stmt.setInt(3, id_safra);
            //  stmt= con.prepareStatement("DELETE FROM avaliação WHERE nome="+nome+" AND nota= "+nota+ " AND id_safra="+id_safra+";");
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar");
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void update(Avaliação avaliacao) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE avaliação SET nota = ? WHERE nome= ? AND id_safra= ?");
            stmt.setString(2, avaliacao.getNome());
            stmt.setInt(1, avaliacao.getNota());
            stmt.setInt(3, avaliacao.getId_safra());
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
