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
                    break;
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
}
