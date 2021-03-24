package controller;

import manage.ManageVehicle;

import java.util.Scanner;

public class ControllerVehicle {
    private final ManageVehicle manageVehicle = new ManageVehicle();

    public void displayMainMenu(Scanner input){
        while (true){
            System.out.print("1. Thêm phương tiện\n" +
                    "2. Hiển thị phương tiện\n" +
                    "3. Xoá phương tiện\n" +
                    "4. Thoát\n" +
                    "Chọn menu: ");
            String select = input.nextLine();
            switch (select){
                case "1":
                    if (this.addNewVehicle(input)){
                        break;
                    }else {
                        return;
                    }
                case "2":
                    break;
                case "3":
                case "4":
                    return;
                default:
                    System.out.println("Chọn sai. Hãy chọn lại");
            }
        }
    }

    private boolean addNewVehicle(Scanner input){
        String select;
        while (true){
            System.out.print("1. Thêm xe tải.\n" +
                    "2. Thêm ô tô.\n" +
                    "3. Thêm xe máy.\n" +
                    "4. Trở lại.\n" +
                    "5. Thoát.\n" +
                    "Chọn menu: ");
            select = input.nextLine();
            switch (select){
                case "1":
                    manageVehicle.addNewVehicle(input, "truck");
                    break;
                case "2":
                    if (this.addNewCar(input)){
                        break;
                    }else {
                        return false;
                    }
                case "3":
                    manageVehicle.addNewVehicle(input, "motorcycle");
                    break;
                case "4":
                    return true;
                case "5":
                    return false;
                default:
                    System.out.println("Chọn sai. Hãy chọn lại");
            }
        }
    }

    private boolean addNewCar(Scanner input){
        String select;
        while (true){
            System.out.print("1. Thêm xe du lịch.\n" +
                    "2. Thêm xe khách.\n" +
                    "3. Trở lại.\n" +
                    "4. Thoát.\n" +
                    "Chọn menu: ");
            select = input.nextLine();
            switch (select){
                case "1":
                    manageVehicle.addNewVehicle(input, "carA");
                    break;
                case "2":
                    manageVehicle.addNewVehicle(input, "carB");
                    break;
                case "3":
                    return true;
                case "4":
                    return false;
                default:
                    System.out.println("Chọn sai. Hãy chọn lại");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ControllerVehicle controller = new ControllerVehicle();
        controller.displayMainMenu(input);
    }
}
