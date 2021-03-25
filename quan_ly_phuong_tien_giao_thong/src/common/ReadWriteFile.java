package common;

import java.io.*;

public class ReadWriteFile {

    public String writeFile(String path, String headerFile, String data, boolean append){
        try {
            FileWriter fileWriter;
            String dataFile = this.readFile(path);
            final String NEW_LINE = "\n";
            switch (dataFile){
                case "":
                case "File not found":
                case "File cannot be read":
                    fileWriter = new FileWriter(path, false);
                    fileWriter.write(headerFile);
                    fileWriter.append(NEW_LINE);
                    break;
                default:
                    fileWriter = new FileWriter(path, append);
                    if (!append){
                        fileWriter.write(headerFile);
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

    public String readFile(String path){
        StringBuilder output = new StringBuilder();
        String str;
        boolean statusRead = false;
        try{
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((str = bufferedReader.readLine()) != null){
                if (statusRead){
                    output.append(str).append("\n");
                }
                statusRead = true;
            }
            return output.toString();
        }catch (FileNotFoundException e){
            return "File not found";
        }catch (IOException ex){
            return "File cannot be read";
        }
    }

//    public static void main(String[] args) {
//        final String PATH_FILE_TRUCK = "src\\data\\xeTai.csv";
//        final String PATH_FILE_CAR = "src\\data\\oto.csv";
//        final String PATH_FILE_MOTORCYCLE = "src\\data\\xeMay.csv";
//        final String HEADER_FILE_TRUCK = "License Plates,Manufacturer Name,Year Of Manufacture,Owner Name,Payload";
//        final String HEADER_FILE_CAR = "License Plates,Manufacturer Name,Year Of Manufacture,Owner Name,Type Car,Number Of Seats";
//        final String HEADER_FILE_MOTORCYCLE = "License Plates,Manufacturer Name,Year Of Manufacture,Owner Name,Wattage";
//        ReadWriteFile readWriteFile = new ReadWriteFile();
//        readWriteFile.writeFile(PATH_FILE_MOTORCYCLE, HEADER_FILE_MOTORCYCLE, "43-K1-678.56,Yamaha,2019,Nguyen Van A,100", true);
//        readWriteFile.writeFile(PATH_FILE_MOTORCYCLE, HEADER_FILE_MOTORCYCLE, "43-H1-345.89,Honda,2019,Nguyen Van B,150", true);
//        readWriteFile.writeFile(PATH_FILE_MOTORCYCLE, HEADER_FILE_MOTORCYCLE, "43-AK-765.23,Yamaha,2019,Nguyen Van C,50", true);
//    }
}
