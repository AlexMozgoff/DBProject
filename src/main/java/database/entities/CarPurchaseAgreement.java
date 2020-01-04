package main.java.database.entities;

public class CarPurchaseAgreement {

    private int carId;
    private String carBrand;
    private String date;
    private int commission;
    private String remark;

    public CarPurchaseAgreement(int carId, String carBrand, String date, int commission, String remark) {
        this.carId = carId;
        this.carBrand = carBrand;
        this.date = date;
        this.commission = commission;
        this.remark = remark;
    }

    public CarPurchaseAgreement(int carId, String date, int commission, String remark) {
        this.carId = carId;
        this.date = date;
        this.commission = commission;
        this.remark = remark;
    }

    public int getCarId() {
        return carId;
    }

    public String getCarBrand() {
        return carBrand;
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
