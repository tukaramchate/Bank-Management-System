package system;

import java.sql.*;

public class Con {
    public Connection connection; // Public field for database connection
    public Statement statement;  // Public field for executing SQL queries

    public Con() {
        try {
            // Establish the database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem", "root", "math#1206*B");
            // Create a statement object to execute queries
            statement = connection.createStatement();
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            System.err.println("Database connection failed! Please check your connection details.");
            e.printStackTrace();
        }
    }
}
