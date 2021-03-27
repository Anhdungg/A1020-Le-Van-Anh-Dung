package controller;

import manage.ManageMedical;

import java.util.Scanner;

public class Controller {
    private final ManageMedical manageMedical = new ManageMedical();
    public void displayMainMenu(Scanner input){
        while (true){
            System.out.print("Chọn chức năng theo số (để tiếp tục):\n"+
                    "1. Thêm mới\n" +
                    "2. Xoá\n" +
                    "3. Xem danh sách các bệnh án\n" +
                    "4. Thoát\n" +
                    "Chọn chức năng: ");
            String select = input.nextLine();
            switch (select){
                case "1":
                    if (this.addNewMedical(input)){
                        break;
                    }else {
                        return;
                    }
                case "2":
                    System.out.println(manageMedical.xoaBenhAn(input));
                    break;
                case "3":
                    System.out.println(manageMedical.showInformation());
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Chọn sai. Hãy chọn lại\n");
            }
        }
    }

    private boolean addNewMedical(Scanner input){
        while (true){
            System.out.print("Chọn chức năng theo số (để tiếp tục):\n"+
                    "1. Thêm bệnh án thường\n" +
                    "2. Thêm bệnh án VIP\n" +
                    "3. Trở lại\n" +
                    "4. Thoát\n" +
                    "Chọn chức năng: ");
            String select = input.nextLine();
            switch (select){
                case "1":
                    manageMedical.addNewMedical(input, "thuong");
                    break;
                case "2":
                    manageMedical.addNewMedical(input, "VIP");
                    break;
                case "3":
                    return true;
                case "4":
                    return false;
                default:
                    System.out.println("Chọn sai. Hãy chọn lại\n");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Controller controller = new Controller();
        controller.displayMainMenu(input);
    }
}
