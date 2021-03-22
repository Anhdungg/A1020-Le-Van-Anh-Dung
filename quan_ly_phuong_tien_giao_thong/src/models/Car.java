package models;

public class Car extends Vehicle {
    private String numberOfSeats;
    private String typeCar;

    public Car(String licensePlates, String manufacturerName, String yearOfManufacture, String ownerName,
               String numberOfSeats, String typeCar) {
        super(licensePlates, manufacturerName, yearOfManufacture, ownerName);
        this.numberOfSeats = numberOfSeats;
        this.typeCar = typeCar;
    }

    public String getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(String numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    @Override
    public String showInformation() {
        return "License Plates: " + getLicensePlates() +
                ", Manufacturer Name: " + getManufacturerName() +
                ", Year Of Manufacture: " + getYearOfManufacture() +
                ", Owner Name: " + getOwnerName() +
                ", Number Of Seats: " + numberOfSeats +
                ", Type Car: " + typeCar;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "numberOfSeats='" + numberOfSeats + '\'' +
                ", typeCar='" + typeCar + '\'' +
                '}';
    }
}
