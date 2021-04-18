package dbUtil;

import edu.alenkin.Library.Config;
import edu.alenkin.Library.ConnectionFactory;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbHelper {

    public <T> List<T> execute(String s, BeanReader<T> beanReader, ParamSetuper param) {
        List<T> result = new ArrayList<>();
        try(Connection conn = Config.get().getConnectionFactory().getConnection()) {
            Statement stmt = conn.createStatement();
            PreparedStatement prepSt = conn.prepareStatement(s);
            if (param !=null) {
               param.setParams(prepSt);
            }
            ResultSet rs = prepSt.executeQuery();

            while (rs.next()) {
                result.add(beanReader.readFromDb(rs));
            }
            return result;
        } catch (NamingException | SQLException ex) {
           Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public <T> List<T> execute(String s, BeanReader<T> beanReader) {
        return execute(s, beanReader, null);
    }


}


