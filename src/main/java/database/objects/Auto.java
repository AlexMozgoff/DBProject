package main.java.database.objects;

import java.util.Arrays;

public class Auto {

    private int id;
    private int dealerId;
    private String brand;
    private byte[] photo;
    private int dateOfRelease;
    private int mileage;
    private int price;
    private boolean isSold;

    public Auto(int id, int dealerId, String brand, byte[] photo, int dateOfRelease, int mileage, int price, boolean isSold) {
        this.id = id;
        this.dealerId = dealerId;
        this.brand = brand;
        this.photo = photo;
        this.dateOfRelease = dateOfRelease;
        this.mileage = mileage;
        this.price = price;
        this.isSold = isSold;
    }

    public int getId() {
        return id;
    }

    public int getDealerId() {
        return dealerId;
    }

    public String getBrand() {
        return brand;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public int getDateOfRelease() {
        return dateOfRelease;
    }

    public int getMileage() {
        return mileage;
    }

    public int getPrice() {
        return price;
    }

    public boolean isSold() {
        return isSold;
    }

    public String getInfo() {
        return "Auto{" +
                "id=" + id +
                ", dealerId=" + dealerId +
                ", brand='" + brand + '\'' +
                ", photo=" + Arrays.toString(photo) +
                ", dateOfRelease=" + dateOfRelease +
                ", mileage=" + mileage +
                ", price=" + price +
                ", isSold=" + isSold +
                '}';
    }
}
