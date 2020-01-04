package main.java.database.entities;

public class Inspection {

    private int carId;
    private String date;
    private String brand;
    private int mileage;
    private String equipment;
    private int seats;
    private int numberOfOwners;
    private String gearbox;
    private Float engineVolume;
    private String vin;

    public Inspection(int carId, String date, String brand, int mileage, String equipment, int seats, int numberOfOwners, String gearbox, Float engineVolume, String vin) {
        this.carId = carId;
        this.date = date;
        this.brand = brand;
        this.mileage = mileage;
        this.equipment = equipment;
        this.seats = seats;
        this.numberOfOwners = numberOfOwners;
        this.gearbox = gearbox;
        this.engineVolume = engineVolume;
        this.vin = vin;
    }

    public Inspection(int carId, String date, int mileage, String equipment, int seats, int numberOfOwners, String gearbox, Float engineVolume, String vin) {
        this.carId = carId;
        this.date = date;
        this.mileage = mileage;
        this.equipment = equipment;
        this.seats = seats;
        this.numberOfOwners = numberOfOwners;
        this.gearbox = gearbox;
        this.engineVolume = engineVolume;
        this.vin = vin;
    }

    public String getBrand() {
        return brand;
    }

    public int getCarId() {
        return carId;
    }

    public String getDate() {
        return date;
    }

    public int getMileage() {
        return mileage;
    }

    public String getEquipment() {
        return equipment;
    }

    public int getSeats() {
        return seats;
    }

    public int getNumberOfOwners() {
        return numberOfOwners;
    }

    public String getGearbox() {
        return gearbox;
    }

    public Float getEngineVolume() {
        return engineVolume;
    }

    public String getVin() {
        return vin;
    }
}
