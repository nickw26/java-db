import configuracion.MySqlConfig;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        callSPExample();
    }
    
    public static void callSPExample() throws SQLException, ClassNotFoundException {

        MySqlConfig config = new MySqlConfig();

        String sqlToCallSP = "{call insertar_ciudad (?,?,?)}";
        Connection connection = config.getConnection();

        CallableStatement callableStatement = connection.prepareCall(sqlToCallSP);
        callableStatement.setString(1, "Arequipa");
        callableStatement.setString(2, "Perú");
        callableStatement.setString(3, "America");
        ResultSet rs = config.getResulSet(callableStatement);

        while(rs.next()) {
            System.out.println(rs.getString(1) + " " +
                    rs.getString(2) + " " +
                    rs.getString(3) + " " +
                    rs.getString(4) + " ");
        }
    }
}
