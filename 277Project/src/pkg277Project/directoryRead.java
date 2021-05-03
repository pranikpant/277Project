package pkg277Project;

import java.io.*;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;

public class directoryRead {
    
    public static void main(String[] args) {
        File file = new File("C:\\");
        File[] files;
        files = file.listFiles();

        for (int i = 0; i < files.length; i++) {
            SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
            DecimalFormat size = new DecimalFormat("#,###");
            if (files[i].isDirectory()) {
                System.out.println("Directory:" + files[i].getAbsolutePath() + " Date: " + date.format(files[i].lastModified()) + " Size: " + size.format(files[i].length()));
            } else {
                System.out.println("File:" + files[i].getAbsolutePath() + " Date: " + date.format(files[i].lastModified()) + " Size: " + size.format(files[i].length()));
            }
        }
    }
}   
