package manage;

import java.util.Scanner;

public class ManageVehicle {
    public boolean addNewVehicle(Scanner input, String typeVehicle){
        String licensePlates = checkInput(input, "licensePlates");
        String manufacturerName = checkInput(input, "manufacturerName");
        String yearOfManufacture = checkInput(input, "yearOfManufacture");
        String ownerName = checkInput(input, "ownerName");
        if (licensePlates.equals("-1") || manufacturerName.equals("-1") || yearOfManufacture.equals("-1") || ownerName.equals("-1")){
            return false;
        }
        switch (typeVehicle){
            case "car":
                String numberOfSeats = this.checkInput(input, "numberOfSeats");
                String typeCar = this.checkInput(input, )
                break;
            case "truck":
                break;
            default:


        }
        return true;
    }

    private String checkInput(Scanner input, String type){
        return "false";
    }
}
