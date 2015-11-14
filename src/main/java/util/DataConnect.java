/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Míra
 */
public class DataConnect {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/smarthome");
            return connection;
        } catch (ClassNotFoundException ex) {
            System.out.println("Class.forName(\"com.mysql.jdbc.Driver\") error... " + ex.getMessage());
            return null;
        } catch (SQLException ex) {
            System.out.println("Database.getConnection() error... " + ex.getMessage());
            return null;
        }
    }

    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Connection.close() error... " + ex.getMessage());
        }
    }

}
