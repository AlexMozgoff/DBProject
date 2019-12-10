package main.java.database.objects;

public class Inspection {

    private int id;
    private String date;
    private String brand;
    private int mileage;
    private String equipment;
    private int seats;
    private int numberOfOwners;
    private String gearbox;
    private Float engineVolume;
    private String vin;

    public Inspection(int id, String date, String brand, int mileage, String equipment, int seats, int numberOfOwners, String gearbox, Float engineVolume, String vin) {
        this.id = id;
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

    public String getBrand() {
        return brand;
    }

    public int getId() {
        return id;
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
