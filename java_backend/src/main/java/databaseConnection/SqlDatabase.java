package databaseConnection;

import java.sql.*;

public class SqlDatabase {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(e + "\n Failed to load api.databaseConnection driver, shutting down ...");
            System.exit(-1);
        }
    }

    private final String url, user, password;

    SqlDatabase(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
