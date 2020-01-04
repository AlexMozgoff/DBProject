package main.java.database;

import main.java.logic.Logic;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Date;

public class DatabaseDelete {

    private static final String connectionString =
            "jdbc:sqlserver://DESKTOP-02D4G7K;"
                    + "database=CarTrade;";
    private static Connection connection;

    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public DatabaseDelete() {
        try {
            connection = DriverManager.getConnection(connectionString, "User", "Root123");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteDealer(String login) {
        try {
            CallableStatement cs = connection.prepareCall("{call DeleteDealer(?)}");
            cs.setString(1, login);
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteClient(String surname, String name) {
        try {
            CallableStatement cs = connection.prepareCall("{call DeleteClient(?,?)}");
            cs.setString(1, surname);
            cs.setString(2, name);
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteAuto(int id) {
        try {
            CallableStatement cs = connection.prepareCall("{call DeleteAuto(?)}");
            cs.setInt(1, id);
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void deleteInspection(int carId) {
        try {
            CallableStatement cs = connection.prepareCall("{call DeleteInspection(?)}");
            cs.setInt(1, carId);
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteTestDrive(int carId, String date) {
        Date date1 = Logic.getDateFromDate(date);
        try {
            CallableStatement cs = connection.prepareCall("{call DeleteTestDrive(?,?)}");
            cs.setInt(1, carId);
            cs.setDate(2, date1);
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deletePurchaseAgreement(int carId) {
        try {
            CallableStatement cs = connection.prepareCall("{call DeletePurchaseAgreement(?)}");
            cs.setInt(1, carId);
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteSellAgreement(int carId) {
        try {
            CallableStatement cs = connection.prepareCall("{call DeleteSellAgreement(?)}");
            cs.setInt(1, carId);
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
