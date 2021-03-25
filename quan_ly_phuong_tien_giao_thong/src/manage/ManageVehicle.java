package manage;

import common.ReadWriteFile;
import models.Car;
import models.Manufacturer;
import models.Motorcycle;
import models.Truck;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageVehicle {
    private final String PATH_FILE_TRUCK = "src\\data\\xeTai.csv";
    private final String PATH_FILE_CAR = "src\\data\\oto.csv";
    private final String PATH_FILE_MOTORCYCLE = "src\\data\\xeMay.csv";
    private final String PATH_FILE_MANUFACTURER = "src\\data\\hangSanXuat.csv";
    private final String HEADER_FILE_TRUCK = "License Plates,Manufacturer Name,Year Of Manufacture,Owner Name,Payload";
    private final String HEADER_FILE_CAR = "License Plates,Manufacturer Name,Year Of Manufacture,Owner Name,Type Car,Number Of Seats";
    private final String HEADER_FILE_MOTORCYCLE = "License Plates,Manufacturer Name,Year Of Manufacture,Owner Name,Wattage";
    private final ReadWriteFile readWriteFile = new ReadWriteFile();
    private ArrayList<Object> listVehicle = new ArrayList<>();
    private ArrayList<Manufacturer> listManufacturer = new ArrayList<>();

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
                if (typeVehicle.equals("carA")){
                    System.out.println(readWriteFile.writeFile(PATH_FILE_CAR, HEADER_FILE_CAR, licensePlates+","
                            +manufacturerName+","+yearOfManufacture +","+ownerName+","+numberOfSeats+",Xe du lich", true));
                }else {
                    System.out.println(readWriteFile.writeFile(PATH_FILE_CAR, HEADER_FILE_CAR, licensePlates+","
                            +manufacturerName+","+yearOfManufacture +","+ownerName+","+numberOfSeats+",Xe khach", true));
                }
                break;
            case "truck":
                String payload = this.checkInput(input, "payload", typeVehicle);
                if (payload.equals("exit")){
                    return;
                }
                System.out.println(readWriteFile.writeFile(PATH_FILE_TRUCK, HEADER_FILE_TRUCK, licensePlates+","
                        +manufacturerName+","+yearOfManufacture +","+ownerName+","+payload, true));
                break;
            default:
                String wattage = this.checkInput(input, "wattage", typeVehicle);
                if (wattage.equals("exit")){
                    return;
                }
                System.out.println(readWriteFile.writeFile(PATH_FILE_MOTORCYCLE, HEADER_FILE_MOTORCYCLE,
                        licensePlates+","+manufacturerName+","+yearOfManufacture +","+ownerName+","+wattage, true));
        }
    }

    private String checkInput(Scanner input, String type, String typeCar){
        String licensePlatesTruck = "^[\\d]{2}C-[\\d]{3}.[\\d]{2}$";
        String licensePlatesCarA = "^[\\d]{2}A-[\\d]{3}.[\\d]{2}$";
        String licensePlatesCarB = "^[\\d]{2}B-[\\d]{3}.[\\d]{2}$";
        String licensePlatesMotorcycle = "^[\\d]{2}-[A-Z][\\dA-Z]-[\\d]{3}.[\\d]{2}$";
        String checkManufacturerName = "^[A-Z0-9][\\w]*$";
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
                    regex = checkManufacturerName;
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
                switch (type) {
                    case "numberOfSeats":
                        if (Integer.parseInt(data) < 4) {
                            System.out.println("Số chỗ ngồi phải lớn hơn hoặc bằng 4.");
                        } else {
                            return data;
                        }
                        break;
                    case "licensePlates":
                        this.updateListVehicle();
                        if (this.findLicensePlates(data) != -1) {
                            System.out.println("Biển số xe đã tồn tại");
                        } else {
                            return data;
                        }
                        break;
                    case "manufacturerName":
                        this.updateListManufacturer();
                        if (this.findManufacturerName(data) == -1) {
                            System.out.println("Tên nhà sản xuất không tồn tại");
                        } else {
                            return data;
                        }
                        break;
                    default:
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
                        System.out.println("Tên nhà sản xuất phải viết hoa kí tự đầu tiên.");
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

    public String showInformation(String typeVehicle){
        StringBuilder output = new StringBuilder();
        ArrayList<Object> list = this.getListVehicle(typeVehicle);
        switch (typeVehicle){
            case "truck":
                output.append("Truck: ");
                break;
            case "motorcycle":
                output.append("Motorcycle: ");
                break;
            default:
                output.append("Car: ");
        }
        if (list == null){
            return output.append("no data").toString();
        }else {
            output.append(list.size()).append(" available\n");
        }
        for (int i=0; i<list.size(); i++){
            output.append(i+1).append(". ");
            if (list.get(i) instanceof Truck){
                Truck truck = (Truck) list.get(i);
                output.append(truck);
            }else if (list.get(i) instanceof Motorcycle){
                Motorcycle motorcycle = (Motorcycle) list.get(i);
                output.append(motorcycle);
            }else {
                Car car = (Car) list.get(i);
                output.append(car);
            }
            output.append("\n");
        }
        return output.substring(0, output.length()-1);
    }

    public String deleteVehicle(Scanner input) throws NotFoundVehicleException {
        this.updateListVehicle();
        System.out.print("Nhập biển số xe: ");
        String licensePlates = input.nextLine();
        if (this.listVehicle != null){
            int local = this.findLicensePlates(licensePlates);
            if (local!=-1){
                return confirmDelete(input, this.listVehicle, local);
            }
        }
        throw new NotFoundVehicleException();
    }

    private String confirmDelete(Scanner input, ArrayList<Object> list, int local){
        String select;
        while (true){
            System.out.print("Yes/No: ");
            select = input.nextLine();
            switch (select){
                case "yes":
                    list.remove(local);
                    String dataWrite = this.convertListToString("truck");
                    if(readWriteFile.writeFile(PATH_FILE_TRUCK, HEADER_FILE_TRUCK, dataWrite, false).equals("Write file failed")){
                        return "Write file failed";
                    }
                    dataWrite = this.convertListToString("motorcycle");
                    if (readWriteFile.writeFile(PATH_FILE_MOTORCYCLE, HEADER_FILE_MOTORCYCLE, dataWrite,
                            false).equals("Write file failed")){
                        return "Write file failed";
                    }
                    dataWrite = this.convertListToString("car");
                    if (readWriteFile.writeFile(PATH_FILE_CAR, HEADER_FILE_CAR, dataWrite, false).equals("Write file failed")){
                        return "Write file failed";
                    }
                    return "Write file successful";
                case "no":
                    return "";
                default:
                    System.out.println("Chọn sai. Hãy chọn lại\n");
            }
        }
    }

    private int findLicensePlates(String licensePlates){
        if (this.listVehicle!=null) {
            for (int i = 0; i < this.listVehicle.size(); i++) {
                if (this.listVehicle.get(i) instanceof Truck){
                    Truck truck = (Truck) this.listVehicle.get(i);
                    if (truck.getLicensePlates().equals(licensePlates)){
                        return i;
                    }
                }else if (this.listVehicle.get(i) instanceof Motorcycle){
                    Motorcycle motorcycle = (Motorcycle) this.listVehicle.get(i);
                    if (motorcycle.getLicensePlates().equals(licensePlates)){
                        return i;
                    }
                }else{
                    Car car = (Car) this.listVehicle.get(i);
                    if (car.getLicensePlates().equals(licensePlates)){
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    private String convertListToString(String vehicle){
        StringBuilder output = new StringBuilder();
        for (Object object : this.listVehicle){
            switch (vehicle) {
                case "truck":
                    if (object instanceof Truck) {
                        Truck truck = (Truck) object;
                        output.append(truck.writeData()).append("\n");
                    }
                    break;
                case "motorcycle":
                    if (object instanceof Motorcycle) {
                        Motorcycle motorcycle = (Motorcycle) object;
                        output.append(motorcycle.writeData()).append("\n");
                    }
                    break;
                default:
                    if(object instanceof Car) {
                        Car car = (Car) object;
                        output.append(car.writeData()).append("\n");
                    }
            }
        }
        return output.substring(0, output.length()-1);
    }

    private ArrayList<Object> getListVehicle(String typeVehicle){
        String data;
        StringBuilder str = new StringBuilder();
        ArrayList<Object> list = new ArrayList<>();
        switch (typeVehicle){
            case "truck":
                data = readWriteFile.readFile(PATH_FILE_TRUCK);
                break;
            case "motorcycle":
                data = readWriteFile.readFile(PATH_FILE_MOTORCYCLE);
                break;
            default:
                data = readWriteFile.readFile(PATH_FILE_CAR);
        }
        if (data.length()<1){
            return null;
        }
        for (int i=0; i<data.length(); i++){
            if ((int)data.charAt(i) == 10 || (int)data.charAt(i) == 13){
                String[] strings = str.toString().split(",");
                switch (typeVehicle){
                    case "truck":
                        list.add(new Truck(strings[0], strings[1], strings[2], strings[3], strings[4]));
                        break;
                    case "motorcycle":
                        list.add(new Motorcycle(strings[0], strings[1], strings[2], strings[3], strings[4]));
                        break;
                    default:
                        list.add(new Car(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5]));
                        break;
                }
                str = new StringBuilder();
                continue;
            }
            str.append(data.charAt(i));
        }
        return list;
    }

    private void updateListVehicle(){
        this.listVehicle.clear();
        ArrayList<Object> list = this.getListVehicle("truck");
        if (list != null){
            this.listVehicle.addAll(list);
        }
        list = this.getListVehicle("motorcycle");
        if (list != null){
            this.listVehicle.addAll(list);
        }
        list = this.getListVehicle("car");
        if (list != null){
            this.listVehicle.addAll(list);
        }
    }

    public void updateListManufacturer(){
        String data = readWriteFile.readFile(PATH_FILE_MANUFACTURER);
        StringBuilder str = new StringBuilder();
        for (int i=0; i<data.length(); i++){
            if ((int)data.charAt(i) == 10 || (int)data.charAt(i) == 13){
                String[] strings = str.toString().split(",");
                this.listManufacturer.add(new Manufacturer(strings[0], strings[1], strings[2]));
                str = new StringBuilder();
                continue;
            }
            str.append(data.charAt(i));
        }
    }

    private int findManufacturerName(String manufacturerName){
        for (int i=0; i<this.listManufacturer.size(); i++){
            if (this.listManufacturer.get(i).getManufacturerName().equals(manufacturerName)){
                return i;
            }
        }
        return -1;
    }
//    public static void main(String[] args) {
//        ManageVehicle manage = new ManageVehicle();
//        System.out.println(manage.getListVehicle("car"));
//        System.out.println("Convert: ");
//        System.out.println(manage.convertListToString(manage.getListVehicle("car")));
//    }
}
