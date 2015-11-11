/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DataConnect;

/**
 *
 * @author Míra
 */
public class LoginDao {

    public static boolean validate(String user, String password) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DataConnect.getConnection();
            ps = connection.prepareStatement("Select uname, password from Users where uname = ? and password = ?");

            ps.setString(1, user);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                //nalezen vysledek -> validni vstup
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Login error... " + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(connection);
        }
        return false;
    }

}
