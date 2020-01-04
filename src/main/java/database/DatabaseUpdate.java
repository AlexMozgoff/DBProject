package main.java.database;

import main.java.database.entities.CarPurchaseAgreement;
import main.java.database.entities.CarSellAgreement;
import main.java.database.entities.Client;
import main.java.database.entities.Dealer;
import main.java.logic.Logic;

import java.sql.*;

public class DatabaseUpdate {
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

    public DatabaseUpdate() {
        try {
            connection = DriverManager.getConnection(connectionString, "User", "Root123");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateClient(int clientId, Client client) {
        try {
            CallableStatement cs = connection.prepareCall("{call UpdateClient(?,?,?,?,?,?,?)}");
            cs.setInt(1, clientId);
            cs.setString(2, client.getSurname());
            cs.setString(3, client.getName());
            cs.setString(4, client.getPatronymic());
            cs.setString(5, client.getCity());
            cs.setString(6, client.getAddress());
            cs.setString(7, client.getPhone());
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateDealer(int dealerId, Dealer dealer) {
        try {
            CallableStatement cs = connection.prepareCall("{call UpdateDealer(?,?,?,?,?,?)}");
            cs.setInt(1, dealerId);
            cs.setString(2, dealer.getSurname());
            cs.setString(3, dealer.getName());
            cs.setString(4, dealer.getPatronymic());
            cs.setString(5, dealer.getAddress());
            cs.setString(6, dealer.getPhone());
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateCarSold(int id) {
        try {
            CallableStatement cs = connection.prepareCall("{call UpdateDealersAutoIsSold(?)}");
            cs.setInt(1, id);
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateCarNotSold(int id) {
        try {
            CallableStatement cs = connection.prepareCall("{call UpdateDealersAutoNotSold(?)}");
            cs.setInt(1, id);
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateSellAgreement(int agreementId, CarSellAgreement agreement) {
        Date date = Logic.getDateFromDate(agreement.getDate());
        try {
            CallableStatement cs = connection.prepareCall("{call UpdateSellAgreement(?,?,?,?,?,?)}");
            cs.setInt(1, agreementId);
            cs.setInt(2, agreement.getClientId());
            cs.setInt(3, agreement.getCarId());
            cs.setDate(4, date);
            cs.setInt(5, agreement.getCommission());
            cs.setString(6, agreement.getRemark());
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updatePurchaseAgreement(int agreementId, CarPurchaseAgreement agreement) {
        Date date = Logic.getDateFromDate(agreement.getDate());
        try {
            CallableStatement cs = connection.prepareCall("{call UpdatePurchaseAgreement(?,?,?,?,?,?)}");
            cs.setInt(1, agreementId);
            cs.setInt(2, agreement.getCarId());
            cs.setString(3, agreement.getCarBrand());
            cs.setDate(4, date);
            cs.setInt(5, agreement.getCommission());
            cs.setString(6, agreement.getRemark());
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
