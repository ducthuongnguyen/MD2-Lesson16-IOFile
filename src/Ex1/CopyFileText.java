package Ex1;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFileText {
    public static void main(String[] args) {
        createSourceFile();
        writeFile(readFile());
    }

    public static void createSourceFile() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Source.txt"));
            bufferedWriter.write("Thuong");
            bufferedWriter.write("Hue ty",1,4);
            bufferedWriter.newLine();
            bufferedWriter.write("Huong chi");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFile() {
        List<String> strings = new ArrayList<>();
        try {
            File file = new File("Source.txt");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader("Source.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                strings.add(line);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("File not found or error content!!!");
        }
        return strings;
    }

    public static void writeFile(List<String> strings) {
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter("Target.txt"));
            for (String element : strings) {
                fw.write(element);
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
