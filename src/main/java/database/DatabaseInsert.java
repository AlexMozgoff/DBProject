package main.java.database;


import main.java.database.entities.*;
import main.java.logic.Logic;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Date;


public class DatabaseInsert {

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

    public DatabaseInsert() {
        try {
            connection = DriverManager.getConnection(connectionString, "User", "Root123");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertDealer(Dealer dealer) {
        try {
            CallableStatement cs = connection.prepareCall("{call InsertDealerWithoutPhoto(?,?,?,?,?,?)}");
            cs.setString(1, dealer.getSurname());
            cs.setString(2, dealer.getName());
            cs.setString(3, dealer.getPatronymic());
            cs.setString(4, dealer.getAddress());
            cs.setString(5, dealer.getPhone());
            cs.setString(6, dealer.getLogin());
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertUser(User user) {
        try {
            CallableStatement cs = connection.prepareCall("{call InsertUser (?,?,?)}");
            cs.setString(1, user.getLogin());
            cs.setString(2, user.getPassword());
            cs.setString(3, user.getRole());
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertAuto(Auto auto) {
        try {
            CallableStatement cs = connection.prepareCall("{call InsertDealerAutoWithoutPhoto(?,?,?,?,?,?)}");
            cs.setInt(1, auto.getDealerId());
            cs.setString(2, auto.getBrand());
            cs.setInt(3, auto.getDateOfRelease());
            cs.setInt(4, auto.getMileage());
            cs.setInt(5, auto.getPrice());
            cs.setBoolean(6, auto.isSold());
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertClient(Client client) {
        try {
            CallableStatement cs = connection.prepareCall("{call InsertClient(?,?,?,?,?,?)}");
            cs.setString(1, client.getSurname());
            cs.setString(2, client.getName());
            cs.setString(3, client.getPatronymic());
            cs.setString(4, client.getCity());
            cs.setString(5, client.getAddress());
            cs.setString(6, client.getPhone());
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertInspection(Inspection inspection) {
        Date date = Logic.getDate(inspection.getDate());
        try {
            CallableStatement cs = connection.prepareCall("{call InsertInspection(?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, inspection.getCarId());
            cs.setDate(2, date);
            cs.setInt(3, inspection.getMileage());
            cs.setString(4, inspection.getEquipment());
            cs.setInt(5, inspection.getSeats());
            cs.setInt(6, inspection.getNumberOfOwners());
            cs.setString(7, inspection.getGearbox());
            cs.setFloat(8, inspection.getEngineVolume());
            cs.setString(9, inspection.getVin());
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertTestdrive(TestDrive testDrive) {
        Date date = Logic.getDate(testDrive.getDate());
        try {
            CallableStatement cs = connection.prepareCall("{call InsertTestDrive(?,?,?)}");
            cs.setInt(1, testDrive.getCarId());
            cs.setInt(2, testDrive.getClientId());
            cs.setDate(3, date);
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertCarPurchaseAgreement(CarPurchaseAgreement agreement) {
        Date date = Logic.getDate(agreement.getDate());
        try {
            CallableStatement cs = connection.prepareCall("{call InsertCarPurchaseAgreement(?,?,?,?)}");
            cs.setInt(1, agreement.getCarId());
            cs.setDate(2, date);
            cs.setInt(3, agreement.getCommission());
            cs.setString(4, agreement.getRemark());
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertCarSellAgreement(CarSellAgreement agreement) {
        Date date = Logic.getDate(agreement.getDate());
        try {
            CallableStatement cs = connection.prepareCall("{call InsertCarSellAgreement(?,?,?,?,?)}");
            cs.setInt(1, agreement.getClientId());
            cs.setInt(2, agreement.getCarId());
            cs.setDate(3, date);
            cs.setInt(4, agreement.getCommission());
            cs.setString(5, agreement.getRemark());
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
