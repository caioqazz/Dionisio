/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dionisio.model.dao.search;

import dionisio.connection.ConnectionFactory;
import dionisio.model.bean.search.Search4;
import dionisio.model.bean.search.Search5;
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
public class Search5DAO {

    public ArrayList<Search5> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Search5> searchs = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select	A.n as Cepa, year(A.c) as Colheita, max(A.q) as Quantidade\n"
                    + "from(\n"
                    + "	select	dionisio.colheita.cepa_nome as n, dionisio.colheita.data_colheita as c, sum(dionisio.safra.quantidade) as q\n"
                    + "	from 	dionisio.produção, dionisio.colheita, dionisio.safra\n"
                    + "	where	dionisio.colheita.id=dionisio.produção.id_colheita and\n"
                    + "			dionisio.safra.id=produção.id_safra\n"
                    + "	group by dionisio.colheita.cepa_nome, dionisio.colheita.data_colheita\n"
                    + "    order by q desc\n"
                    + ")as A\n"
                    + "\n"
                    + "group by A.n\n"
                    + "order by quantidade;");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Search5 search = new Search5(rs.getString(1), rs.getString(2), rs.getInt(3));

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
