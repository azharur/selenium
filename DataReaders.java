package demo;

import java.util.List;

public class DataReaders {

    public static void main(String[] args) {
        //readCSV();
        readXLS();

    }

    private static void readCSV() {
        String filename = "C:\\Users\\ABC\\Documents\\Selenium\\UserAccounts.csv";
        List<String[]> records = utilities.CSV.get(filename);
        for (String[] record : records) {
            for (String field : record) {
                System.out.println(field);
            }
        }
    }

    public static void readXLS() {
        String filename = "C:\\Users\\ABC\\Documents\\Selenium\\UserLogin.xls";
        String[][] data = utilities.Excel.get(filename);
        for (String[] record : data) {

            System.out.println(record[0]);
            System.out.println(record[1]);
            System.out.println(record[2]);
           // System.out.println(record[3]);


        }
    }
}



