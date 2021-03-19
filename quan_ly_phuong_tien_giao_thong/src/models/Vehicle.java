package models;

public abstract class Vehicle {
    private String licensePlates;
    private String manufacturerName;
    private String yearOfManufacture;
    private String ownerName;

    public Vehicle(String licensePlates, String manufacturerName, String yearOfManufacture, String ownerName) {
        this.licensePlates = licensePlates;
        this.manufacturerName = manufacturerName;
        this.yearOfManufacture = yearOfManufacture;
        this.ownerName = ownerName;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public abstract String showInformation();

    @Override
    public String toString() {
        return "License Plates: " + licensePlates +
                ", Manufacturer Name: " + manufacturerName +
                ", Year Of Manufacture: " + yearOfManufacture +
                ", Owner Name: " + ownerName;
    }
}
