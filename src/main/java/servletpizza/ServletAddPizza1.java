package servletpizza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbconnect.pizza;

public class ServletAddPizza1 {

    public int registerPizza(pizza pizza) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO pizza" +
            "  (id, name, description, prix) VALUES " +
            " (?, ?, ?,?);";

        int result = 0;

        try (
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/pizzainnodb?useSSL=false", "root", "");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, pizza.getName());
            preparedStatement.setString(3, pizza.getDescription());
            preparedStatement.setString(4, pizza.getPrix());
            System.out.println(preparedStatement);
            
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
