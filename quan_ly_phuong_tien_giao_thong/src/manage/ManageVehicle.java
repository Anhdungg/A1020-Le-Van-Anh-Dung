package manage;

import common.ReadWriteFile;

import java.util.Scanner;

public class ManageVehicle {
    private final ReadWriteFile readWriteFile = new ReadWriteFile();

    public void addNewVehicle(Scanner input, String typeVehicle){
        String licensePlates = checkInput(input, "licensePlates", typeVehicle);
        if (licensePlates.equals("exit")){
            return;
        }
        String manufacturerName = checkInput(input, "manufacturerName", typeVehicle);
        if (manufacturerName.equals("exit")){
            return;
        }
        String yearOfManufacture = checkInput(input, "yearOfManufacture", typeVehicle);
        if (yearOfManufacture.equals("exit")){
            return;
        }
        String ownerName = checkInput(input, "ownerName", typeVehicle);
        if (ownerName.equals("exit")){
            return;
        }
        switch (typeVehicle){
            case "carA":
            case "carB":
                String numberOfSeats = this.checkInput(input, "numberOfSeats", typeVehicle);
                if (numberOfSeats.equals("exit")){
                    return;
                }
                String typeCar = this.checkInput(input, "typeCar", typeVehicle);
                if (typeCar.equals("exit")){
                    return;
                }
                readWriteFile.writeFile("car", licensePlates+","+manufacturerName+","+yearOfManufacture
                        +","+ownerName+","+numberOfSeats+","+typeCar);
                break;
            case "truck":
                String payload = this.checkInput(input, "payload", typeVehicle);
                if (payload.equals("exit")){
                    return;
                }
                readWriteFile.writeFile("truck", licensePlates+","+manufacturerName+","+yearOfManufacture
                        +","+ownerName+","+payload);
                break;
            default:
                String wattage = this.checkInput(input, "wattage", typeVehicle);
                if (wattage.equals("exit")){
                    return;
                }
                readWriteFile.writeFile("motorcycle", licensePlates+","+manufacturerName+","+yearOfManufacture
                        +","+ownerName+","+wattage);
        }
    }

    private String checkInput(Scanner input, String type, String typeCar){
        String licensePlatesTruck = "^[\\d]{2}C-[\\d]{3}.[\\d]{2}$";
        String licensePlatesCarA = "^[\\d]{2}A-[\\d]{3}.[\\d]{2}$";
        String licensePlatesCarB = "^[\\d]{2}B-[\\d]{3}.[\\d]{2}$";
        String licensePlatesMotorcycle = "^[\\d]{2}-[A-Z][\\dA-Z]-[\\d]{3}.[\\d]{2}$";
        String checkYear = "^[\\d]{4}$";
        String checkName = "^[A-Z][a-z]*([\\s][A-Z][a-z]*)*$";
        String checkInteger = "^[\\d]+$";
        String checkDouble = "^[\\d]+.[\\d]+$";
        String checkTypeCar = "^(Xe khach|Xe du lich)$";
        String regex="";
        while (true) {
            switch (type) {
                case "licensePlates":
                    System.out.print("Biển số xe(nhập exit để thoát): ");
                    switch (typeCar) {
                        case "truck":
                            regex = licensePlatesTruck;
                            break;
                        case "carA":
                            regex = licensePlatesCarA;
                            break;
                        case "carB":
                            regex = licensePlatesCarB;
                            break;
                        case "motorcycle":
                            regex = licensePlatesMotorcycle;
                            break;
                    }
                    break;
                case "manufacturerName":
                    System.out.print("Nhà sản xuất(nhập exit để thoát): ");
                    regex = checkName;
                    break;
                case "yearOfManufacture":
                    System.out.print("Năm sản xuất(nhập exit để thoát): ");
                    regex = checkYear;
                    break;
                case "ownerName":
                    System.out.print("Tên chủ sở hữu(nhập exit để thoát): ");
                    regex = checkName;
                    break;
                case "numberOfSeats":
                    System.out.print("Số chỗ ngồi(nhập exit để thoát): ");
                    regex = checkInteger;
                    break;
                case "typeCar":
                    System.out.print("Kiểu xe(nhập exit để thoát): ");
                    regex = checkTypeCar;
                    break;
                case "payload":
                    System.out.print("Trọng tải(nhập exit để thoát): ");
                    regex = checkDouble;
                    break;
                case "wattage":
                    System.out.print("Công suất(nhập exit để thoát): ");
                    regex = checkDouble;
                    break;
            }
            String data = input.nextLine();
            if (data.equals("exit")){
                return data;
            }
            if (data.matches(regex)) {
                if (type.equals("numberOfSeats")) {
                    if (Integer.parseInt(data) < 4){
                        System.out.println("Số chỗ ngồi phải lớn hơn hoặc bằng 4.");
                    }else {
                        return data;
                    }
                }else {
                    return data;
                }
            }else {
                switch (type) {
                    case "licensePlates":
                        switch (typeCar) {
                            case "truck":
                                System.out.println("Lỗi. Biển số xe tải có format: XXC-XXX.XX (X: 0÷9).");
                                break;
                            case "carA":
                                System.out.println("Lỗi. Biển số xe du lịch có format: XXA-XXX.XX (X: 0÷9).");
                                break;
                            case "carB":
                                System.out.println("Lỗi. Biển số xe khách có format: XXB-XXX.XX (X: 0÷9).");
                                break;
                            case "motorcycle":
                                System.out.println("Lỗi. Biển số xe máy có format: XX-YZ-XXX.XX (X: 0÷9, Y= (Chữ cái" +
                                        " in hoa), Z= (0÷9) hoặc (Chữ cái in Hoa).");
                                break;
                        }
                        break;
                    case "manufacturerName":
                        System.out.println("Tên nhà sản xuất phải viết hoa kí tự đầu tiên và sau khoảng trắng.");
                        break;
                    case "yearOfManufacture":
                        System.out.println("Năm sản xuất phải có 4 chữ số.");
                        break;
                    case "ownerName":
                        System.out.println("Tên chủ sở hữu phải viết hoa kí tự đầu tiên và sau khoảng trắng.");
                        break;
                    case "numberOfSeats":
                        System.out.println("Số chỗ ngồi phải là số nguyên lớn hơn 4.");
                        break;
                    case "typeCar":
                        System.out.println("Kiểu xe phải là \"Xe du lich\" hoặc \"Xe khách\".");
                        regex = checkTypeCar;
                        break;
                    case "payload":
                        System.out.println("Trọng tải phải là số thực lớn hơn 0");
                        break;
                    case "wattage":
                        System.out.println("Công suất phải là số thực lớn hơn 0");
                        regex = checkDouble;
                        break;
                }
            }
        }
    }
}
