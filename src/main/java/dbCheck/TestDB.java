package dbCheck;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestDB {
    public String check() {
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("jdbc/Library");
            Connection conn = ds.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT fio FROM author;");
            StringBuilder result = new StringBuilder();
            while (rs.next()) {
                result.append("<h3>" + rs.getString("fio")).append("</h3>");
            }
            return result.toString();
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}


