package locacaodvds.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(
                "jdbc:mariadb://localhost/locacao_dvds",
                "root",
                "senha" );

    }

}
