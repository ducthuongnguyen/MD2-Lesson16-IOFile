package Practice2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<Integer> readFile(String filePath){
         List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);//doc file theo duong dan
            file.exists();
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine())!=null){
//                System.out.println( numbers.add(Integer.parseInt(line)));
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        }catch (Exception e){
            System.err.println("File not found or error content!!!");
        }
        return numbers;
    }

public  void writeFile(String filePath, int max){
        try {
            FileWriter writer = new FileWriter(filePath,true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Max is: "+ max);
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
}




}
