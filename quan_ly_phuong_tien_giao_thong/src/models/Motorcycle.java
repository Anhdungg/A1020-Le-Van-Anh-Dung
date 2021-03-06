package models;

public class Motorcycle extends Vehicle {
    private String wattage;

    public Motorcycle(String licensePlates, String manufacturerName, String yearOfManufacture, String ownerName, String wattage) {
        super(licensePlates, manufacturerName, yearOfManufacture, ownerName);
        this.wattage = wattage;
    }

    public String getWattage() {
        return wattage;
    }

    public void setWattage(String wattage) {
        this.wattage = wattage;
    }

    public String writeData(){
        return this.getLicensePlates()+","+this.getManufacturerName()+","+this.getYearOfManufacture()+","
                +this.getOwnerName()+","+this.wattage;
    }

    @Override
    public String showInformation() {
        return "License Plates: " + getLicensePlates() +
                ", Manufacturer Name: " + getManufacturerName() +
                ", Year Of Manufacture: " + getYearOfManufacture() +
                ", Owner Name: " + getOwnerName() +
                ", Wattage: " + this.wattage;
    }

    @Override
    public String toString() {
        return this.showInformation();
    }
}
