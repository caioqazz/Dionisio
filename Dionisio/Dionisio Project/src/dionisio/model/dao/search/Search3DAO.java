/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dionisio.model.dao.search;

import dionisio.connection.ConnectionFactory;
import dionisio.model.bean.search.Search3;
import dionisio.model.dao.CepaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Caio
 */
public class Search3DAO {

    public ArrayList<Search3> read(String ano) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Search3> searchs = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT 	dionisio.propriedade.nome, sum(dionisio.safra.quantidade)\n"
                    + "FROM 	dionisio.propriedade, dionisio.parreiral,dionisio.colheita, dionisio.produção, dionisio.safra\n"
                    + "WHERE	dionisio.parreiral.nome_propriedade=dionisio.propriedade.nome and\n"
                    + "		colheita.id_parreiral=dionisio.parreiral.id and\n"
                    + "        dionisio.produção.id_colheita=dionisio.colheita.id and\n"
                    + "        dionisio.safra.id=dionisio.produção.id_safra and\n"
                    + "        dionisio.colheita.data_colheita like '"+ano+"%'\n"
                    + " GROUP BY dionisio.propriedade.nome;");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Search3 search = new Search3(rs.getString(1), rs.getInt(2));

                searchs.add(search);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return searchs;
    }

    public ArrayList<String> allYears() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<String> years = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT DISTINCT YEAR(  dionisio.colheita.data_colheita)"
                    + " FROM dionisio.colheita  ORDER BY year(dionisio.colheita.data_colheita) ;");
            rs = stmt.executeQuery();

            while (rs.next()) {
                String year = rs.getString(1);

                years.add(year);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return years;

    }

}
