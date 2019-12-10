package main.java.database.objects;

public class TestDrive {

    private int carId;
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

    public int getCarId() {
        return carId;
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
