package manage;

import common.ReadWriteFile;
import models.BenhAnThuong;
import models.BenhAnVIP;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageMedical {
    private final String PATH_FILE_MEDICAL = "src\\data\\medical_records.csv";
    private final ReadWriteFile readWriteFile = new ReadWriteFile();
    private static int stt = 1;
    public void addNewMedical(Scanner input, String typeMedical){
        String idMedical = this.checkInput(input, "idMedical", "");
        if (idMedical.equals("exit")){
            return;
        }
        String maBenhNhan = this.checkInput(input, "maBenhNhan", "");
        if (maBenhNhan.equals("exit")){
            return;
        }
        System.out.print("Tên bệnh nhân(nhập exit để thoát): ");
        String tenBenhNhan = input.nextLine();
        if (tenBenhNhan.equals("exit")){
            return;
        }
        String ngayNhapVien = this.checkInput(input, "ngayNhapVien", "");
        if (ngayNhapVien.equals("exit")){
            return;
        }
        String ngayRaVien = this.checkInput(input, "ngayRaVien", ngayNhapVien);
        if (ngayRaVien.equals("exit")){
            return;
        }
        System.out.print("Lý do nhập viện(nhập exit để thoát): ");
        String lyDoNhapVien = input.nextLine();
        if (lyDoNhapVien.equals("exit")){
            return;
        }
        String dataWrite = "";
        switch (typeMedical){
            case "thuong":
                System.out.print("Phí nằm viện(nhập exit để thoát): ");
                String phiNamVien = input.nextLine();
                if (phiNamVien.equals("exit")){
                    return;
                }
                dataWrite = stt+","+idMedical+","+maBenhNhan+","+tenBenhNhan+","+ngayNhapVien+","+ngayRaVien+","
                        +lyDoNhapVien+","+phiNamVien;
                System.out.println(readWriteFile.writeFile(PATH_FILE_MEDICAL, dataWrite, true));
                stt++;
                break;
            case "VIP":
                String loaiVIP = this.checkInput(input, "loaiVIP","");
                if (loaiVIP.equals("exit")){
                    return;
                }
                String thoiHan = this.checkInput(input, "thoiHan", "");
                if (thoiHan.equals("exit")){
                    return;
                }
                dataWrite = stt+","+idMedical+","+maBenhNhan+","+tenBenhNhan+","+ngayNhapVien+","+ngayRaVien+","
                        +lyDoNhapVien+","+loaiVIP+","+thoiHan;
                System.out.println(readWriteFile.writeFile(PATH_FILE_MEDICAL, dataWrite, true));
                stt++;
                break;
        }
    }

    private String checkInput(Scanner input, String type, String ngayNhapVien){
        String checkIdMedical = "^(BA-)[\\d]{3}$";
        String checkIdBenhNhan = "^(BN-)[\\d]{3}$";
        String checkDate = "^[0-3]\\d[/][0-1][0-9][/][0-9]{4}$";
        String checkVIP = "^(VIP I|VIP II|VIP III)$";
        String regex="";
        while (true) {
            switch (type) {
                case "idMedical":
                    System.out.print("Mã bệnh án(nhập exit để thoát): ");
                    regex = checkIdMedical;
                    break;
                case "maBenhNhan":
                    System.out.print("Mã bệnh nhân(nhập exit để thoát): ");
                    regex = checkIdBenhNhan;
                    break;
                case "ngayNhapVien":
                    System.out.print("Ngày nhập viện(nhập exit để thoát): ");
                    regex = checkDate;
                    break;
                case "ngayRaVien":
                    System.out.print("Ngày ra viện(nhập exit để thoát): ");
                    regex = checkDate;
                    break;
                case "thoiHan":
                    System.out.print("Thời hạn VIP(nhập exit để thoát): ");
                    regex = checkDate;
                    break;
                case "loaiVIP":
                    System.out.print("Loại VIP(nhập exit để thoát): ");
                    regex = checkVIP;
                    break;
            }
            String data = input.nextLine();
            if (data.equals("exit")) {
                return data;
            }
            if (data.matches(regex)) {
                if (type.equals("ngayRaVien")) {
                    if (this.soSanhNgay(ngayNhapVien, data) >= 0) {
                        return data;
                    } else {
                        System.out.println("Ngày ra viện phải lớn hơn ngày nhập viện");
                    }
                }else {
                    return data;
                }
            } else {
                switch (type) {
                    case "idMedical":
                        System.out.println("Mã bệnh án phải đúng định dạng BA-XXX, với XXX là các kí tự số");
                        break;
                    case "maBenhNhan":
                        System.out.println("Mã bệnh nhân phải đúng định dạng BN-XXX, với XXX là các kí tự số");
                        break;
                    case "loaiVIP":
                        System.out.println("Gói VIP chỉ được chọn 1 trong 3 gói: VIP I, VIP II, VIP III");
                        break;
                    default:
                        System.out.println("Ngày ra viện, ngày nhập viện và thời hạn gói VIP phải đúng định dạng dd/MM/yyyy");
                        break;

                }
            }
        }
    }

    private int soSanhNgay(String date1, String date2){
        String[] date1String = date1.split("/");
        String[] date2String = date2.split("/");
        int[] date1Int = new int[date1String.length];
        int[] date2Int = new int[date2String.length];
        for (int i=0; i<date1String.length; i++){
            date1Int[i] = Integer.parseInt(date1String[i]);
            date2Int[i] = Integer.parseInt(date2String[i]);
        }
        int value = Integer.compare(date2Int[2], date1Int[2]);
        if (value==0){
            int value1 = Integer.compare(date2Int[1], date1Int[1]);
            if (value1 == 0){
                return Integer.compare(date2Int[0], date1Int[0]);
            }
            return value1;
        }
        return value;
    }

    public String showInformation(){
        StringBuilder output = new StringBuilder();
        for (Object object: this.getList()){
            output.append(object);
        }
        return output.toString();
    }

    private ArrayList<Object> getList(){
        ArrayList<Object> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        String data = readWriteFile.readFile(PATH_FILE_MEDICAL);
        for (int i=0;i<data.length(); i++){
            if ((int)data.charAt(i) == 10 || (int)data.charAt(i) == 13){
                String[] strings = str.toString().split(",");
                if (strings.length==9){
                    list.add(new BenhAnVIP(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5],
                            strings[6], strings[7], strings[8]));
                }else {
                    list.add(new BenhAnThuong(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5],
                            strings[6], strings[7]));
                }
                str = new StringBuilder();
                continue;
            }
            str.append(data.charAt(i));
        }
        return list;
    }
}
