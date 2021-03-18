package controller;

import manage.ManageStudent;

import java.util.Scanner;

public class ControllerStudent {
    private final ManageStudent manage = new ManageStudent();
    public void displayMainMenu(Scanner input){
        while (true){
            System.out.print("1. Add student\n" +
                    "2. Show all student\n" +
                    "3. Edit student\n" +
                    "4. Delete student\n" +
                    "5. Search student\n" +
                    "6. Sort student\n" +
                    "7. Exit\n" +
                    "Please select menu: ");
            String select = input.nextLine();
            switch (select){
                case "1":
                    System.out.println(manage.addNewStudent(input) + "\n");
                    break;
                case "2":
                    System.out.println(manage.showAllStudent() + "\n");
                    break;
                case "3":
                    System.out.println(manage.editStudent(input) + "\n");
                    break;
                case "4":
                    System.out.println(manage.deleteStudent(input) + "\n");
                    break;
                case "5":
                    if (this.findStudent(input)){
                        break;
                    }else {
                        return;
                    }
                case "6":
                    if (this.sortStudent(input)){
                        break;
                    }else {
                        return;
                    }
                case "7":
                    return;
                default:
                    System.out.println("Error. Please select menu.");

            }
        }
    }

    private boolean findStudent(Scanner input){
        while (true){
            System.out.print("1. Search by Id\n" +
                    "2. Search by Name\n" +
                    "3. Search by Gender\n" +
                    "4. Search by Date of birth\n" +
                    "5. Search by Class\n" +
                    "6. Back\n" +
                    "7. Exit\n" +
                    "Please select menu: ");
            String select = input.nextLine();
            switch (select){
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                    System.out.println(manage.searchStudent(input, select) + "\n");
                    break;
                case "6":
                    return true;
                case "7":
                    return false;
                default:
                    System.out.println("Error. Please select menu.");
            }
        }
    }

    private boolean sortStudent(Scanner input){
        while (true){
            System.out.print("1. Sort by Id\n" +
                    "2. Sort by Name\n" +
                    "3. Sort by Gender\n" +
                    "4. Sort by Date of birth\n" +
                    "5. Sort by Class\n" +
                    "6. Back\n" +
                    "7. Exit\n" +
                    "Please select menu: ");
            String select = input.nextLine();
            switch (select){
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                    System.out.println(manage.sortStudent(select) + "\n");
                    break;
                case "6":
                    return true;
                case "7":
                    return false;
                default:
                    System.out.println("Error. Please select menu.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ControllerStudent controller = new ControllerStudent();
        controller.displayMainMenu(input);
    }
}
