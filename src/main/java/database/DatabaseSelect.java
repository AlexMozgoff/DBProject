package main.java.database;

import main.java.database.entities.*;
import main.java.logic.Logic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseSelect {

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

    public DatabaseSelect() {
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

    public List<Client> getAllClients() {
        List<Client> clientList = new ArrayList<>();
        try {
            CallableStatement cs = connection.prepareCall("{call SelectAllClients()}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Client client = new Client(
                        rs.getInt("Id"),
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

    public List<Auto> getAllAutos() {
        List<Auto> autoList = new ArrayList<>();
        try {
            CallableStatement cs = connection.prepareCall("{call SelectAllAuto()}");
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
            }
            return autoList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
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

    public List<Inspection> getAllInspections() {
        List<Inspection> inspections = new ArrayList<>();
        try {
            CallableStatement cs = connection.prepareCall("{call SelectInspections()}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Inspection inspection = new Inspection(
                        rs.getInt("CarId"),
                        rs.getString("Date"),
                        rs.getInt("Mileage"),
                        rs.getString("Equipment"),
                        rs.getInt("Seats"),
                        rs.getInt("NumberOfOwners"),
                        rs.getString("Gearbox"),
                        rs.getFloat("EngineVolume"),
                        rs.getString("VIN")
                );
                inspections.add(inspection);
            }
            return inspections;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
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

    public List<TestDrive> getAllTestDrives() {
        List<TestDrive> testDrives = new ArrayList<>();
        try {
            CallableStatement cs = connection.prepareCall("{call SelectAllTestDrives()}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                TestDrive testDrive = new TestDrive(
                        rs.getInt("CarID"),
                        rs.getString("Brand"),
                        rs.getString("Name"),
                        rs.getString("Surname"),
                        rs.getString("Date")
                );
                testDrives.add(testDrive);
            }
            return testDrives;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
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

    public List<CarPurchaseAgreement> getAllPurchaseAgreements() {
        List<CarPurchaseAgreement> carPurchaseAgreementList = new ArrayList<>();
        try {
            CallableStatement cs = connection.prepareCall("{call SelectCarPurchaseAgreements()}");
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
            return carPurchaseAgreementList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<CarSellAgreement> getCarSellAgreementList(int dealerId) {
        List<CarSellAgreement> carSellAgreementList = new ArrayList<>();
        try {
            CallableStatement cs = connection.prepareCall("{call SelectCarSellAgreements(?)}");
            cs.setInt(1, dealerId);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                CarSellAgreement carSellAgreement = new CarSellAgreement(
                        rs.getInt("ClientId"),
                        rs.getInt("CarId"),
                        rs.getString("Date"),
                        rs.getInt("Commission"),
                        rs.getString("Remark")
                );
                carSellAgreementList.add(carSellAgreement);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return carSellAgreementList;
    }

    public List<CarSellAgreement> getAllSellAgreements() {
        List<CarSellAgreement> carSellAgreementList = new ArrayList<>();
        try {
            CallableStatement cs = connection.prepareCall("{call SelectAllCarSellAgreements()}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                CarSellAgreement carSellAgreement = new CarSellAgreement(
                        rs.getInt("ClientId"),
                        rs.getInt("CarId"),
                        rs.getString("Date"),
                        rs.getInt("Commission"),
                        rs.getString("Remark")
                );
                carSellAgreementList.add(carSellAgreement);
            }
            return carSellAgreementList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
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

    public int getAutoId(Auto auto) {
        try {
            CallableStatement cs = connection.prepareCall("{call SelectAutoId(?,?,?,?,?,?)}");
            cs.setInt(1, auto.getDealerId());
            cs.setString(2, auto.getBrand());
            cs.setInt(3, auto.getDateOfRelease());
            cs.setInt(4, auto.getMileage());
            cs.setInt(5, auto.getPrice());
            cs.setBoolean(6, auto.isSold());
            ResultSet rs = cs.executeQuery();
            int id = 0;
            while (rs.next()) {
                id = rs.getInt("Id");
            }
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public int getClientId(Client client) {
        try {
            CallableStatement cs = connection.prepareCall("{call SelectClient(?,?,?,?,?,?)}");
            cs.setString(1, client.getName());
            cs.setString(2, client.getSurname());
            cs.setString(3, client.getPatronymic());
            cs.setString(4, client.getCity());
            cs.setString(5, client.getAddress());
            cs.setString(6, client.getPhone());
            ResultSet rs = cs.executeQuery();
            int id = 0;
            while (rs.next()) {
                id = rs.getInt("Id");
            }
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public int getDealerId(Dealer dealer) {
        try {
            CallableStatement cs = connection.prepareCall("{call SelectDealerId(?,?,?,?,?)}");
            cs.setString(1, dealer.getSurname());
            cs.setString(2, dealer.getName());
            cs.setString(3, dealer.getPatronymic());
            cs.setString(4, dealer.getAddress());
            cs.setString(5, dealer.getPhone());
            ResultSet rs = cs.executeQuery();
            int id = 0;
            while (rs.next()) {
                id = rs.getInt("Id");
            }
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public boolean getCarIsSold(int carId) {
        try {
            CallableStatement cs = connection.prepareCall("{call SelectCarIsSold(?)}");
            cs.setInt(1, carId);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                return rs.getBoolean("IsSold");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    public int getSellAgreementId(CarSellAgreement carSellAgreement) {
        Date date = Logic.getDateFromDate(carSellAgreement.getDate());
        try {
            CallableStatement cs = connection.prepareCall("{call SelectSellAgreementId(?,?,?,?,?)}");
            cs.setInt(1, carSellAgreement.getClientId());
            cs.setInt(2, carSellAgreement.getCarId());
            cs.setDate(3, date);
            cs.setInt(4, carSellAgreement.getCommission());
            cs.setString(5, carSellAgreement.getRemark());
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                return rs.getInt("Id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public int getPurchaseAgreementId(CarPurchaseAgreement carPurchaseAgreement) {
        Date date = Logic.getDateFromDate(carPurchaseAgreement.getDate());
        try {
            CallableStatement cs = connection.prepareCall("{call SelectPurchaseAgreementId(?,?,?,?)}");
            cs.setInt(1, carPurchaseAgreement.getCarId());
            cs.setDate(2, date);
            cs.setInt(3, carPurchaseAgreement.getCommission());
            cs.setString(4, carPurchaseAgreement.getRemark());
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                return rs.getInt("Id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public int getAmountOfAgreements(int dealerId) {
        try {
            CallableStatement cs = connection.prepareCall("{call SelectAmountOfAgreements(?)}");
            cs.setInt(1, dealerId);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                return rs.getInt(1) - 1;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
