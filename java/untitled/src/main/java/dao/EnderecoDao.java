package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EnderecoDao {

    private Connection connection;

    public EnderecoDao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javadb?useTimezone=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
