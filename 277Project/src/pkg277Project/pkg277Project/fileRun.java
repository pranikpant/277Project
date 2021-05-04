package pkg277Project;

import java.awt.Desktop;
import java.io.*;

public class fileRun {
    
    public static void main(String[] args) {

        Desktop desktop = Desktop.getDesktop();
        
        try {
            desktop.open(new File("C:\\Users\\Pranik\\Downloads\\CECS341_Lab5_Pant_Lam\\Lab_Report_6.docx"));
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}
