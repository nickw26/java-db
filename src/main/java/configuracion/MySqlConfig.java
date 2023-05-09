package configuracion;

import java.sql.*;

public class MySqlConfig {

    String host = "localhost:3306";
    String user = "root";
    String password = "root";
    String bd = "develop";


    public Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://"+host+"/"+bd+"?user="+user+"&password="+password;
        return DriverManager.getConnection(url);
    }

    public ResultSet getResulSet (CallableStatement callableStatement) throws SQLException {
        return callableStatement.executeQuery();
    }
}
