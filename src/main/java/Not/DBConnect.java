package Not;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static Connection connection;


    private DBConnect() {

    }

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection("Jdbc:sqlite:nots111");
        }
        return connection;
    }
}


