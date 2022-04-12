package Ex2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCsv {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader("Country.csv"));

            while ((line = br.readLine()) != null) {
                Country country = parseToCountry(line);
                System.out.println(country);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
//    public static List<String> parseCsvLine(String csvLine) {
//        List<String> result = new ArrayList<>();
//        if (csvLine != null) {
//            String[] splitData = csvLine.split(",");
//            for (int i = 0; i < splitData.length; i++) {
//                result.add(splitData[i]);
//            }
//        }
//        return result;
//    }

//    private static void printCountry(List<String> country) {
//        System.out.println(
//                "Country [id= "
//                        + country.get(0)
//                        + ", code= " + country.get(1)
//                        + " , name=" + country.get(2)
//                        + "]");
//    }
//
    public static Country parseToCountry(String csvLine) {
        Country country = new Country();
        if (csvLine != null) {
            String[] splitData = csvLine.split(",");
            country.setId(Integer.parseInt(splitData[0]));
            country.setCode(splitData[1]);
            country.setName(splitData[2]);
        }
        return country;
    }
}
