package main.java.database.entities;

public class CarSellAgreement {

    private int id;
    private int clientId;
    private int carId;
    private String date;
    private int commission;
    private String remark;

    public CarSellAgreement(int id, int clientId, int carId, String date, int commission, String remark) {
        this.id = id;
        this.clientId = clientId;
        this.carId = carId;
        this.date = date;
        this.commission = commission;
        this.remark = remark;
    }

    public CarSellAgreement(int clientId, int carId, String date, int commission, String remark) {
        this.clientId = clientId;
        this.carId = carId;
        this.date = date;
        this.commission = commission;
        this.remark = remark;
    }

    public int getClientId() {
        return clientId;
    }

    public int getCarId() {
        return carId;
    }

    public String getDate() {
        return date;
    }

    public int getCommission() {
        return commission;
    }

    public String getRemark() {
        return remark;
    }
}
