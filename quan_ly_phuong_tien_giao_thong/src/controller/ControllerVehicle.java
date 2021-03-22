package controller;

import java.util.Scanner;

public class ControllerVehicle {
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
                    "4. Trở lại" +
                    "5. Thoát" +
                    "Chọn menu: ");
            select = input.nextLine();
            switch (select){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
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
}
