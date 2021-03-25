package models;

public class Truck extends Vehicle {
    private String payload;

    public Truck(String licensePlates, String manufacturerName, String yearOfManufacture, String ownerName,
                 String payload) {
        super(licensePlates, manufacturerName, yearOfManufacture, ownerName);
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String writeData(){
        return this.getLicensePlates()+","+this.getManufacturerName()+","+this.getYearOfManufacture() +","
                +this.getOwnerName()+","+this.payload;
    }

    @Override
    public String showInformation() {
        return "License Plates: " + getLicensePlates() +
                ", Manufacturer Name: " + getManufacturerName() +
                ", Year Of Manufacture: " + getYearOfManufacture() +
                ", Owner Name: " + getOwnerName() +
                ", Payload: " + this.payload;
    }

    @Override
    public String toString() {
        return this.showInformation();
    }
}
