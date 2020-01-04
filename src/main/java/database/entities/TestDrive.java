package main.java.database.entities;

public class TestDrive {

    private int carId;
    private int clientId;
    private String carBrand;
    private String clientName;
    private String clientSurname;
    private String date;

    public TestDrive(int carId, String carBrand, String clientName, String clientSurname, String date) {
        this.carId = carId;
        this.carBrand = carBrand;
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.date = date;
    }

    public TestDrive(int carId, int clientId, String date) {
        this.carId = carId;
        this.clientId = clientId;
        this.date = date;
    }

    public int getCarId() {
        return carId;
    }

    public int getClientId() {
        return clientId;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public String getDate() {
        return date;
    }
}
