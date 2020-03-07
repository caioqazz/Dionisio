/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dionisio.model.dao.search;

import dionisio.connection.ConnectionFactory;
import dionisio.model.bean.search.Search2;
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
public class Search2DAO {

    public ArrayList<Search2> read(int id,int order) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Search2> searchs = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT s.*,a.nota,v.nome\n"
                    + "FROM (dionisio.safra AS s LEFT OUTER JOIN dionisio.avaliação AS a ON a.id_safra=s.id)  JOIN  dionisio.vinho  AS v\n"
                    + "WHERE s.id_vinho= "+id+" AND v.id="+id+"\n"
                    + "ORDER BY "+orderFunc(order)+" DESC ;");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Search2 search = new Search2(rs.getInt("id"),rs.getString("ano"), rs.getInt("quantidade"), rs.getInt("id_vinho"), rs.getInt("nota"), rs.getString("nome"));

                searchs.add(search);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CepaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return searchs;
    }
    
    String orderFunc(int order){
        switch(order){
            case 0: return "s.quantidade";
            case 1: return "a.nota";
        }
        return "a.nota";
    }
}
