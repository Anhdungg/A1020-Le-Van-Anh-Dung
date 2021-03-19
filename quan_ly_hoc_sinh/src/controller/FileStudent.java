package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileStudent {
    private final String NEW_LINE = "\n";
    private final String LINK_SAVE_FILE = "src\\data\\Student.csv";
    private final String HEADER_FILE = "Id,Name,Gender,Day of birth,Class";

    public String writeFile(String data, boolean append){
        try {
            String dataFile = this.readFile();
            FileWriter fileWriter;
            if (dataFile.equals("") || dataFile.equals("File cannot be read")){
                fileWriter = new FileWriter(LINK_SAVE_FILE, false);
                fileWriter.write(HEADER_FILE);
                fileWriter.append(NEW_LINE);
            }else {
                fileWriter = new FileWriter(LINK_SAVE_FILE, append);
                if (!append){
                    fileWriter.write(HEADER_FILE);
                    fileWriter.append(NEW_LINE);
                }
            }
            fileWriter.append(data);
            fileWriter.append(NEW_LINE);
            fileWriter.close();
            return "Write file successful";
        }catch (IOException e){
            return "Write file failed";
        }
    }

    public String readFile(){
        StringBuilder output = new StringBuilder();
        String str;
        boolean statusRead = false;
        try {
            FileReader fileReader = new FileReader(LINK_SAVE_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((str = bufferedReader.readLine()) != null){
                if (statusRead){
                    output.append(str).append("\n");
                }
                statusRead = true;
            }
            return output.toString();
        }catch (IOException e){
            return "File cannot be read";
        }
    }

//    public static void main(String[] args) {
//        FileStudent file = new FileStudent();
//        System.out.println(file.writeFile("00001,Anh Dung,Male,05/11/1997,A0001G"));
//        System.out.println(file.writeFile("00002,Ngoc Anh,Female,09/01/1997,A0001G"));
//        System.out.println(file.writeFile("00003,Xuan Son,Male,23/07/1998,B0002H"));
//        System.out.println(file.writeFile("00004,Van Kien,Male,17/03/1998,B0002H"));
//        System.out.println(file.writeFile("00005,Thuy Tien,Female,29/02/2000,C1111L"));
//        System.out.println(file.writeFile("00006,Kim Oanh,Female,05/01/2000,A1111G"));
//        System.out.println(file.writeFile("00007,Dieu Linh,Female,14/05/1995,A2222M"));
//        System.out.println(file.writeFile("00008,Mai Thanh,Male,07/03/1995,A2222M"));
//        System.out.println(file.writeFile("00009,Van Dao,Male,30/04/1995,A2222M"));
//    }
}
