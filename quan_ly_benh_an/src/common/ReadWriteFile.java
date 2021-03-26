package common;

import java.io.*;

public class ReadWriteFile {
    public String writeFile(String path, String data, boolean append){
        try {
            FileWriter fileWriter;
            String dataFile = this.readFile(path);
            System.out.println(dataFile);
            final String NEW_LINE = "\n";
            switch (dataFile){
                case "":
                case "File not found":
                case "File cannot be read":
                    fileWriter = new FileWriter(path, false);
                    break;
                default:
                    fileWriter = new FileWriter(path, append);
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
        try{
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((str = bufferedReader.readLine()) != null){
                output.append(str).append("\n");
            }
            return output.toString();
        }catch (FileNotFoundException e){
            return "File not found";
        }catch (IOException ex){
            return "File cannot be read";
        }
    }

    public static void main(String[] args) {
        final String PATH_FILE_MEDICAL = "src\\data\\medical_records.csv";
        ReadWriteFile readWriteFile = new ReadWriteFile();
        System.out.println(readWriteFile.writeFile(PATH_FILE_MEDICAL, "1,BA-003,BN-003,Son,30/03/2021,30/03/2021," +
                "Om,VIP III,01/12/2021", false));
    }
}
