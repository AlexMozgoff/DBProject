package main.java.database;

import main.java.database.objects.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

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

    public Database() {
        try {
            connection = DriverManager.getConnection(connectionString, "User", "Root123");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Client> getClientsList() {
        List<Client> clientList = new ArrayList<>();
        try {
            CallableStatement cs = connection.prepareCall("{call SelectAllClients()}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Client client = new Client(
                        rs.getString("Surname"),
                        rs.getString("Name"),
                        rs.getString("Patronymic"),
                        rs.getString("City"),
                        rs.getString("Address"),
                        rs.getString("Phone"));
                clientList.add(client);
                System.out.println(client.getInfo());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clientList;
    }

    public List<Dealer> getDealersList() {
        List<Dealer> dealerList = new ArrayList<>();
        try {
            CallableStatement cs = connection.prepareCall("{call SelectAllDealers()}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Dealer dealer = new Dealer(
                        rs.getString("Surname"),
                        rs.getString("Name"),
                        rs.getString("Patronymic"),
                        rs.getBytes("Photo"),
                        rs.getString("Address"),
                        rs.getString("Phone"),
                        rs.getString("Login"));
                dealerList.add(dealer);
                System.out.println(dealer.getInfo());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dealerList;
    }

    public List<Auto> getDealersAuto(int dealerId) {
        List<Auto> autoList = new ArrayList<>();
        try {
            CallableStatement cs = connection.prepareCall("{call SelectAllDealersAuto(?)}");
            cs.setInt(1, dealerId);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Auto auto = new Auto(
                        rs.getInt("Id"),
                        rs.getInt("DealerId"),
                        rs.getString("Brand"),
                        rs.getBytes("Photo"),
                        rs.getInt("DateOfRelease"),
                        rs.getInt("Mileage"),
                        rs.getInt("Price"),
                        rs.getBoolean("IsSold"));
                autoList.add(auto);
                System.out.println(auto.getInfo());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return autoList;
    }

    public List<Inspection> getInspections(int dealerId) {
        List<Inspection> inspectionList = new ArrayList<>();
        try {
            CallableStatement cs = connection.prepareCall("{call SelectAllInspections(?)}");
            cs.setInt(1, dealerId);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Inspection inspection = new Inspection(
                        rs.getInt("Id"),
                        rs.getString("Date"),
                        rs.getString("Brand"),
                        rs.getInt("Mileage"),
                        rs.getString("Equipment"),
                        rs.getInt("Seats"),
                        rs.getInt("NumberOfOwners"),
                        rs.getString("Gearbox"),
                        rs.getFloat("EngineVolume"),
                        rs.getString("VIN")
                );
                inspectionList.add(inspection);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return inspectionList;
    }

    public List<TestDrive> getTestDriveList(int dealerId) {
        List<TestDrive> testDriveList = new ArrayList<>();
        try {
            CallableStatement cs = connection.prepareCall("{call SelectTestDrives(?)}");
            cs.setInt(1, dealerId);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                TestDrive testDrive = new TestDrive(
                        rs.getInt("CarID"),
                        rs.getString("Brand"),
                        rs.getString("Name"),
                        rs.getString("Surname"),
                        rs.getString("Date")
                );
                testDriveList.add(testDrive);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return testDriveList;
    }

    public List<CarPurchaseAgreement> getCarPurchaseAgreementList(int dealerId) {
        List<CarPurchaseAgreement> carPurchaseAgreementList = new ArrayList<>();
        try {
            CallableStatement cs = connection.prepareCall("{call SelectAllCarPurchaseAgreements(?)}");
            cs.setInt(1, dealerId);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                CarPurchaseAgreement carPurchaseAgreement = new CarPurchaseAgreement(
                        rs.getInt("CarId"),
                        rs.getString("Brand"),
                        rs.getString("Date"),
                        rs.getInt("Commission"),
                        rs.getString("Remark")
                );
                carPurchaseAgreementList.add(carPurchaseAgreement);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return carPurchaseAgreementList;
    }


    public String getUserPassword(String login) {
        try {
            CallableStatement cs = connection.prepareCall("{call SelectUserPassword(?)}");
            cs.setString(1, login);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                return rs.getString("Password");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String getUserRole(String login) {
        try {
            CallableStatement cs = connection.prepareCall("{call SelectUserRole(?)}");
            cs.setString(1, login);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                return rs.getString("Role");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int getUserId(String login) {
        try {
            CallableStatement cs = connection.prepareCall("{call SelectUserId(?)}");
            cs.setString(1, login);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                return rs.getInt("Id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
