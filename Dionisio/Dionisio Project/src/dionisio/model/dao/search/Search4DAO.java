/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dionisio.model.dao.search;

import dionisio.connection.ConnectionFactory;
import dionisio.model.bean.search.Search3;
import dionisio.model.bean.search.Search4;
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
public class Search4DAO {

    public ArrayList<Search4> read(String nome) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Search4> searchs = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select 	distinct cepa.nome\n"
                    + "from 	dionisio.cepa, dionisio.parreiral\n"
                    + "where 	dionisio.cepa.nome=dionisio.parreiral.nome_cepa and\n"
                    + "		dionisio.parreiral.nome_propriedade =  \""+nome+"\";");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Search4 search = new Search4(rs.getString(1));

                searchs.add(search);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return searchs;
    }
}
