package com;

import java.io.*;
import java.time.LocalDateTime;


public class Audit {

    private  static  FileWriter csvWriter;

    static {
        try {
            csvWriter = new FileWriter("audit.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String separator = ",";

    private Audit(){
    }


    public static void add(String clasa) throws IOException {

        String nameofCurrMethod = new Throwable().getStackTrace()[1]
                .getMethodName();

        String date = LocalDateTime.now().toString();
        String line = clasa + " " + nameofCurrMethod + separator + date + "\n";

        csvWriter.write(line);
        csvWriter.flush();
    }


}
